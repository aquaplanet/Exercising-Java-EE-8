package nu.panic.javaee8.servlet.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

@WebListener
public class BoringHttpSessionZzzzMulliMupp implements HttpSessionActivationListener {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        logger.info("The session will passivate, like who cares.");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        logger.info("The session activated...Ohh I am so bored...now.");
    }
}
