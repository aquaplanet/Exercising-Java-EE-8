package nu.panic.javaee8.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.*;

@WebServlet(value = "/asyncCatEater", asyncSupported = true)
public class AsyncCatEatingServlet extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Doing async stuff");
        AsyncContext ac = req.startAsync();

        // No don't do anything to the response object that is not in the listener
        //try (PrintWriter w = resp.getWriter()) {
        //    w.println("I can write synchronously");
        //}

        ac.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                try (PrintWriter w = asyncEvent.getSuppliedResponse().getWriter()) {
                    w.println("Cat has now eaten enough, what can I do for you?");
                    logger.info("OnComplete done");
                }

            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                logger.info("Got timeout");
            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {
                logger.info("Got error");
            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                logger.info("Starting async");
            }
        });

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        executor.execute(new CatIsEatingService(ac));
    }

    private class CatIsEatingService implements Runnable {
        final AsyncContext ac;
        public CatIsEatingService(AsyncContext ac) {
            this.ac = ac;
        }

        @Override
        public void run() {
            logger.info("Starting to eat");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("Done eating");
            ac.complete();
        }
    }
}
