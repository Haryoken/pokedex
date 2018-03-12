/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.util;

import java.io.IOException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;

/**
 *
 * @author DUCVINH
 */
public class CrawlBasicInfoTask extends TimerTask {

    private DataCrawler crawler = null;

    public CrawlBasicInfoTask() {
        crawler = new DataCrawler();
    }

    @Override
    public void run() {
        try {
            if (crawler != null) {
                crawler.crawl_All_Types();
                crawler.crawl_All_nationalDexId_englishName();
                crawler.crawl_All_Ability();
                crawler.crawl_Moves();
            }
        } catch (IOException ex) {
            Logger.getLogger(CrawlBasicInfoTask.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XMLStreamException ex) {
            Logger.getLogger(CrawlBasicInfoTask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
