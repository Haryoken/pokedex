/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.listener;

import java.util.Timer;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import pkm.util.CrawlBasicInfoTask;
import pkm.util.CrawlDetailsInfoTask;

/**
 *
 * @author DUCVINH
 */
@WebListener
public class CrawlingListener implements ServletContextListener {
    Timer timer;
    CrawlBasicInfoTask basicInfoTimerTask;
    CrawlDetailsInfoTask detailsTask;

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
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.timer = new Timer();
        this.basicInfoTimerTask = new CrawlBasicInfoTask();        
        timer.schedule(this.getBasicInfoTimerTask(), TimeUnit.SECONDS.toMillis(10), TimeUnit.HOURS.toMillis(24));
        
        this.detailsTask = new CrawlDetailsInfoTask();
        timer.schedule(this.getDetailsTask(),TimeUnit.SECONDS.toMillis(10), TimeUnit.HOURS.toMillis(24));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
}
