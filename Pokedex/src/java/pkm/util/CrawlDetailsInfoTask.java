/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.util;

import java.io.IOException;
import java.util.List;
import java.util.TimerTask;
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
public class CrawlDetailsInfoTask extends TimerTask {

    private DataCrawler crawler;
    private TypeDAO typeDAO;
    private PokemonDAO pkmDAO;

    public CrawlDetailsInfoTask() {
        crawler = new DataCrawler();
        typeDAO = new TypeDAO();
        pkmDAO = new PokemonDAO();
    }

    @Override
    public void run() {
        try {
            List<Type> typeList = typeDAO.getAllType();
            if (typeList.size() > 0) {
                for (Type type : typeList) {
                    crawler.crawlTypesInteraction(type);
                }
            }

            List<Pokemon> pokemonList = pkmDAO.getPokemonBeforeGenVII();
            if (pokemonList.size() > 0) {
                for (Pokemon pokemon : pokemonList) {
                    crawler.crawl_baseHappiness(pokemon);
                    crawler.crawl_baseXP_catchRate(pokemon);
                    crawler.crawl_levelRate(pokemon);
                    crawler.crawlRomJapImage(pokemon);
                    crawler.crawl_PokemonStats(pokemon);
                    crawler.crawl_PokemonAbilities(pokemon);
                    crawler.crawlPokemonMoves(pokemon);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(CrawlDetailsInfoTask.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XMLStreamException ex) {
            Logger.getLogger(CrawlDetailsInfoTask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
