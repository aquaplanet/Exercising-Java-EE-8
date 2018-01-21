package nu.panic.practicejavaee8.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>In this example I show you how to use attributes between Servlet calls. First you should go to
 * {@link ServletContextExampleOne} to set the attribute. Otherwise the attribute (called AttributeByAnders) is null.</p>
 *
 * <p>One interesting thing seems to be that the attribute is global to all. Even if I open the second URL in another
 * browser with cleared cache, the attribute is still set. It is very logical if I think about it as I do nothing
 * to check for who is looking at the page. Even more logical as the servlet is probably handling alot of users and
 * keeping track of them all would require some kind of persistence store.</p>
 *
 * <p>Start the Wildfly server (mvn exec:exec) and press this link for a demonstration.</p>
 * <a href="http://localhost:8080/servletContextFirst">http://localhost:8080/servletContextFirst</a>
 * <p>You should also go to this other servlet to see that the attribute "AttributeByAnders" is saved in the ServletContext</p>
 * <a href="http://localhost:8080/servletContextSecond">http://localhost:8080/servletContextSecond</a>
 *
 * @see ServletContextExampleOne
 */
@WebServlet("/servletContextSecond")
public class ServletContextExampleTwo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();

        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><body>The value of my attribute is: " + context.getAttribute("AttributeByAnders") + "</body></html>");
        }
    }
}
