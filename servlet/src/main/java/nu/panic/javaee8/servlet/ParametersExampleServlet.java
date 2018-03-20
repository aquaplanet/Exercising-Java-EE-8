package nu.panic.javaee8.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.OptionalInt;

/**
 * <p>You know, the funny thing with servlets are
 * that each is just one URL...so prepare to have a lot
 * of them.</p>
 *
 * <p>Start the Wildfly server (mvn exec:exec) and press this link for a demonstration.</p>
 * <a href="http://localhost:8080/parameters?name=Anders&amp;age=20">http://localhost:8080/parameters?name=Anders&amp;age=20</a>
 */
@WebServlet(urlPatterns = "/parameters")
public class ParametersExampleServlet extends HttpServlet {

    /**
     * You are meant to call this with two parameters namely name and age. You can try this <a href="http://localhost:8080/parameters?name=Anders&amp;age=20">http://localhost:8080/parameters?name=Anders&amp;age=20</a>
     * @param req Standard servlet request
     * @param resp Standard servlet response
     * @throws ServletException Standard servlet exception
     * @throws IOException Standard servlet exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Ohhh...one can GET PARAMETERS!!! W00000t. Seriously, you can only get String parameters and you will
        // need to convert them if you need something else.
        String parameter = req.getParameter("name");
        String age = req.getParameter("age");
        try (PrintWriter out = resp.getWriter()) {

            out.println("Tjenare " + parameter + "! Hur é dé lääget *ful Stockholmska...för göteborgare är bättre och talar alltså bättre*?");
            try {
                out.println("Oj är det " + (33-Integer.parseInt(age)) + " år skillnad mellan oss!");
            } catch (NumberFormatException e) {}
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(202);
    }
}
