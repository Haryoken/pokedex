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

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import pkm.dao.AbilityDAO;
import pkm.dao.MoveDAO;
import pkm.dao.PokemonAbilitiesDAO;
import pkm.dao.PokemonDAO;
import pkm.dao.PokemonMovesDAO;
import pkm.dao.PokemonStatsDAO;
import pkm.dao.TypeDAO;
import pkm.dao.TypeInteractionDAO;
import pkm.xml.object.Ability.xsd.Ability;
import pkm.xml.object.MoveList.xsd.Move;
import pkm.xml.object.PokemonAbilitiesList.xsd.PokemonAbilities;

import pkm.xml.object.PokemonList.xsd.Pokemon;
import pkm.xml.object.PokemonList.xsd.PokemonList;
import pkm.xml.object.PokemonMovesList.xsd.PokemonMoves;
import pkm.xml.object.PokemonStatsList.xsd.PokemonStats;
import pkm.xml.object.TypeInteractionList.xsd.TypeInteraction;
import pkm.xml.object.TypeInteractionList.xsd.TypeInteractionList;

import pkm.xml.object.TypeList.xsd.Type;
import pkm.xml.object.TypeList.xsd.TypeList;

/**
 *
 * @author DUCVINH
 */
public class DataCrawler {

    Pokemon pokemon;
    PokemonList pokemonList;

    Type pokemonType;
    TypeList typeList;

    Ability ability;
    List<Ability> abilityList;

    PokemonAbilities pokemonAbilities;
    List<PokemonAbilities> abilitiesList;

    PokemonStats pokemonStats;

    Move move;
    List<Move> moveList;

    PokemonMoves pokemonMoves;
    List<PokemonMoves> pokemonMoveList;

    TypeInteraction typeInteraction;
    TypeInteractionList typeInteractionList;

    public DataCrawler() {
        pokemon = new Pokemon();
        pokemonList = new PokemonList();

        pokemonType = new Type();
        typeList = new TypeList();

        ability = new Ability();
        abilityList = new ArrayList<>();

        pokemonAbilities = new PokemonAbilities();
        abilitiesList = new ArrayList<>();

        pokemonStats = new PokemonStats();

        move = new Move();
        moveList = new ArrayList<>();

        pokemonMoves = new PokemonMoves();
        pokemonMoveList = new ArrayList<>();

        typeInteraction = new TypeInteraction();
        typeInteractionList = new TypeInteractionList();
    }

    public TypeInteraction getTypeInteraction() {
        return typeInteraction;
    }

    public void setTypeInteraction(TypeInteraction typeInteraction) {
        this.typeInteraction = typeInteraction;
    }

    public TypeInteractionList getTypeInteractionList() {
        return typeInteractionList;
    }

    public void setTypeInteractionList(TypeInteractionList typeInteractionList) {
        this.typeInteractionList = typeInteractionList;
    }

    public PokemonMoves getPokemonMoves() {
        return pokemonMoves;
    }

    public void setPokemonMoves(PokemonMoves pokemonMoves) {
        this.pokemonMoves = pokemonMoves;
    }

    public List<PokemonMoves> getPokemonMoveList() {
        return pokemonMoveList;
    }

