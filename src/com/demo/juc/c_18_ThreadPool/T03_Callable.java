package com.demo.juc.c_18_ThreadPool;

import java.util.concurrent.*;

/**
 * @program: JUC
 * @ClassName T03_Callable
 * @description:
 * @author: huJie
 * @create: 2020-12-21 21:15
 **/
public class T03_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello Callable";
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(callable);
        System.out.println(future.get());
        service.shutdown();
    }
}
