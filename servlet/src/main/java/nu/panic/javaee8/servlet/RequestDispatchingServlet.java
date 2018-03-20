package nu.panic.javaee8.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>This does about nothing. It just sends the request forward. The user using this service does
 * not notice that another servlet does the work, that is, the URL is not changed.</p>
 *
 * <p>For a redirect: see {@link RedirectingServlet}</p>
 *
 * <p>Start the Wildfly server (mvn exec:exec) and press this link for a demonstration.</p>
 * <a href="http://localhost:8080/servletContextFirst">http://localhost:8080/servletContextFirst</a>
 * <p>You should also go to this other servlet to see that the attribute "AttributeByAnders" is saved in the ServletContext</p>
 * <a href="http://localhost:8080/servletContextSecond">http://localhost:8080/servletContextSecond</a>
 *
 * @see DispatchRequestsToMe
 */
@WebServlet("/requestDispatchingServlet")
public class RequestDispatchingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        context.getRequestDispatcher("/IgetRequestsDispatchedToMe").forward(req, resp);
    }
}
