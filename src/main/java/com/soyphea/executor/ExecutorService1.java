package com.soyphea.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorService1 {

    public static Runnable function(String msg){
        return () -> System.out.println("Thread Name:"+Thread.currentThread().getName()+" Msg:"+msg);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        System.out.println("Start Running....");
        Runnable runnable = function("Task 1");
        Runnable runnable1 =  function("Task 2");
        Runnable runnable2 = function("Task 3");


        executorService.execute(runnable2);
        executorService.execute(runnable1);
        executorService.execute(runnable);

        Future future2 = executorService.submit(runnable2);
        Future future1 = executorService.submit(runnable1);
        Future future = executorService.submit(runnable);

        executorService.shutdown();

    }
}
