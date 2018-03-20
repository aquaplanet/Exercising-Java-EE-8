package nu.panic.javaee8.servlet.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * <p>With Java you can get longer names than She can take ;-)</p>
 *
 * <p>This ...AttributeListener looks for changes in attributes. I might imagine a scenario where that is
 * useful. I am still trying to figure out a scenario where attributes are useful but perhaps in a country
 * far away it is useful.</p>
 *
 * <p>Start the Wildfly server (mvn exec:exec) and press this link for a demonstration.</p>
 * <a href="http://localhost:8080/servletContextFirst">http://localhost:8080/servletContextFirst</a>
 * <p>Then look for MegaPhatServletContextAttributeListener in the logs.</p>
 */

@WebListener
public class MegaPhatServletContextAttributeListener implements ServletContextAttributeListener {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        logger.info("Just created an attribute, DUDE. It is called {} and contains {}, DUDE",
                servletContextAttributeEvent.getName(),
                servletContextAttributeEvent.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {

    }
}
