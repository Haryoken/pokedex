/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import pkm.dao.PokemonDAO;
import pkm.xml.object.Ability.xsd.Ability;
import pkm.xml.object.PokemonAbilities.xsd.PokemonAbilities;
import pkm.xml.object.PokemonList.xsd.Pokemon;
import pkm.xml.object.PokemonList.xsd.PokemonList;
import pkm.xml.object.PokemonTypes.xsd.PokemonType;
import pkm.xml.object.PokemonTypes.xsd.PokemonTypes;

/**
 *
 * @author DUCVINH
 */
public class DataCrawler {

    Pokemon pokemon;
    PokemonList pokemonList;
    PokemonAbilities pokemonAbilities;
    PokemonTypes pokemonTypes;

    public DataCrawler() {
        pokemon = new Pokemon();
        pokemonList = new PokemonList();
        pokemonAbilities = new PokemonAbilities();
        pokemonTypes = new PokemonTypes();

    }

    public PokemonList getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(PokemonList pokemonList) {
        this.pokemonList = pokemonList;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void crawlAllPokemonIdAndName() throws IOException, XMLStreamException {
        String urlString = "https://bulbapedia.bulbagarden.net/wiki/List_of_Pok%C3%A9mon_by_National_Pok%C3%A9dex_number";
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        System.setProperty("http.agent", "Chrome");
        connection.addRequestProperty("User-Agent", "Mozilla/4.76"); //Need modifying
        InputStream is = connection.getInputStream();

        XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_VALIDATING, false);
        factory.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);

        //USING Iterator
        //XMLEventReader reader = factory.createXMLEventReader(is, "UTF-8");
        XMLEventReader reader = factory.createXMLEventReader(new InputStreamReader(HTMLValidator.validateInputStream(is), "UTF-8"));
        XMLEvent event;

        StartElement startElement;
        Attribute attribute;

        boolean isNationalDexTag = false;
        boolean isPokemonNameTag = false;

        boolean isDexIdCollected = false;
        boolean isNameCollected = false;

