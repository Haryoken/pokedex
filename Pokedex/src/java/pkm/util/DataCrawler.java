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
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
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
        boolean isNationalDexTag = false;
        boolean isPokemonNameTag = false;

        boolean isDexIdCollected = false;
        boolean isNameCollected = false;

        String xmlPath = "web/WEB-INF/xml/PokemonList.xml";
        String schemaPath = "web/WEB-INF/schemas/PokemonList.xsd";
        PokemonDAO pkmDao = new PokemonDAO();
        while (reader.hasNext()) {
            try {
                if (this.getPokemonList().getPokemon().size() == 806) {
                    //Validate data and save to DB
                    JAXBHelper.saveAsXML(xmlPath, this.getPokemonList());
                    if (JAXBHelper.validateXML(xmlPath, schemaPath, this.getPokemonList().getPokemon())) {
                        System.out.println("XML Validation Success.");
                        
                        //Save Data to DB
                        pkmDao.insertPokemon(this.getPokemonList().getPokemon().get(0));
                        //Purge the list
                        this.pokemonList = new PokemonList();
                        this.pokemon = new Pokemon();
                        break;
                    }
                }
                

                StartElement startElement;
                Attribute attribute;

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
                }

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
            } catch (XMLStreamException e) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JAXBException ex) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    public void crawlPokemonMainInfo(String pokemonName) throws IOException, XMLStreamException {
        String urlString = "https://bulbapedia.bulbagarden.net/wiki/"+pokemonName+"_(Pok%C3%A9mon)";
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

        boolean isJapaneseNameContainer = false;
        boolean isPictureURIContainer = false;

        //Info needed:
        boolean isIdCollected = false;
        boolean isRomajiNameCollected = false;
        boolean isJapaneseNameCollected = false;
        boolean isPictureURICollected = false;

        while (reader.hasNext()) {
            try {
                if (isJapaneseNameCollected
                        && isJapaneseNameCollected
                        && isPictureURICollected
                        && isRomajiNameCollected) {
                    //Validate and save to DB
                    break;
                }
                event = reader.nextEvent();

                if (event.isStartElement()) {
                    startElement = event.asStartElement();
                    String tagName = startElement.getName().toString();
                    //System.out.println(tagName); // For Debug Porpurse

                    //Find the pokemon englishName:
//                    if (tagName.equals("h1")) {
//                        attribute = startElement.getAttributeByName(new QName("id"));
//                        if (attribute != null && attribute.getValue().equals("firstHeading")) {
//                            event = reader.nextEvent();
//                            if (event.isCharacters()) {
//
//                                this.getPokemon().setEnglishName(event.asCharacters().toString().replace("(Pokémon)", "").trim());
//
//                            }
//                        }
//                    }
//                    if (tagName.equals("a")) { // <a title = "List of Pokémon by National Pokédex number">
//                        attribute = startElement.getAttributeByName(new QName("title"));
//                        if (attribute != null && attribute.getValue().equals("List of Pokémon by National Pokédex number")) {
//                            event = reader.nextEvent();
//                            if (event.isStartElement()) {
//                                startElement = event.asStartElement();
//                                if (startElement.getName().toString().equals("span")) //<span>;
//                                {
//                                    event = reader.nextEvent();
//                                }
//                                if (event.isCharacters()) {
//                                    String idString = event.asCharacters().toString().trim();
//                                    if (!idString.equals("Pokémon")) {
//                                        idString = idString.substring(1);                                    
//                                        this.getPokemon().setNationalDexId(BigInteger.valueOf(Long.parseLong(idString)));
//                                        isIdCollected = true;
//                                    }
//                                }
//                            }
//                        }
//                    }
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
                                }
                            }
                        }
                    }

                    //Find pokemon PictureURI
                    if (tagName.equals("a")) {
                        attribute = startElement.getAttributeByName(new QName("title"));
                        System.out.println("");
                        if (attribute != null && attribute.getValue().equals(this.getPokemon().getEnglishName())) {
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

            } catch (XMLStreamException e) {
                System.out.println("XMLStreamException: " + e.getMessage());
            }
        }

    }  
}
