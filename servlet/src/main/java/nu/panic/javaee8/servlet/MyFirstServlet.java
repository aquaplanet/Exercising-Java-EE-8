package nu.panic.javaee8.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * <p>A servlet is a class annotated with @WebServlet
 * and extends javax.servlet.http.HttpServlet
 * Remember you can read more about Servlet in the specifikations.</p>
 *
 * @see <a href="https://javaee.github.io/javaee-spec/">Java EE Specifikations on Github</a>
 * @see <a href="http://download.oracle.com/otndocs/jcp/servlet-3_1-fr-eval-spec/index.html">Java EE 7 Servlet 3.1 Specification</a>
 * @see <a href="http://download.oracle.com/otndocs/jcp/servlet-4-final-eval-spec/index.html">Java EE 8 Servlet 4 Specification</a>
 */
@WebServlet(urlPatterns = "/firstServlet")
public class MyFirstServlet extends HttpServlet {

    // If you receive a GET request do this
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);  <-- remember to remove this mother fucker
        // Otherwise you get the error: HTTP Status 405 - HTTP method GET is not supported by this URL
        // https://stackoverflow.com/questions/5370633/http-status-405-http-method-get-is-not-supported-by-this-url
        resp.setContentType("text/html");
        resp.setHeader("Programmer-Reponsibilities","Content and headers");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<html>You are the best! You are so far, beautiful work!</html>");
        }
    }
}
