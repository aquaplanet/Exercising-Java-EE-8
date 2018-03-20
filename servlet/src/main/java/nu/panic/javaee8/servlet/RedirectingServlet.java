package nu.panic.javaee8.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>This servlet redirects the calls to my first servlet.</p>
 *
 * <p>Do note that in {@link RequestDispatchingServlet} we did some kind of redirect, but that was within the
 * servlet container. That is actually faster than this, since the client only needs to do one request (here it is
 * told to ask for another url instead). Also the original request is gone as the client just starts a new one. One
 * useful thing with a redirect is of course that you can redirect to another website which is not under this servlet
 * context.</p>
 *
 * <p>Start the Wildfly server (mvn exec:exec) and press this link for a demonstration.</p>
 * <a href="http://localhost:8080/redirectToFirstServlet">http://localhost:8080/redirectToFirstServlet</a>
 */
@WebServlet("/redirectToFirstServlet")
public class RedirectingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/firstServlet");
    }
}
