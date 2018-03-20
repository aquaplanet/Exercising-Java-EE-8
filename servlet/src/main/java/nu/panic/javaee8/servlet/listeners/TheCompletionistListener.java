package nu.panic.javaee8.servlet.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TheCompletionistListener implements ServletRequestListener {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        logger.info("The request is destroyed, sad!");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        logger.info("The request is initialized, sad!");
    }
}
