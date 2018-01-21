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
 * <p>All servlets in a single war file share the same ServletContext. This means you can add data to this Context and
 * retrieve it later in another servlet (see this class and ServletContextExampleTwo). ServletContext can also give you
 * other things such as:</p>
 * <ul>
 *     <li>context.getResourceAsStream()</li>
 *     <li>context.addListener()</li>
 *     <li>context.getSessionCookieConfig()</li>
 * </ul>
 *
 * <p>Start the Wildfly server (mvn exec:exec) and press this link for a demonstration.</p>
 * <a href="http://localhost:8080/servletContextFirst">http://localhost:8080/servletContextFirst</a>
 * <p>You should also go to this other servlet to see that the attribute "AttributeByAnders" is saved in the ServletContext</p>
 * <a href="http://localhost:8080/servletContextSecond">http://localhost:8080/servletContextSecond</a>
 *
 * @see ServletContextExampleTwo
 */
@WebServlet("/servletContextFirst")
public class ServletContextExampleOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        context.setAttribute("AttributeByAnders", "Woow, attributes can be picked up by other servlets in this context");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><body>I got this from the ServletContext:<p/>");
            out.println("You are running Java " + context.getMajorVersion() + "." + context.getMinorVersion() + "<p/>");
            out.println("Now go to <a href=\"http://localhost:8080/servletContextSecond\">here</a> to see that my attribute is saved between servlets.</body></html>");
        }
    }
}
