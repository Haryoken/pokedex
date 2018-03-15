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
import pkm.dao.TypeDAO;
import pkm.xml.object.PokemonList.xsd.Pokemon;
import pkm.xml.object.TypeList.xsd.Type;

/**
 *
 * @author DUCVINH
 */
public class TestDataCrawler {

    public static void main(String[] agrs) {
        DataCrawler crawler = new DataCrawler();
        try {
//            crawler.crawl_All_Types();
//            crawler.crawl_All_Ability();
//            crawler.crawl_All_nationalDexId_englishName();
//            crawler.crawl_Moves();
//            
//            TypeDAO typeDAO = new TypeDAO();
//            List<Type> typeList = typeDAO.getAllType();
//            if (typeList.size() > 0) {
//                for (Type type : typeList) {
//                    crawler.crawlTypesInteraction(type);
//                }
//            }
            
//            PokemonDAO pkmDao = new PokemonDAO();
//            List<Pokemon> pokemonList = pkmDao.getPokemonBeforeGenVII();
//            if (pokemonList.size() > 0) {
//                for (Pokemon pokemon : pokemonList) {
//                    crawler.crawlRomJapImage(pokemon);
//                    crawler.crawl_baseHappiness(pokemon);
//                    crawler.crawl_baseXP_catchRate(pokemon);
//                    crawler.crawl_levelRate(pokemon);                   
//                    crawler.crawl_PokemonStats(pokemon);
//                    crawler.crawl_PokemonAbilities(pokemon);
//                    crawler.crawlPokemonMoves(pokemon);
//                }
//            }
            Pokemon pkm = new Pokemon();
            pkm.setEnglishName("Bulbasaur");
            pkm.setNationalDexId(BigInteger.valueOf(1));
            crawler.crawlRomJapImage(pkm);
//            crawler.crawl_baseXP_catchRate(pkm);
//            crawler.crawl_levelRate(pkm);
//
//            crawler.crawl_PokemonStats(pkm);
//            crawler.crawl_PokemonAbilities(pkm);
//            crawler.crawlPokemonMoves(pkm);

        } catch (IOException ex) {
            Logger.getLogger(TestDataCrawler.class.getName()).log(Level.SEVERE, null, ex);

        } catch (XMLStreamException ex) {
            Logger.getLogger(TestDataCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
