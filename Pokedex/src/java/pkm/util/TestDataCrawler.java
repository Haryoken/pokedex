/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;

/**
 *
 * @author DUCVINH
 */
public class TestDataCrawler {
    public static void main(String[] agrs){
        DataCrawler crawler = new DataCrawler();
        try {
            crawler.crawlAllPokemonIdAndName("https://bulbapedia.bulbagarden.net/wiki/List_of_Pok%C3%A9mon_by_National_Pok%C3%A9dex_number");
        } catch (IOException ex) {
            Logger.getLogger(TestDataCrawler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XMLStreamException ex) {
            Logger.getLogger(TestDataCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
