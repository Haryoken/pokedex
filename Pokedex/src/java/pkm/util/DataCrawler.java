/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.util;

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
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
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

    public DataCrawler() {
        pokemon = new Pokemon();
        pokemonList = new PokemonList();
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void crawlPokemon(String urlString) throws IOException, XMLStreamException {
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

        while (reader.hasNext()) {
            try {
                event = reader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    String tagName = startElement.getName().toString();
                    System.out.println(tagName); // For Debug Porpurse

                    //Find the pokemon englishName:
                    if (tagName.equals("h1")) {
                        Attribute attribute = startElement.getAttributeByName(new QName("id"));
                        if (attribute != null && attribute.getValue().equals("firstHeading")) {
                            event = reader.nextEvent();
                            if (event.isCharacters()) {

                                this.getPokemon().setEnglishName(event.asCharacters().toString().replace("(Pokémon)", "").trim());

                            }
                        }
                    }
                    if (tagName.equals("a")) { // <a title = "List of Pokémon by National Pokédex number">
                        Attribute attribute = startElement.getAttributeByName(new QName("title"));
                        if (attribute != null && attribute.getValue().equals("List of Pokémon by National Pokédex number")) {
                            event = reader.nextEvent();
                            if (event.isStartElement()) {
                                startElement = event.asStartElement();
                                if (startElement.getName().toString().equals("span")) //<span>;
                                {
                                    event = reader.nextEvent();
                                }
                                if (event.isCharacters()) {
                                    String idString = event.asCharacters().toString();
                                    if (!idString.equals("Pokémon")) {
                                        idString = idString.substring(1);
                                        this.getPokemon().setNationalDexId(BigInteger.valueOf(Long.parseLong(idString)));
                                    }
                                }
                            }

                        }
                    }
                }

            } catch (XMLStreamException e) {
                System.out.println("XMLStreamException: " + e.getMessage());
            }
        }
        //System.out.println("TYPE: " + getPokemonType().getTypeLabel());

    }

    public void crawlAllPokemonIdAndName(String urlString) throws IOException, XMLStreamException {
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

        while (reader.hasNext()) {
            try {
                StartElement startElement;
                Attribute attribute;

                boolean isNationalDexTag = false;
                boolean isPokemonNameTag = false;
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
                                            isNationalDexTag = false;
                                        }
                                    }
                                    break;
                                }
                                event = reader.nextEvent(); // LOOP continue 
                            }
                        }
                    }
                    if (tagName.equals("a")) {
                        attribute = startElement.getAttributeByName(new QName("title"));
                        if (attribute != null && attribute.getValue().contains("(Pokémon)") && !attribute.getValue().contains("Victini") ) {
                            isPokemonNameTag = true;
                            event = reader.nextEvent();
                        }
                        if (event.isCharacters() && isPokemonNameTag) {
                            String name = event.asCharacters().toString().trim();
                            //System.out.println(name.toUpperCase()); //For DEBUG Purpose
                            this.getPokemon().setEnglishName(name);
                              pokemonList.getPokemon().add(pokemon);
                        }
                    }

                }

            } catch (XMLStreamException e) {
                System.out.println("XMLStreamException: " + e.getMessage());
            }
        }

    }
}
