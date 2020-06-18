package com.soyphea.future;

import java.util.List;
import java.util.concurrent.*;

import com.soyphea.java8.exeption.FruitNotFoundException;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Future1 {

    private static Logger logger = LogManager.getLogger(Future1.class);
    static List<String> fruits = List.of("Apple", "Orange", "Coconut");

    @Setter
    @Getter
    static class MyFruitResource implements Callable {

        private String fruit;

        @Override
        public String call() throws Exception {
            logger.info("Got request with fruit:{}",this.getFruit());
            TimeUnit.SECONDS.sleep(2);
            String fruit =  fruits.stream().filter(f -> f.equals(this.getFruit())).findFirst().orElseThrow(() -> new FruitNotFoundException());
            logger.info("Posting completed");
            return fruit;

        }
    }

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyFruitResource myFruitResource  = new MyFruitResource();

        myFruitResource.setFruit("Apple");
        Future futureApple = executorService.submit(myFruitResource);
        //logger.info("Got :{}",futureApple.get()); // This will block below process to making the call

        myFruitResource.setFruit("Coconut");
        Future futureCoconut = executorService.submit(myFruitResource);

        Callable callableLambda = () ->  "Hello world";
        Future future = executorService.submit(callableLambda);
        logger.info("OK :{}",future.get());
        executorService.shutdown();


    }
}
