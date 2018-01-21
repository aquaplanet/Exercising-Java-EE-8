package nu.panic.practicejavaee8.servlet.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Listeners listens for events. Who knew? This ServletContextListener fires up when the context lives or dies.
 *
 * <p>Start the Wildfly server (mvn exec:exec) and read the logs when the thing starts. Remember to look for
 * BlahdiblahServletContextListener in the log output.</p>
 */
@WebListener
public class BlahdiblahServletContextListener implements ServletContextListener {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("The context is initialized, whatever that means, but you can get the context and do whatever the fuck you want.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("RIP ServletContext...it is dead and destroyed!");
    }
}
