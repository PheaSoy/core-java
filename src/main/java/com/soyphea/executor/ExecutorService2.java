package com.soyphea.executor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;


public class ExecutorService2 {

    private static Logger logger = LogManager.getLogger(ExecutorService2.class);

    public static Runnable function(String msg, int second) {

        logger.info("Function Start.");
        try {
            Thread.sleep(second);
        } catch (Exception ex) {
        }

        return () -> logger.info(msg);
    }


    public static void main(String[] args) {
//
//        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<>());
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        logger.info("Lets go ..");
        Runnable runnable1 = function("Task 1", 2000);
        Runnable runnable2 = function("Task 2", 2000);
        Runnable runnable3 = function("Task 3", 2000);

        Runnable runnable4 = function("Task 4", 2000);
        Runnable runnable5 = function("Task 5", 2000);

        executorService.execute(runnable1);
        executorService.execute(runnable2);
        executorService.execute(runnable3);
        executorService.execute(runnable4);

        Future future5 = executorService.submit(runnable5);
        future5.cancel(true);
        logger.info("Is Cancel?" + future5.isCancelled());
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1000, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (Exception ex) { logger.error(ex.getMessage());}


    }
}