    public void setPokemonMoveList(List<PokemonMoves> pokemonMoveList) {
        this.pokemonMoveList = pokemonMoveList;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public PokemonStats getPokemonStats() {
        return pokemonStats;
    }

    public void setPokemonStats(PokemonStats pokemonStats) {
        this.pokemonStats = pokemonStats;
    }

    public PokemonAbilities getPokemonAbilities() {
        return pokemonAbilities;
    }

    public void setPokemonAbilities(PokemonAbilities pokemonAbilities) {
        this.pokemonAbilities = pokemonAbilities;
    }

    public List<PokemonAbilities> getAbilitiesList() {
        return abilitiesList;
    }

    public void setAbilitiesList(List<PokemonAbilities> abilitiesList) {
        this.abilitiesList = abilitiesList;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public List<Ability> getAbilityList() {
        return abilityList;
    }

    public void setAbilityList(List<Ability> abilityList) {
        this.abilityList = abilityList;
    }

    public TypeList getTypeList() {
        return typeList;
    }

    public void setTypeList(TypeList typeList) {
        this.typeList = typeList;
    }

    public Type getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(Type pokemonType) {
        this.pokemonType = pokemonType;
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

    private static String cleanPokemonNameAzurill(String pokemon) {
        if (pokemon.equals("Mr. Mime")) {
            pokemon = "Mr-Mime";
        }
        if (pokemon.equals("Mime Jr.")) {
            pokemon = "Mime-Jr";
        }
        if (pokemon.equals("Farfetch'd")) {
            pokemon = "Farfetchd";
        }
        if (pokemon.equals("Nidoran♀") || pokemon.equals("Nidoran♂")) {
            pokemon = "Nidoran";
        }
        if (pokemon.equals("Flabébé")) {
            pokemon = "Flabebe";
        }
        return pokemon;
    }

    private static String cleanPokemonNameIGN(String pokemon) {
        if (pokemon.equals("Mr. Mime")) {
            pokemon = "mr-mime";
        }
        if (pokemon.equals("Mime Jr.")) {
            pokemon = "Mime-Jr";
        }
        if (pokemon.equals("Farfetch'd")) {
            pokemon = "farfetchd";
        }
        if (pokemon.equals("Nidoran♀") || pokemon.equals("Nidoran♂")) {
            pokemon = "nidoran-f";
        }
        if (pokemon.equals("Flabébé")) {
            pokemon = "flabb";
        }
        return pokemon;
    }

    private static String cleanPokemonNameBulbapedia(String pokemon) {
        if (pokemon.equals("Mr. Mime")) {
            pokemon = "Mr._Mime";
        }
        if (pokemon.equals("Mime Jr.")) {
            pokemon = "Mime_Jr.";
        }
        if (pokemon.equals("Nidoran♀")) {
            pokemon = "Nidoran\u2640";
        }
        if (pokemon.equals("Nidoran♂")) {
            pokemon = "Nidoran\u2642";
        }
        if (pokemon.equals("Flabébé")) {
            pokemon = "Flab%C3%A9b%C3%A9";
        }

        return pokemon;
    }

    private XMLEventReader readFromWebsite(String urlString) throws MalformedURLException, IOException, XMLStreamException, FileNotFoundException {
        XMLEventReader reader = null;

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
        if (urlString.contains("azurilland")) {
            reader = factory.createXMLEventReader(new InputStreamReader(HTMLValidator.validateInputStreamAzurill(is), "UTF-8"));
        } else if (urlString.contains("bulbagarden")) {
            reader = factory.createXMLEventReader(new InputStreamReader(HTMLValidator.validateInputStream(is), "UTF-8"));
        } else if (urlString.contains("wikia")) {
            reader = factory.createXMLEventReader(new InputStreamReader(HTMLValidator.validateInputStreamWikia(is), "UTF-8"));
        } else if (urlString.contains("ign")) {
            reader = factory.createXMLEventReader(new InputStreamReader(HTMLValidator.validateInputStreamIGN(is), "UTF-8"));
        } else if (urlString.contains("pokemondb")) {
            reader = factory.createXMLEventReader(new InputStreamReader(HTMLValidator.validateInputStreamPKMDB(is), "UTF-8"));
        }
        return reader;
    }

    //CRAWL POKEMON
    
     //bulbapedia.bulbagarden.net
    public void crawlRomJapImage(Pokemon pokemon) throws IOException, XMLStreamException {
        String pokemonName = cleanPokemonNameBulbapedia(pokemon.getEnglishName());
        String urlString = "https://bulbapedia.bulbagarden.net/wiki/" + pokemonName + "_(Pok%C3%A9mon)";

        XMLEventReader reader = readFromWebsite(urlString);
        XMLEvent event;

        StartElement startElement;
        Attribute attribute;
        int errorCount = 0;
        
        boolean isJapaneseNameContainer = false;
        boolean isPictureURIContainer = false;

        //Info needed:
        boolean isIdCollected = false;
        boolean isRomajiNameCollected = false;
        boolean isJapaneseNameCollected = false;
        boolean isPictureURICollected = false;


        PokemonDAO pkmDao = null;
        
        while (reader.hasNext()) {
            try {
                if (errorCount == 50) {
                    errorCount = 0;
                    break;
                }
                if (isJapaneseNameCollected
                        && isPictureURICollected
                        && isRomajiNameCollected) {
                    pkmDao = new PokemonDAO();
                    this.getPokemon().setNationalDexId(pokemon.getNationalDexId());
                    //Save Data to DB
                    if (pkmDao.isExistedInDB(Integer.parseInt(this.getPokemon().getNationalDexId().toString()))) {
                        pkmDao.update_JapanseseName_RomajiName_PictureURI(this.getPokemon());
                        System.out.println("update_japaneseName_pictureURI_romajiName: " + pokemon.getNationalDexId() + "-" + pokemon.getEnglishName().toUpperCase());
                    }
                    //Purge the pokemon
                    this.pokemon = new Pokemon();
                    break;
                }
                event = reader.nextEvent();
                if (event.isStartElement()) {
                    startElement = event.asStartElement();
                    String tagName = startElement.getName().toString();
                    
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
                    
                    if (isJapaneseNameContainer && tagName.equals("b")) {
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
                    
                    //Find pokemon PictureURI
                    if (isJapaneseNameCollected && tagName.equals("a")) {
                        attribute = startElement.getAttributeByName(new QName("href"));
                        if (attribute != null && attribute.getValue().contains(pokemon.getEnglishName())) {
                            isPictureURIContainer = true;
                        }
                    }
                    if (isPictureURIContainer && tagName.equals("img")) {
                        String pictureURI = event.asStartElement().getAttributeByName(new QName("src")).getValue();
                        this.getPokemon().setPictureURI(pictureURI);
                        isPictureURICollected = true;
                        isPictureURIContainer = false;
                    }
                }
            } catch (XMLStreamException e) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                errorCount += 1;
            } catch (NullPointerException e) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                break;
            }
        }
    }
    //bulbapedia.bulbagarden.net
    public void crawl_All_nationalDexId_englishName() throws IOException, XMLStreamException {
        String urlString = "https://bulbapedia.bulbagarden.net/wiki/List_of_Pok%C3%A9mon_by_National_Pok%C3%A9dex_number";

        XMLEventReader reader = readFromWebsite(urlString);
        XMLEvent event;

        StartElement startElement;
        Attribute attribute;
        String types = "";

        boolean isNationalDexTag = false;
        boolean isPokemonNameTag = false;
        boolean isInfoArea = false;
        boolean isAllInfoCollected = false;

        PokemonDAO pkmDao = new PokemonDAO();
        while (reader.hasNext()) {
            try {
                if (isAllInfoCollected) {
                    String[] typeArray = types.split(",");
                    if (typeArray.length == 2) {
                        this.getPokemon().setFirstType(typeArray[0]);
                        this.getPokemon().setSecondType(typeArray[1]);
                    } else {
                        this.getPokemon().setFirstType(typeArray[0]);
                    }
                    types = "";
                    this.getPokemonList().getPokemon().add(this.getPokemon());
                    this.pokemon = new Pokemon();
                    isAllInfoCollected = false;
                }
                if (this.getPokemonList().getPokemon().size() > 0) {
                    //Save Data to DB
                    for (Pokemon pokemon : this.getPokemonList().getPokemon()) {
                        if (!pkmDao.isExistedInDB(pokemon)) {
                            pkmDao.insertPokemon(pokemon);
                            System.out.println("Pokemon Inserted: " + pokemon.getNationalDexId() + "_" + pokemon.getEnglishName() + "_" + pokemon.getFirstType() + "," + pokemon.getSecondType());
                        }
                    }
                    //Purge the list
                    this.pokemonList = new PokemonList();
                }

                event = reader.nextEvent();
                if (event.isStartElement()) {
                    startElement = event.asStartElement();
                    String tagName = startElement.getName().toString();
                    //Find the pokemon nationalDexId:
                    if (tagName.equals("td")) {
                        attribute = startElement.getAttributeByName(new QName("style"));
                        if (attribute != null && attribute.getValue().equals("font-family:monospace")) { // Ignore the first <td>.
                            isInfoArea = true;
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
                                            if (idString.equals("722")) {
                                                return;
                                            }
                                            //System.out.println(idString); //For DEBUG Purpose
                                            this.getPokemon().setNationalDexId(BigInteger.valueOf(Long.parseLong(idString)));
                                            //event = reader. nextEvent();
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
                    if (tagName.equals("img") && isInfoArea) {
                        this.getPokemon().setIconURI(startElement.asStartElement().getAttributeByName(new QName("src")).getValue());
                    }
                    if (tagName.equals("span") && isInfoArea) {
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            types += event.asCharacters().getData() + ",";
//                           this.getPokemon().setTypes(types);                           
                        }
                    }
                    if (tagName.equals("a") && isInfoArea) {
                        attribute = startElement.getAttributeByName(new QName("title"));
                        if (attribute != null && attribute.getValue().contains("(Pokémon)")) {
                            isPokemonNameTag = true;
                            event = reader.nextEvent();
                        }
                        if (event.isCharacters() && isPokemonNameTag) {
                            String name = event.asCharacters().toString().trim();
                            //System.out.println(name.toUpperCase()); //For DEBUG Purpose
                            this.getPokemon().setEnglishName(name);
                            isPokemonNameTag = false;
                        }
                    }
                    //Add pokemon to List if collect enough info:

                    //Break when collect all the needed info:
                    if (tagName.equals("span")) {
                        attribute = startElement.getAttributeByName(new QName("id"));
                        if (attribute != null && attribute.getValue().equals("See_also")) {
                            System.out.println("All pokemons have been collected.");
                            break;
                        }
                    }
                }
                if (event.isEndElement()) {
                    if (isInfoArea && event.asEndElement().getName().toString().equals("tr")) {
                        isInfoArea = false;
                        isAllInfoCollected = true;
                    }
                }

            } catch (XMLStreamException e) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

    

    //azurilland.com
    public void crawl_baseXP_catchRate(Pokemon pokemon) throws IOException, XMLStreamException {
        String pokemonName = cleanPokemonNameAzurill(pokemon.getEnglishName());
        String urlString = "https://www.azurilland.com/pokedex/"
                + pokemon.getNationalDexId()
                + "-"
                + pokemonName.toLowerCase();
        if (Integer.parseInt(pokemon.getNationalDexId().toString()) >= 651) {
            int number = 99351 + Integer.parseInt(pokemon.getNationalDexId().toString());
            urlString = "https://www.azurilland.com/pokedex/"
                    + number
                    + "-"
                    + pokemonName.toLowerCase();
        }
        try {
            XMLEventReader reader = readFromWebsite(urlString);

            XMLEvent event;

            StartElement startElement;
            Attribute attribute;

            int errorCount = 0;

            boolean isCatchRateCollected = false;
            boolean isBaseXPCollected = false;

            //DAO
            PokemonDAO pkmDao = new PokemonDAO();

            while (reader.hasNext()) {
                try {
                    if (errorCount == 50) {
                        errorCount = 0;
                        break;
                    }
                    if (isCatchRateCollected && isBaseXPCollected) {
                        this.getPokemon().setNationalDexId(pokemon.getNationalDexId());
                        this.getPokemon().setEnglishName(pokemon.getEnglishName());
                        //Save Data to DB
                        pkmDao.update_catchRate_baseXP_baseHappiness(this.getPokemon());
                        System.out.println("update_catchRate_baseXP: " + pokemon.getNationalDexId() + "-" + pokemon.getEnglishName().toUpperCase());
                        //Purge the list
                        this.pokemon = new Pokemon();

                        break;
                    }
                    event = reader.nextEvent();
                    if (event.isStartElement()) {
                        String tagName = event.asStartElement().getName().toString();
                        if (tagName.equals("tr")) {
                            attribute = event.asStartElement().getAttributeByName(new QName("class"));
                            if (attribute != null) {
                                //Get pokemon catchRate
                                if (attribute.getValue().equals("pokemon-catch-rate")) {
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
                                //Get pokemon baseXP
                                if (attribute.getValue().equals("pokemon-base-xp")) {
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
                                }
                            }
                        }
                    }
                } catch (XMLStreamException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    errorCount += 1;
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

    public void crawl_levelRate(Pokemon pokemon) throws IOException, XMLStreamException {
        String pokemonName = cleanPokemonNameAzurill(pokemon.getEnglishName());
        String urlString = "https://www.azurilland.com/pokedex/"
                + pokemon.getNationalDexId()
                + "-"
                + pokemonName.toLowerCase();
        if (Integer.parseInt(pokemon.getNationalDexId().toString()) >= 651) {
            int number = 99351 + Integer.parseInt(pokemon.getNationalDexId().toString());
            urlString = "https://www.azurilland.com/pokedex/"
                    + number
                    + "-"
                    + pokemonName.toLowerCase();
        }

        try {
            XMLEventReader reader = readFromWebsite(urlString);

            XMLEvent event;

            Attribute attribute;

            int errorCount = 0;

            //Info Needed:
            boolean isLevelRateCollected = false;

            //DAO
            PokemonDAO pkmDao = new PokemonDAO();

            while (reader.hasNext()) {
                try {
                    if (errorCount == 50) {
                        errorCount = 0;
                        break;
                    }
                    if (isLevelRateCollected) {
                        this.getPokemon().setNationalDexId(pokemon.getNationalDexId());
                        if (pkmDao.isExistedInDB(this.getPokemon())) {
                            pkmDao.updateGrowthRate(this.getPokemon());
                            System.out.println("Update GrowthRate: " + pokemon.getNationalDexId() + "-" + pokemon.getEnglishName());
                        }
                        this.pokemon = new Pokemon();
                        break;
                    }
                    event = reader.nextEvent();
                    if (event.isStartElement()) {
                        String tagName = event.asStartElement().getName().toString();
                        if (tagName.equals("tr")) {
                            attribute = event.asStartElement().getAttributeByName(new QName("class"));
                            if (attribute != null) {
                                String token = attribute.getValue();
                                if (token.equals("pokemon-level-rate")) {
                                    while (true) {
                                        if (event.isCharacters()) {
                                            if (!event.asCharacters().getData().equals("Level Rate:")) {
                                                this.getPokemon().setGrowthRate(event.asCharacters().getData());
                                                isLevelRateCollected = true;
                                                break;
                                            }
                                        }
                                        event = reader.nextEvent();
                                    }
                                }
                                if (token.equals("pokemon-effort-values")) {
                                    return;
                                }
                            }
                        }
                    }
                } catch (XMLStreamException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    errorCount += 1;
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException ex) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //azurilland.com
    public void crawl_baseHappiness(Pokemon pokemon) throws IOException, XMLStreamException {
        String pokemonName = cleanPokemonNameAzurill(pokemon.getEnglishName());
        String urlString = "https://www.azurilland.com/pokedex/"
                + pokemon.getNationalDexId()
                + "-"
                + pokemonName.toLowerCase();
        if (Integer.parseInt(pokemon.getNationalDexId().toString()) >= 651) {
            int number = 99351 + Integer.parseInt(pokemon.getNationalDexId().toString());
            urlString = "https://www.azurilland.com/pokedex/"
                    + number
                    + "-"
                    + pokemonName.toLowerCase();
        }

        try {
            XMLEventReader reader = readFromWebsite(urlString);

            XMLEvent event;

            Attribute attribute;

            int errorCount = 0;

            //Info Needed:
            boolean isBaseHappinessCollected = false;

            //DAO
            PokemonDAO pkmDao = new PokemonDAO();

            while (reader.hasNext()) {
                try {
                    if (errorCount == 50) {
                        errorCount = 0;
                        break;
                    }
                    if (isBaseHappinessCollected) {
                        this.getPokemon().setNationalDexId(pokemon.getNationalDexId());
                        this.getPokemon().setEnglishName(pokemon.getEnglishName());
                        //Validate and save to DB
                        //Save Data to DB
                        pkmDao.updateBaseHappiness(this.getPokemon());
                        System.out.println("update_baseHappiness: " + pokemon.getNationalDexId() + "-" + pokemon.getEnglishName().toUpperCase());
                        //Purge the pokemon
                        this.pokemon = new Pokemon();
                        break;
                    }
                    event = reader.nextEvent();
                    if (event.isStartElement()) {
                        String tagName = event.asStartElement().getName().toString();
                        if (tagName.equals("tr")) {
                            attribute = event.asStartElement().getAttributeByName(new QName("class"));
                            if (attribute != null) {
                                if (attribute.getValue().equals("pokemon-base-happiness")) {
                                    System.out.println("");
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
                                }
                            }
                        }
                    }
                } catch (XMLStreamException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    errorCount += 1;
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

    //CRAWL TYPE
    //pokemon.wikia.com
    public void crawl_All_Types() throws IOException, XMLStreamException {
        String urlString = "http://pokemon.wikia.com/wiki/Types";
        XMLEventReader reader = readFromWebsite(urlString);
        XMLEvent event = null;

        StartElement startElement = null;
        Attribute attribute = null;

        int errorCount = 0;

        boolean isAllTypesCollected = false;
        boolean isAtTypeTable = false;

        String xmlPath = "web/WEB-INF/xml/PokemonTypes.xml";
        String schemaPath = "web/WEB-INF/schemas/TypeList.xsd";
        TypeDAO typeDao = new TypeDAO();

        while (reader.hasNext()) {
            try {
                if (errorCount == 50) {
                    errorCount = 0;
                    break;
                }
                if (isAllTypesCollected) {
                    for (Type type : this.getTypeList().getPokemonType()) {
                        if (!typeDao.isTypeExisted(type)) {
                            typeDao.insertType(type);
                            System.out.println("Insert Type: " + type.getTypeLabel());
                        }
                    }
                    break;
                }
                event = reader.nextEvent();
                if (event.isStartElement()) {
                    String tagName = event.asStartElement().getName().toString();
                    if (tagName.equals("table")) {
                        attribute = event.asStartElement().getAttributeByName(new QName("class"));
                        if (attribute != null && attribute.getValue().equals("article-table")) {
                            isAtTypeTable = true;
                            event = reader.nextEvent();
                            while (true) {
                                if (event.isStartElement()) {
                                    if (event.asStartElement().getName().toString().equals("span")) {
                                        attribute = event.asStartElement().getAttributeByName(new QName("class"));
                                        if (attribute != null && attribute.getValue().equals("t-type2")) {
                                            event = reader.nextEvent();
                                            if (event.isCharacters()) {
                                                this.getPokemonType().setTypeLabel(event.asCharacters().getData());
                                                this.getTypeList().getPokemonType().add(this.getPokemonType());
                                                this.pokemonType = new Type();
                                            }
                                        }
                                    }
                                }
                                if (event.isEndElement()) {
                                    String endTag = event.asEndElement().getName().toString();
                                    if (event.asEndElement().getName().toString().equals("table") && isAtTypeTable) {
                                        isAtTypeTable = false;
                                        isAllTypesCollected = true;
                                        break;
                                    }
                                }
                                event = reader.nextEvent();
                            }
                        }
                    }
                }
            } catch (XMLStreamException ex) {
                Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //CRAWL ABILITIES
    //pokemon.wikia.com
    public void crawl_All_Ability() throws IOException, XMLStreamException {
        String urlString = "http://pokemon.wikia.com/wiki/Pok%C3%A9mon_Abilities";
        try {
            XMLEventReader reader = readFromWebsite(urlString);
            XMLEvent event;

            //StaX Iterator API:
            Attribute attribute;
            StartElement startElement;
            int errorCount = 0;

            //Tag Flag:
            boolean isAbilityContainer = false;
            boolean isAbilityTable = false;
            boolean isAbilityTd = false;

            //Info needed:
            boolean isAllAbilitiesCollected = false;
            //DAO
            AbilityDAO abilityDAO = null;
            while (reader.hasNext()) {
                try {
                    if (errorCount == 50) {
                        errorCount = 0;
                        break;
                    }
                    if (isAllAbilitiesCollected) {
                        abilityDAO = new AbilityDAO();
                        for (Ability ability : this.getAbilityList()) {
                            if (!abilityDAO.isAbilityExisted(ability.getAbilityName())) {
                                abilityDAO.insertAbility(ability);
                                System.out.println("Insert Ability: " + ability.getAbilityName().toUpperCase());
                            }
                        }
                        this.abilitiesList = new ArrayList<>();
                        break;
                    }
                    event = reader.nextEvent();
                    if (event.isStartElement()) {
                        startElement = event.asStartElement();
                        String tagName = startElement.getName().toString();
                        if (tagName.equals("div")) {
                            attribute = startElement.getAttributeByName(new QName("id"));
                            if (attribute != null && attribute.getValue().equals("mw-content-text")) {
                                isAbilityContainer = true;
                            }
                        }
                        if (isAbilityContainer && tagName.equals("table")) {
                            attribute = startElement.getAttributeByName(new QName("class"));
                            if (attribute != null && attribute.getValue().equals("wikitable")) {
                                isAbilityTable = true;
                            }
                        }
                        if (isAbilityTable && tagName.equals("td")) {
                            attribute = startElement.getAttributeByName(new QName("style"));
                            if (attribute != null && attribute.getValue().contains("background-color:")) {
                                isAbilityTd = true;
                            }
                        }
                        if (isAbilityTd && tagName.equals("a")) {
                            event = reader.nextEvent();
                            if (event.isCharacters()) {
                                if (event.asCharacters().getData().equals("Wimp Out")) {
                                    isAllAbilitiesCollected = true;
                                }
                                if (!event.asCharacters().getData().contains("Generation")) {
                                    this.getAbility().setAbilityName(event.asCharacters().getData());
                                    this.getAbility().setDescription(" ");
                                    this.getAbilityList().add(this.getAbility());
                                    ability = new Ability();
                                }
                            }
                        }
                    }

                } catch (XMLStreamException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    errorCount += 1;
                } catch (NullPointerException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    break;
                }
            }
        } catch (IOException e) {
            Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //azurilland.com
    public void crawl_PokemonAbilities(Pokemon pokemon) throws IOException, XMLStreamException {
        String pokemonName = cleanPokemonNameAzurill(pokemon.getEnglishName());
        String urlString = "https://www.azurilland.com/pokedex/"
                + pokemon.getNationalDexId()
                + "-"
                + pokemonName.toLowerCase();
        if (Integer.parseInt(pokemon.getNationalDexId().toString()) >= 651) {
            int number = 99351 + Integer.parseInt(pokemon.getNationalDexId().toString());
            urlString = "https://www.azurilland.com/pokedex/"
                    + number
                    + "-"
                    + pokemonName.toLowerCase();
        }
        try {
            XMLEventReader reader = readFromWebsite(urlString);
            XMLEvent event;

            //StaX Iterator API:
            Attribute attribute;
            StartElement startElement;
            int errorCount = 0;

            //Tag Flag:
            boolean isAbilityContainer = false;
            boolean isAbilityTable = false;

            //Info needed:
            boolean isPokemonAbilitiesCollected = false;
            //DAO
            AbilityDAO abilityDAO = null;
            PokemonDAO pkmDAO = null;
            PokemonAbilitiesDAO pkmAbiDAO = null;
            while (reader.hasNext()) {
                try {
                    if (errorCount == 50) {
                        errorCount = 0;
                        break;
                    }
                    if (isPokemonAbilitiesCollected) {
                        abilityDAO = new AbilityDAO();
                        pkmDAO = new PokemonDAO();
                        pkmAbiDAO = new PokemonAbilitiesDAO();
                        for (PokemonAbilities pkmAbilities : this.getAbilitiesList()) {
                            if (pkmDAO.isExistedInDB(Integer.parseInt(pkmAbilities.getPokemonId().toString()))
                                    && abilityDAO.isAbilityExisted(pkmAbilities.getAbilityName())) {
                                if (!pkmAbiDAO.isPokemonAbilityExisted(pkmAbilities)) {
                                    pkmAbiDAO.insertPokemonAbility(pkmAbilities);
                                    System.out.println("Insert Pokemon Ability - ID: " + pkmAbilities.getPokemonId()
                                            + "-Ability: " + pkmAbilities.getAbilityName().toUpperCase());
                                }
                            }
                        }
                        this.abilitiesList = new ArrayList<>();
                        break;
                    }
                    event = reader.nextEvent();
                    if (event.isStartElement()) {
                        startElement = event.asStartElement();
                        String tagName = startElement.getName().toString();
                        if (tagName.equals("table")) {
                            attribute = startElement.getAttributeByName(new QName("class"));
                            if (attribute != null && attribute.getValue().equals("listing listing-abilities b-table b-table-a")) {
                                isAbilityTable = true;
                            }
                        }
                        if (tagName.equals("a") && isAbilityTable) {
                            attribute = startElement.getAttributeByName(new QName("data-type-id"));
                            if (attribute != null && attribute.getValue().equals("10007")) {
                                isAbilityContainer = true;
                            }
                        }
                    }
                    if (isAbilityContainer) {
                        event = reader.nextEvent();
                        if (event.isCharacters()) {
                            this.getPokemonAbilities().setPokemonId(pokemon.getNationalDexId());
                            this.getPokemonAbilities().setAbilityName(event.asCharacters().getData());
                            this.getAbilitiesList().add(this.getPokemonAbilities());
                            isAbilityContainer = false;
                            this.pokemonAbilities = new PokemonAbilities();
                        }
                    }
                    if (isAbilityTable && event.isEndElement()) {
                        if (event.asEndElement().getName().toString().equals("table")) {
                            isPokemonAbilitiesCollected = true;
                            isAbilityTable = false;
                        }
                    }

                } catch (XMLStreamException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    errorCount += 1;
                } catch (NullPointerException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    break;
                }
            }
        } catch (IOException e) {
            Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //CRAWL STATS
    //ign.com
    public void crawl_PokemonStats(Pokemon pokemon) throws IOException, XMLStreamException {
        String pokemonName = cleanPokemonNameIGN(pokemon.getEnglishName());
        String urlString = "http://www.ign.com/pokedex/pokemon/" + pokemonName.toLowerCase();
        try {
            XMLEventReader reader = readFromWebsite(urlString);
            XMLEvent event;

            //StaX Iterator API:
            Attribute attribute;
            StartElement startElement;
            int errorCount = 0;

            //Tag Flag:
            boolean isStatsContainer = false;
            boolean isStatsTable = false;

            boolean isHpContainer = false;
            boolean isAtkContainer = false;
            boolean isDefContainer = false;
            boolean isSpAtkContainer = false;
            boolean isSpDefContainer = false;
            boolean isSpeedContainer = false;

            //Info needed:
            boolean isStatsCollected = false;
            //DAO
            PokemonDAO pkmDAO = null;
            PokemonStatsDAO pkmStatsDAO = null;
            while (reader.hasNext()) {
                try {
                    if (errorCount == 50) {
                        errorCount = 0;
                        break;
                    }
                    if (isStatsCollected) {
                        pkmDAO = new PokemonDAO();
                        pkmStatsDAO = new PokemonStatsDAO();
                        this.getPokemonStats().setPokemonId(pokemon.getNationalDexId());
                        if (pkmDAO.isExistedInDB(Integer.parseInt(this.getPokemonStats().getPokemonId().toString()))) {
                            pkmStatsDAO.insertPokemonStats(this.getPokemonStats());
                            System.out.println("Insert Pokemon Stats - Pokemon: " + this.getPokemonStats().getPokemonId() + "-" + pokemon.getEnglishName());
                            break;
                        }

                    }
                    event = reader.nextEvent();
                    if (event.isStartElement()) {
                        startElement = event.asStartElement();
                        String tagName = startElement.getName().toString();
                        //System.out.println(tagName);
                        //Find Pokemon romajiName
                        if (tagName.equals("{http://www.w3.org/1999/xhtml}table")) {
                            attribute = startElement.getAttributeByName(new QName("id"));
                            if (attribute != null && attribute.getValue().equals("table-stats")) {
                                isStatsTable = true;
                            }
                        }
                        if (tagName.equals("{http://www.w3.org/1999/xhtml}span") && isStatsTable) {
                            attribute = startElement.asStartElement().getAttributeByName(new QName("class"));
                            if (attribute != null) {
                                if (attribute.getValue().equals("pull-right")) {
                                    event = reader.nextEvent();
                                    if (event.isCharacters()) {
                                        if (event.asCharacters().getData().equals("HP")) {
                                            isHpContainer = true;
                                        } else if (event.asCharacters().getData().equals("ATTACK")) {
                                            isAtkContainer = true;
                                        } else if (event.asCharacters().getData().equals("DEFENSE")) {
                                            isDefContainer = true;
                                        } else if (event.asCharacters().getData().equals("SP. ATK")) {
                                            isSpAtkContainer = true;
                                        } else if (event.asCharacters().getData().equals("SP. DEF")) {
                                            isSpDefContainer = true;
                                        } else if (event.asCharacters().getData().equals("SPEED")) {
                                            isSpeedContainer = true;
                                        }
                                    }
                                }
                                if (attribute.getValue().equals("pull-left")) {
                                    event = reader.nextEvent();
                                    if (event.isCharacters()) {
                                        if (isHpContainer) {
                                            this.getPokemonStats().setBaseHP(BigInteger.valueOf(Long.valueOf(event.asCharacters().getData())));
                                            isHpContainer = false;
                                        } else if (isAtkContainer) {
                                            this.getPokemonStats().setAttack(BigInteger.valueOf(Long.valueOf(event.asCharacters().getData())));
                                            isAtkContainer = false;
                                        } else if (isDefContainer) {
                                            this.getPokemonStats().setDefense(BigInteger.valueOf(Long.valueOf(event.asCharacters().getData())));
                                            isDefContainer = false;
                                        } else if (isSpAtkContainer) {
                                            this.getPokemonStats().setSpAttack(BigInteger.valueOf(Long.valueOf(event.asCharacters().getData())));
                                            isSpAtkContainer = false;
                                        } else if (isSpDefContainer) {
                                            this.getPokemonStats().setSpDefense(BigInteger.valueOf(Long.valueOf(event.asCharacters().getData())));
                                            isSpDefContainer = false;
                                        } else if (isSpeedContainer) {
                                            this.getPokemonStats().setSpeed(BigInteger.valueOf(Long.valueOf(event.asCharacters().getData())));
                                            isSpeedContainer = false;
                                        }
                                    }
                                }
                            }

                        }

                    }
                    if (event.isEndElement() && isStatsTable) {
                        if (event.asEndElement().getName().toString().equals("{http://www.w3.org/1999/xhtml}table")) {
                            isStatsTable = false;
                            isStatsCollected = true;
                        }
                    }

                } catch (XMLStreamException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    errorCount += 1;
                } catch (NullPointerException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    break;
                }
            }
        } catch (IOException e) {
            Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //CRAWL MOVES
    //bulbapedia.bulbagarden.net
    public void crawl_Moves() throws IOException, XMLStreamException {
        String urlString = "https://bulbapedia.bulbagarden.net/wiki/List_of_moves";
        try {
            XMLEventReader reader = readFromWebsite(urlString);
            XMLEvent event;

            //StaX Iterator API:
            Attribute attribute;
            StartElement startElement;
            int errorCount = 0;

            //Tag Flag:
            boolean isMoveDiv = false;
            boolean isMoveTr = false;

            //Info needed:
            boolean isMoveCollected = false;
            boolean isAllMoveCollected = false;
            //DAO
            MoveDAO moveDAO = null;
            TypeDAO typeDAO = null;
            while (reader.hasNext()) {
                try {
                    if (errorCount == 50) {
                        errorCount = 0;
                        break;
                    }
                    if (isAllMoveCollected) {
                        break;
                    }
                    if (isMoveCollected) {
                        this.getMoveList().add(this.getMove());
                        this.move = new Move();
                        isMoveCollected = false;
                    }

                    if (this.getMoveList().size() > 0) {
                        moveDAO = new MoveDAO();
                        typeDAO = new TypeDAO();
                        for (Move move : this.getMoveList()) {
                            if (move.getName().equals("Land's Wrath")) {
                            }
                            if (!moveDAO.isMoveExisted(move) && typeDAO.isTypeExisted(move.getType())) {
                                if (moveDAO.insertMove(move)) {
                                    System.out.println("Insert Move: " + move.getName());
                                }
                            }
                        }
                        moveList = new ArrayList<>();
                    }

                    event = reader.nextEvent();
                    if (event.isStartElement()) {
                        startElement = event.asStartElement();
                        String tagName = startElement.getName().toString();
                        if (tagName.equals("table")) {
                            attribute = startElement.getAttributeByName(new QName("class"));
                            if (attribute != null && attribute.getValue().equals("sortable roundy")) {
                                isMoveDiv = true;
                            }
                        }

                        if (isMoveDiv && tagName.equals("tr")) {
                            isMoveTr = true;
                        }
                        if (isMoveTr && tagName.equals("a")) {
                            attribute = startElement.getAttributeByName(new QName("href"));
                            if (attribute != null) {
                                if (attribute.getValue().contains("_(move)")) {
                                    event = reader.nextEvent();
                                    if (event.isCharacters()) {
                                        this.getMove().setName(event.asCharacters().getData());
                                    }
                                }
                                if (attribute.getValue().contains("_(type)")) {
                                    event = reader.nextEvent();
                                    if (event.isStartElement()) {
                                        if (event.asStartElement().getName().toString().equals("span")) {
                                            event = reader.nextEvent();
                                            if (event.isCharacters()) {
                                                this.getMove().setType(event.asCharacters().getData());
                                            }
                                        }
                                    }
                                }

                                if (attribute.getValue().contains("_move")) {
                                    event = reader.nextEvent();
                                    if (event.isStartElement()) {
                                        if (event.asStartElement().getName().toString().equals("span")) {
                                            event = reader.nextEvent();
                                            if (event.isCharacters()) {
                                                this.getMove().setCategory(event.asCharacters().getData());
                                            }
                                        }
                                    }
                                }
                                if (attribute.getValue().contains("_(condition)")) {
                                    event = reader.nextEvent();
                                    String PpPowerAcc = "";
                                    while (true) {
                                        if (event.isStartElement()) {
                                            if (event.asStartElement().getName().toString().equals("td")) {
                                                event = reader.nextEvent();
                                                if (event.isCharacters()) {
                                                    PpPowerAcc += event.asCharacters().getData() + ":";
                                                }
                                            }
                                        }
                                        if (event.isEndElement()) {
                                            if (event.asEndElement().getName().toString().equals("tr")) {
                                                isMoveTr = false;
                                                String[] moveSpecArray = PpPowerAcc.split(":");
                                                if (moveSpecArray.length < 4) {
                                                    String temp0 = moveSpecArray[0];
                                                    String temp1 = moveSpecArray[1];
                                                    String temp2 = moveSpecArray[2];
                                                    moveSpecArray = new String[4];
                                                    moveSpecArray[0] = temp0;
                                                    moveSpecArray[1] = "--";
                                                    moveSpecArray[2] = temp1;
                                                    moveSpecArray[3] = temp2;
                                                }
                                                if (moveSpecArray != null) {
                                                    this.getMove().setPp(BigInteger.valueOf(Long.valueOf(moveSpecArray[0])));
                                                    this.getMove().setPower(moveSpecArray[1]);
                                                    this.getMove().setAccuracy(moveSpecArray[2]);
                                                    this.getMove().setGenerationAppearance(moveSpecArray[3]);
                                                }
                                                isMoveCollected = true;
                                                break; // break inner loop
                                            }
                                        }
                                        event = reader.nextEvent();
                                    }
                                }
                            }
                        }
                        if (tagName.equals("span") && isMoveDiv) {
                            attribute = startElement.getAttributeByName(new QName("id"));
                            if (attribute != null && attribute.getValue().equals("List_of_Shadow_moves")) {
                                isMoveDiv = false;
                                isAllMoveCollected = true;
                            }
                        }
                    }

                } catch (XMLStreamException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    errorCount += 1;
                } catch (NullPointerException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);

                }
            }
        } catch (IOException e) {
            Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //bulbapedia.bulbagarden.net
    public void crawlPokemonMoves(Pokemon pokemon) throws IOException, XMLStreamException {
        String pokemonName = cleanPokemonNameBulbapedia(pokemon.getEnglishName());
        String urlString = "https://bulbapedia.bulbagarden.net/wiki/" + pokemonName + "_(Pok%C3%A9mon)/Generation_VI_learnset#By_leveling_up";
        try {
            XMLEventReader reader = readFromWebsite(urlString);
            XMLEvent event;

            //StaX Iterator API:
            Attribute attribute;
            StartElement startElement;
            int errorCount = 0;

            //Tag Flag:
            boolean isMovesTable = false;
            boolean isMovesTr = false;
            boolean isMoveTbody = false;
            //Info needed:
            boolean isMoveCollected = false;
            boolean isAllMoveCollected = false;
            //DAO
            MoveDAO moveDAO = null;
            PokemonDAO pokemonDAO = null;
            PokemonMovesDAO pkmMovesDAO = null;
            while (reader.hasNext()) {
                try {
                    if (errorCount == 50) {
                        errorCount = 0;
                        break;
                    }
                    if (isAllMoveCollected) {
                        moveDAO = new MoveDAO();
                        pokemonDAO = new PokemonDAO();
                        pkmMovesDAO = new PokemonMovesDAO();
                        for (PokemonMoves pkmMoves : this.getPokemonMoveList()) {
                            if (pokemonDAO.isExistedInDB(Integer.parseInt(pkmMoves.getPokemonId().toString())) && moveDAO.isMoveExisted(pkmMoves.getMoveName())) {
                                if (!pkmMovesDAO.isPokemonAbilityExisted(pkmMoves)) {
                                    if (pkmMovesDAO.insertPokemonMove(pkmMoves)) {
                                        System.out.println("Insert PokemonMoves: " + pkmMoves.getPokemonId() + "-"
                                                + pkmMoves.getMoveName().toUpperCase() + "-at Level: " + pkmMoves.getLearntByLevelUp());
                                    }
                                }
                            }
                        }
                        this.pokemonMoveList = new ArrayList<>();
                        break;
                    }
                    if (isMoveCollected) {
                        this.getPokemonMoveList().add(this.getPokemonMoves());
                        this.pokemonMoves = new PokemonMoves();
                        isMoveCollected = false;
                    }
                    event = reader.nextEvent();

                    if (event.isStartElement()) {
                        startElement = event.asStartElement();
                        String tagName = startElement.getName().toString();
                        if (tagName.equals("table")) {
                            attribute = startElement.getAttributeByName(new QName("class"));
                            if (attribute != null && attribute.getValue().equals("sortable")) {
                                isMovesTable = true;
                            }
                        }

                        if (isMovesTable && tagName.equals("tr")) {
                            attribute = startElement.getAttributeByName(new QName("style"));
                            if (attribute == null) {
                                isMovesTr = true;
                                this.getPokemonMoves().setPokemonId(pokemon.getNationalDexId());
                            }
                        }
                        if (isMovesTr) {
                            if (tagName.equals("span")) {
                                event = reader.nextEvent();
                                if (event.isCharacters()) {
                                    if (!event.asCharacters().getData().equals("N/A")) {
                                        this.getPokemonMoves().setLearntByLevelUp(BigInteger.valueOf(Long.valueOf(event.asCharacters().getData())));
                                    }
                                }
                            }
                            if (tagName.equals("a")) {
                                attribute = startElement.getAttributeByName(new QName("title"));
                                if (attribute != null && attribute.getValue().contains("(move)")) {
                                    event = reader.nextEvent();
                                    if (event.isStartElement()) {
                                        startElement = event.asStartElement();
                                        if (startElement.getName().toString().equals("span")) {
                                            event = reader.nextEvent();
                                            if (event.isCharacters()) {
                                                this.getPokemonMoves().setMoveName(event.asCharacters().getData());
                                                isMovesTr = false;
                                                isMoveCollected = true;
                                            }
                                        }
                                    }
                                }
                            }
                            if (tagName.equals("b")) {
                                event = reader.nextEvent();
                                if (event.isStartElement() && event.asStartElement().getName().toString().equals("a")) {
                                    attribute = event.asStartElement().getAttributeByName(new QName("title"));
                                    if (attribute != null && attribute.getValue().contains("(move)")) {
                                        event = reader.nextEvent();
                                        if (event.isStartElement()) {
                                            startElement = event.asStartElement();
                                            if (startElement.getName().toString().equals("span")) {
                                                event = reader.nextEvent();
                                                if (event.isCharacters()) {
                                                    this.getPokemonMoves().setMoveName(event.asCharacters().getData());
                                                    isMovesTr = false;
                                                    isMoveCollected = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }
                    if (!isMovesTr && isMovesTable) {
                        if (event.isEndElement()) {
                            if (event.asEndElement().getName().toString().equals("table")) {
                                isAllMoveCollected = true;
                            }
                        }
                    }
                } catch (XMLStreamException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    errorCount += 1;
                } catch (NullPointerException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    return;
                }
            }
        } catch (IOException e) {
            Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //bulbapedia.bulbagarden.net
    public void crawlTypesInteraction(Type type) throws IOException, XMLStreamException {
        String urlString = "https://pokemondb.net/type";
        try {
            XMLEventReader reader = readFromWebsite(urlString);
            XMLEvent event;

            //StaX Iterator API:
            Attribute attribute;
            StartElement startElement;
            int errorCount = 0;

            //Tag Flag:
            boolean isTypeTable = false;
            boolean isTypeTr = false;
            //Info needed:
            boolean isAllTypeCollected = false;
            //DAO
            TypeDAO typeDAO = null;
            TypeInteractionDAO typeIntDAO = null;
            while (reader.hasNext()) {
                try {
                    if (errorCount == 50) {
                        errorCount = 0;
                        break;
                    }
                    if (isAllTypeCollected) {
                        typeDAO = new TypeDAO();
                        typeIntDAO = new TypeInteractionDAO();
                        for (TypeInteraction typeInteraction : this.getTypeInteractionList().getTypeInteraction()) {
                            if (typeDAO.isTypeExisted(typeInteraction.getAttackType()) && typeDAO.isTypeExisted(typeInteraction.getDefenseType())) {
                                if (!typeIntDAO.isTypeInteractionExisted(typeInteraction)) {
                                    typeIntDAO.insertType(typeInteraction);
                                    System.out.println("Insert Type Interaction: " + typeInteraction.getAttackType() + " → " + typeInteraction.getDefenseType()
                                            + " - Effect: " + typeInteraction.getEffect() + " (" + typeInteraction.getEffectMultipler() + ")");
                                }
                            }
                        }
                        typeInteractionList = new TypeInteractionList();
                        break;
                    }
                    event = reader.nextEvent();
                    if (event.isStartElement()) {
                        startElement = event.asStartElement();
                        String tagName = startElement.getName().toString();
                        if (tagName.equals("table")) {
                            attribute = startElement.getAttributeByName(new QName("class"));
                            if (attribute != null && attribute.getValue().equals("type-table")) {
                                isTypeTable = true;
                            }
                        }
                        if (isTypeTable && tagName.equals("a")) {
                            attribute = startElement.getAttributeByName(new QName("class"));
                            if (attribute != null && attribute.getValue().contains("type-icon-th type-" + type.getTypeLabel().toLowerCase())) {
                                isTypeTr = true;
                            }
                        }
                        if (isTypeTr && tagName.equals("td")) {
                            attribute = startElement.getAttributeByName(new QName("title"));
                            if (attribute != null) {
                                String attrString = attribute.getValue();
                                if (attrString.contains("→ Normal")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Normal");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Fire")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Fire");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("norma- effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Water")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Water");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no-effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Electric")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Electric");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Grass")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Grass");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Ice")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Ice");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Fighting")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Fighting");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Poison")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Poison");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Ground")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Ground");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Flying")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Flying");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Psychic")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Psychic");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Bug")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Bug");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Rock")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Rock");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-ery-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Ghost")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Ghost");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Dragon")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Dragon");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Dark")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Dark");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Steel")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Steel");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                if (attrString.contains("→ Fairy")) {
                                    this.getTypeInteraction().setAttackType(type.getTypeLabel());
                                    this.getTypeInteraction().setDefenseType("Fairy");
                                    if (attrString.contains("normal effectiveness")) {
                                        this.getTypeInteraction().setEffect("normal-effective");
                                        this.getTypeInteraction().setEffectMultipler("1");
                                    } else if (attrString.contains("not very effective")) {
                                        this.getTypeInteraction().setEffect("not-very-effective");
                                        this.getTypeInteraction().setEffectMultipler("0.5");
                                    } else if (attrString.contains("super-effective")) {
                                        this.getTypeInteraction().setEffect("super-effective");
                                        this.getTypeInteraction().setEffectMultipler("2");
                                    } else if (attrString.contains("no effect")) {
                                        this.getTypeInteraction().setEffect("no-effect");
                                        this.getTypeInteraction().setEffectMultipler("0");
                                    }
                                }
                                this.getTypeInteractionList().getTypeInteraction().add(this.getTypeInteraction());
                                this.typeInteraction = new TypeInteraction();
                            }
                        }
                    }
                    if (isTypeTr && event.isEndElement()) {
                        if (event.asEndElement().getName().toString().equals("tr")) {
                            isTypeTr = false;
                            isTypeTable = false;
                            isAllTypeCollected = true;
                        }
                    }
                } catch (XMLStreamException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    errorCount += 1;
                } catch (NullPointerException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);

                }
            }
        } catch (IOException e) {
            Logger.getLogger(DataCrawler.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
