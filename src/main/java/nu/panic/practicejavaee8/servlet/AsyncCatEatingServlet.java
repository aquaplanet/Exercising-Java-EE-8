package nu.panic.practicejavaee8.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

@WebServlet(value = "/asyncCatEater", asyncSupported = true)
public class AsyncCatEatingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext ac = req.getAsyncContext();
        ac.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                try (PrintWriter w = asyncEvent.getSuppliedResponse().getWriter()) {
                    w.println("Cat has now eaten enough, what can I do for you?");
                }

            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {

            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {

            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {

            }
        }, req, resp);


        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);
        executor.execute(new CatIsEatingService(ac));
    }

    private class CatIsEatingService implements Runnable {
        final AsyncContext ac;
        public CatIsEatingService(AsyncContext ac) {
            this.ac = ac;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ac.complete();
        }
    }
}
