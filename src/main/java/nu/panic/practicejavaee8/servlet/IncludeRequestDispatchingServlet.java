package nu.panic.practicejavaee8.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>You can include the contents from other servlets in your servlet. This is done through
 * getRequestDispatch("/relative-URL-to-servlet").include(req, resp).</p>
 *
 * <p>There are limitations for what the included servlet can do (it can only change the outputstream).</p>
 *
 * <p>Start the Wildfly server (mvn exec:exec) and press this link for a demonstration.</p>
 * <a href="http://localhost:8080/cookies">http://localhost:8080/cookies</a>
 *
 * @see DispatchRequestsToMe
 */
@WebServlet("/IncludeRequestDispatchingServlet")
public class IncludeRequestDispatchingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("IgetRequestsDispatchedToMe").include(req, resp);

        // Note that despite the above dispatch changes the headers,
        // they, the headers, are ignored.
        try (ServletOutputStream os = resp.getOutputStream()) {
            os.println("Even though I sent my request and response somewhere else, ");
            os.println("I can add my of stuff to this response. It is exactly like I ");
            os.println("asked the other Servlet to add its thing and I get the last word.");
            os.println("Note however, the servlets which helps me write the response, ");
            os.println("has no say in headers or anything, it can just change the outputstream in the response.");
        }
    }
}
