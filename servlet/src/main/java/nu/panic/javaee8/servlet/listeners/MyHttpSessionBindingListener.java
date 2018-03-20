package nu.panic.javaee8.servlet.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener
public class MyHttpSessionBindingListener implements HttpSessionBindingListener {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        logger.info("Value bound for session {} with name {} and value {}",
                httpSessionBindingEvent.getSession(),
                httpSessionBindingEvent.getName(),
                httpSessionBindingEvent.getValue());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        logger.info("and now the value ({}={}) is not bound anymore for session {}",
                httpSessionBindingEvent.getName(),
                httpSessionBindingEvent.getValue(),
                httpSessionBindingEvent.getSession());
    }
}
