/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.listener;

import java.io.IOException;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import pkm.util.CrawlBasicInfoTask;
import pkm.util.CrawlDetailsInfoTask;
import pkm.util.JAXBHelper;
import pkm.util.SchemaBinding;
import pkm.util.SchemaBindingTask;

/**
 *
 * @author DUCVINH
 */
@WebListener
public class CrawlingListener implements ServletContextListener {

    private Timer timer;
    private CrawlBasicInfoTask basicInfoTimerTask;
    private CrawlDetailsInfoTask detailsTask;
    private SchemaBindingTask schemaBindingTask;

    public CrawlDetailsInfoTask getDetailsTask() {
        return detailsTask;
    }

    public void setDetailsTask(CrawlDetailsInfoTask detailsTask) {
        this.detailsTask = detailsTask;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public CrawlBasicInfoTask getBasicInfoTimerTask() {
        return basicInfoTimerTask;
    }

    public void setBasicInfoTimerTask(CrawlBasicInfoTask basicInfoTimerTask) {
        this.basicInfoTimerTask = basicInfoTimerTask;
    }

    public SchemaBindingTask getSchemaBindingTask() {
        return schemaBindingTask;
    }

    public void setSchemaBindingTask(SchemaBindingTask schemaBindingTask) {
        this.schemaBindingTask = schemaBindingTask;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        this.timer = new Timer();
        
//        this.schemaBindingTask = new SchemaBindingTask();
//        timer.schedule(this.getSchemaBindingTask(), TimeUnit.SECONDS.toMillis(10));
        
        this.basicInfoTimerTask = new CrawlBasicInfoTask();
        timer.schedule(this.getBasicInfoTimerTask(), TimeUnit.SECONDS.toMillis(10), TimeUnit.HOURS.toMillis(24));

        this.detailsTask = new CrawlDetailsInfoTask();
        timer.schedule(this.getDetailsTask(), TimeUnit.SECONDS.toMillis(10), TimeUnit.HOURS.toMillis(24));
        
        

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
