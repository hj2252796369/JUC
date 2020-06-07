package com.demo.juc.c_000;

import java.util.concurrent.TimeUnit;

/**
 * @author by        hujie
 * @class_name T01_WhatIsThread
 * @description
 * @create_date 19:59 2020-06-07
 */
public class T01_WhatIsThread {

    private static class T1 extends Thread{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
        //执行T1的网run方法，主线程进去执行，然后执行main线程的方法
        new T1().run();
        //开辟一个新的线程执行方法。，与主线程一起运行
        new T1().start();
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }

    }
}
