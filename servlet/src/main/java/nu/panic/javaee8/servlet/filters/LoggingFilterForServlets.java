package nu.panic.javaee8.servlet.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * <p>Filters are like middleware in NodeJS Express. They sit between the receiving end and your servlet and intercepts
 * the messages. Here I demonstrate it by logging the incoming request. It is not however exactly like Express as
 * I find the things you can get from {@link ServletRequest} and {@link ServletResponse} is rather limited.
 * I have not been able to read the headers or url from the request (could probably read its contents but that is not
 * what I would like to do.</p>
 *
 * <p>But you can still prevent the servlets to get the request what so ever by just responding to the request.</p>
 *
 * <p>Start the Wildfly server (mvn exec:exec) and press this link for a demonstration.</p>
 * <a href="http://localhost:8080/cookies">http://localhost:8080/cookies</a>
 * <p>This demonstration prints something to the logs so don't stare too much at the browser.</p>
 */
//@WebFilter("/*")
public class LoggingFilterForServlets implements Filter {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Got request for {}:{}/{}", servletRequest.getRemoteAddr(), servletRequest.getRemoteAddr());

        // Uncomment this and prevent any servlet to get any requests at all. Starving them to death and conquer the WORLD!
        // try (PrintWriter w = servletResponse.getWriter()) {
        //     w.println("Logging will not send data to the servlet...hahaha");
        // }
    }

    @Override
    public void destroy() {

    }
}