        String xmlPath = "web/WEB-INF/xml/PokemonList.xml";
        String schemaPath = "web/WEB-INF/schemas/PokemonList.xsd";
        PokemonDAO pkmDao = new PokemonDAO();
        while (reader.hasNext()) {
            try {

                event = reader.nextEvent();

                if (event.isStartElement()) {
                    startElement = event.asStartElement();
                    String tagName = startElement.getName().toString();
                    //System.out.println(tagName); // For DEBUG Purporse

                    //Find the pokemon nationalDexId:
                    if (tagName.equals("td")) {
                        attribute = startElement.getAttributeByName(new QName("style"));
                        if (attribute != null && attribute.getValue().equals("font-family:monospace")) { // Ignore the first <td>.
                            event = reader.nextEvent();
                            while (true) { // This LOOP purpose is to ignore characterElement and endElement of the <td> above.
                                if (event.isStartElement()) {
                                    startElement = event.asStartElement();
                                    if (startElement.getName().toString().equals("td")) {
                                        attribute = startElement.getAttributeByName(new QName("style"));
                                        if (attribute != null && attribute.getValue().equals("font-family:monospace")) {
                                            isNationalDexTag = true;
                                            event = reader.nextEvent(); //must have 
                                        }
                                        if (event.isCharacters() && isNationalDexTag) {
                                            String idString = event.asCharacters().toString().trim();
                                            idString = idString.substring(1);
                                            //System.out.println(idString); //For DEBUG Purpose
                                            this.getPokemon().setNationalDexId(BigInteger.valueOf(Long.parseLong(idString)));
                                            //event = reader. nextEvent();
                                            isDexIdCollected = true;
                                            isNationalDexTag = false;
                                        }
                                    }
                                    break;
                                }
                                event = reader.nextEvent(); // LOOP continue 
                            }
                        }
                    }
                    //Find the pokemon Name:
                    if (tagName.equals("a")) {
                        attribute = startElement.getAttributeByName(new QName("title"));
                        if (attribute != null && attribute.getValue().contains("(Pokémon)") && !attribute.getValue().contains("Victini")) {
                            isPokemonNameTag = true;
                            event = reader.nextEvent();
                        }
                        if (event.isCharacters() && isPokemonNameTag) {
                            String name = event.asCharacters().toString().trim();
                            //System.out.println(name.toUpperCase()); //For DEBUG Purpose
                            this.getPokemon().setEnglishName(name);
                            isNameCollected = true;
                            isPokemonNameTag = false;
                        }
                    }
                    //Add pokemon to List if collect enough info:
                    if (isDexIdCollected && isNameCollected) {
                        Pokemon temp;
                        if (this.getPokemonList().getPokemon().isEmpty()) {
                            this.getPokemonList().getPokemon().add(this.getPokemon());
                        } else {
                            temp = this.getPokemonList().getPokemon().get(this.getPokemonList().getPokemon().size() - 1);
                            if (!temp.getNationalDexId().equals(this.getPokemon().getNationalDexId())) {
                                this.getPokemonList().getPokemon().add(this.getPokemon());
                            }
                        }

                        this.pokemon = new Pokemon();
                        isDexIdCollected = false;
                        isNameCollected = false;
                    }
                    //Validate and add to DB every 200 records colleted:
                    if (this.getPokemonList().getPokemon().size() == 200) {
                        //Validate data and save to DB
                        JAXBHelper.saveAsXML(xmlPath, this.getPokemonList());
                        if (JAXBHelper.validateXML(xmlPath, schemaPath, this.getPokemonList().getPokemon())) {
                            //Save Data to DB
                            for (Pokemon pokemon : this.getPokemonList().getPokemon()) {
                                if (!pkmDao.isExistedInDB(pokemon)) {
                                    pkmDao.insertPokemon(pokemon);
                                }
                            }
                            //Purge the list
                            this.pokemonList = new PokemonList();
                            this.pokemon = new Pokemon();
                        }
                    }
                    //Validate and add to DB last records:
                    if (this.getPokemonList().getPokemon().size() > 0) {
                        JAXBHelper.saveAsXML(xmlPath, this.getPokemonList());
                        if (JAXBHelper.validateXML(xmlPath, schemaPath, this.getPokemonList().getPokemon())) {
                            //Save Data to DB
                            for (Pokemon pokemon : this.getPokemonList().getPokemon()) {
                                if (!pkmDao.isExistedInDB(pokemon)) {
                                    pkmDao.insertPokemon(pokemon);
                                }
                            }
                            //Purge the list
                            this.pokemonList = new PokemonList();
                            this.pokemon = new Pokemon();
                        }
                    }
                    //Break when collect all the needed info:
                    if (tagName.equals("span")) {
                        attribute = startElement.getAttributeByName(new QName("id"));
                        if (attribute != null && attribute.getValue().equals("See_also")) {
                            System.out.println("All pokemons have been collected.");
                            break;
                        }
                    }

                }

            } catch (XMLStreamException e) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JAXBException ex) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void crawl_romajiName_japaneseName_pictureURI(Pokemon pokemon) throws IOException, XMLStreamException {

        String urlString = "https://bulbapedia.bulbagarden.net/wiki/" + pokemon.getEnglishName() + "_(Pok%C3%A9mon)";
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        System.setProperty("http.agent", "Chrome");
        connection.addRequestProperty("User-Agent", "Mozilla/4.76"); //Need modify
        InputStream is = connection.getInputStream();

        XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_VALIDATING, false);
        factory.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);

        //USING Iterator
        //XMLEventReader reader = factory.createXMLEventReader(is, "UTF-8");
        XMLEventReader reader = factory.createXMLEventReader(new InputStreamReader(HTMLValidator.validateInputStream(is), "UTF-8"));
        XMLEvent event;

        Attribute attribute;
        StartElement startElement;
        int errorCount = 0;

        boolean isJapaneseNameContainer = false;
        boolean isPictureURIContainer = false;

        //Info needed:
        boolean isIdCollected = false;
        boolean isRomajiNameCollected = false;
        boolean isJapaneseNameCollected = false;
        boolean isPictureURICollected = false;

        String xmlPath = "web/WEB-INF/xml/PokemonList.xml";
        String schemaPath = "web/WEB-INF/schemas/PokemonList.xsd";
        PokemonDAO pkmDao = new PokemonDAO();

        while (reader.hasNext()) {
            try {
                if (errorCount == 50) {
                    errorCount = 0;
                    break;
                }
                event = reader.nextEvent();
                if (event.isStartElement()) {
                    startElement = event.asStartElement();
                    String tagName = startElement.getName().toString();
                    //System.out.println(tagName); // For Debug Porpurse

                    //Find Pokemon romajiName
                    if (tagName.equals("i")) {
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            this.getPokemon().setRomajiName(event.asCharacters().toString());
                            isRomajiNameCollected = true;
                        }
                    }
                    //Find Pokemon japaneseName
                    if (tagName.equals("span")) {
                        attribute = startElement.getAttributeByName(new QName("lang"));
                        if (attribute != null && attribute.getValue().equals("ja")) {
                            isJapaneseNameContainer = true;
                        }
                    }
                    if (isJapaneseNameContainer) {
                        event = reader.nextEvent();
                        if (event.isStartElement()) {
                            startElement = event.asStartElement();
                            if (startElement.getName().toString().equals("b")) {
                                event = reader.nextEvent();
                                if (event.isCharacters()) {
                                    this.getPokemon().setJapaneseName(event.asCharacters().toString());
                                    isJapaneseNameCollected = true;
                                    isJapaneseNameContainer = false;
                                } else if (event.isStartElement()) { //Case that <b><span class="explain title="..."></span></b>
                                    startElement = event.asStartElement();
                                    if (startElement.getName().toString().equals("span")) {
                                        attribute = startElement.getAttributeByName(new QName("class"));
                                        if (attribute != null && attribute.getValue().equals("explain")) {
                                            event = reader.nextEvent();
                                            if (event.isCharacters()) {
                                                this.getPokemon().setJapaneseName(event.asCharacters().toString());
                                                isJapaneseNameCollected = true;
                                                isJapaneseNameContainer = false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //Find pokemon PictureURI
                    if (tagName.equals("a")) {
                        attribute = startElement.getAttributeByName(new QName("title"));
                        if (attribute != null && attribute.getValue().equals(pokemon.getEnglishName())) {
                            isPictureURIContainer = true;
                        }
                    }
                    if (isPictureURIContainer) {
                        event = reader.nextEvent();
                        if (event.isStartElement()) {
                            if (event.asStartElement().getName().toString().equals("img")) {
                                String pictureURI = event.asStartElement().getAttributeByName(new QName("src")).getValue();
                                this.getPokemon().setPictureURI(pictureURI);
                                isPictureURICollected = true;
                                isPictureURIContainer = false;
                            }
                        }
                    }
                }
                if (isJapaneseNameCollected
                        && isPictureURICollected
                        && isRomajiNameCollected) {
                    this.getPokemon().setNationalDexId(pokemon.getNationalDexId());
                    this.getPokemonList().getPokemon().add(this.getPokemon());
                    //Validate and save to DB
                    JAXBHelper.saveAsXML(xmlPath, this.getPokemonList());
                    if (JAXBHelper.validateXML(xmlPath, schemaPath, this.getPokemonList().getPokemon())) {
                        //Save Data to DB
                        pkmDao.update_JapanseseName_RomajiName_PictureURI(this.getPokemon());
                        //Purge the list
                        this.pokemon = new Pokemon();
                        this.pokemonList = new PokemonList();
                    }
                    break;
                }

            } catch (XMLStreamException e) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                errorCount += 1;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JAXBException ex) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException e) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                break;
            }
        }

    }

    private XMLEventReader readFromWebsite(String urlString) throws MalformedURLException, IOException, XMLStreamException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        System.setProperty("http.agent", "Chrome");
        connection.addRequestProperty("User-Agent", "Mozilla/4.76"); //Need modifying
        InputStream is = connection.getInputStream();

        XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_VALIDATING, false);
        factory.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);

        //USING Iterator
        //XMLEventReader reader = factory.createXMLEventReader(is, "UTF-8");
        XMLEventReader reader = factory.createXMLEventReader(new InputStreamReader(HTMLValidator.validateInputStream(is), "UTF-8"));
        return reader;
    }

    public void crawl_baseXP_baseHappiness_catchRate_growthRate(Pokemon pokemon) throws IOException, XMLStreamException {
        String urlString = "https://www.azurilland.com/pokedex/"
                + pokemon.getNationalDexId()
                + "-"
                + pokemon.getEnglishName().toLowerCase();
        try {
            XMLEventReader reader = readFromWebsite(urlString);

            XMLEvent event;

            StartElement startElement;
            Attribute attribute;

            boolean isNationalDexTag = false;
            boolean isPokemonNameTag = false;

            int errorCount = 0;

            boolean isCatchRateCollected = false;
            boolean isBaseXPCollected = false;
            boolean isBaseHappinessCollected = false;

            String xmlPath = "web/WEB-INF/xml/PokemonList.xml";
            String schemaPath = "web/WEB-INF/schemas/PokemonList.xsd";
            PokemonDAO pkmDao = new PokemonDAO();

            while (reader.hasNext()) {
                try {
                    if (errorCount == 50) {
                        errorCount = 0;
                        break;
                    }
                    if (isCatchRateCollected && isBaseHappinessCollected && isBaseXPCollected) {
                        this.getPokemon().setNationalDexId(pokemon.getNationalDexId());
                        this.getPokemon().setEnglishName(pokemon.getEnglishName());
                        pokemon = this.getPokemon();
                        this.getPokemonList().getPokemon().add(pokemon);
                        //Validate and save to DB
                        JAXBHelper.saveAsXML(xmlPath, this.getPokemonList());
                        if (JAXBHelper.validateXML(xmlPath, schemaPath, this.getPokemonList().getPokemon())) {
                            //Save Data to DB
                            pkmDao.update_catchRate_baseXP_baseHappiness(pokemon);

                            System.out.println("update_catchRate_baseXP_baseHappiness: " + pokemon.getNationalDexId() + "-" + pokemon.getEnglishName().toUpperCase());
                            //Purge the list
                            this.pokemon = new Pokemon();
                            this.pokemonList = new PokemonList();
                        }
                        break;
                    }
                    event = reader.nextEvent();
                    if (event.isStartElement()) {
                        String tagName = event.asStartElement().getName().toString();
                        if (tagName.equals("tr")) {
                            attribute = event.asStartElement().getAttributeByName(new QName("class"));
                            if (attribute != null) {
                                String token = attribute.getValue();
                                if (token.equals("pokemon-catch-rate")) {
                                    while (true) {
                                        if (event.isCharacters()) {
                                            if (!event.asCharacters().getData().equals("Catch Rate:")) {
                                                String catchRate = event.asCharacters().toString();
                                                this.getPokemon().setCatchRate(BigDecimal.valueOf(Long.valueOf(catchRate)));
                                                isCatchRateCollected = true;
                                                break;
                                            }
                                        }
                                        event = reader.nextEvent();
                                    }
                                    continue;
                                }
                                if (token.equals("pokemon-base-xp")) {
                                    while (true) {
                                        if (event.isCharacters()) {
                                            if (!event.asCharacters().getData().equals("Base XP:")) {
                                                this.getPokemon().setBaseExp(BigInteger.valueOf(Long.valueOf(event.asCharacters().toString())));
                                                isBaseXPCollected = true;
                                                break;
                                            }
                                        }
                                        event = reader.nextEvent();
                                    }
                                    continue;
                                }
                                if (token.equals("pokemon-base-happiness")) {
                                    while (true) {
                                        if (event.isCharacters()) {
                                            if (!event.asCharacters().getData().equals("Base Happiness:")) {
                                                this.getPokemon().setBaseHappiness(BigInteger.valueOf(Long.valueOf(event.asCharacters().toString())));
                                                isBaseHappinessCollected = true;
                                                break;
                                            }
                                        }
                                        event = reader.nextEvent();
                                    }
                                    continue;
                                }
                            }
                        }
                    }
                } catch (XMLStreamException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    errorCount += 1;
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JAXBException ex) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException ex) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
