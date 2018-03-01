/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;
import pkm.dao.PokemonDAO;
import pkm.xml.object.PokemonList.xsd.Pokemon;

/**
 *
 * @author DUCVINH
 */
public class TestDataCrawler {

    public static void main(String[] agrs) {
        DataCrawler crawler = new DataCrawler();
        try {
            PokemonDAO pkmDao = new PokemonDAO();
            List<Pokemon> pokemonList = pkmDao.getAllthePokemon();
            //crawler.crawlAllPokemonIdAndName();
            if (pokemonList.size() > 0) {
                for(Pokemon pokemon: pokemonList){
                    crawler.crawl_baseXP_baseHappiness_catchRate_growthRate(pokemon);
                }
            }
//        Pokemon pkm = new Pokemon();
//        pkm.setEnglishName("Mime Jr.");
//        pkm.setNationalDexId(BigInteger.valueOf(439));
//        crawler.crawl_baseXP_baseHappiness_catchRate_growthRate(pkm);
        } catch (IOException ex) {
            Logger.getLogger(TestDataCrawler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XMLStreamException ex) {
            Logger.getLogger(TestDataCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
