package nu.panic.practicejavaee8.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

/**
 * <p>Demonstrates how cookies work.</p>
 *
 * <p>Start the Wildfly server (mvn exec:exec) and press this link for a demonstration.</p>
 * <a href="http://localhost:8080/cookies">http://localhost:8080/cookies</a>
 */
@WebServlet("/cookies")
public class Cookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookieJar = req.getCookies();

        // The if-statement checks if the cookies are set
        if (cookieJar != null && cookieJar.length > 0) {
            try (PrintWriter out = resp.getWriter()) {
                Stream.of(cookieJar).forEach(it -> out.println("Cookie " + it.getName() + " = " + it.getValue()));
            }
        }

        // otherwise I will add the cookies
        // notice as usual...everything is String only.
        // if you want to store a number, you have to convert it.
        else {
            resp.addCookie(new Cookie("Anders-wants", "Cookies"));
            resp.addCookie(new Cookie("Another", "cookie"));
            try (PrintWriter out = resp.getWriter()) {
                out.println("Setting cookies");
            }
        }
    }
}
