package nu.panic.practicejavaee8.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>This Servlet is meant to only receive request through dispatches.
 * Please have a look at {@link IncludeRequestDispatchingServlet} and
 * {@link RequestDispatchingServlet} how this is done.</p>
 *
 * @see IncludeRequestDispatchingServlet
 * @see RequestDispatchingServlet
 */
@WebServlet("/IgetRequestsDispatchedToMe")
public class DispatchRequestsToMe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("WasThisDispatchedToMe", "Hardcoded-YES");
        resp.setStatus(222);
        try (ServletOutputStream os = resp.getOutputStream()) {
            os.println("Got a request dispatched to me");
        }
    }
}
