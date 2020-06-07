package com.demo.juc.c_000;

/**
 * @author by        hujie
 * @class_name T02_HowToCreateThread
 * @description
 * 如何创建线程：
 *  1、集成Thread
 *  2、实现Runnable
 *  3、通过线程池启动   Executors.newCachedThread
 *
 * @create_date 20:08 2020-06-07
 */
public class T02_HowToCreateThread {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Hello MyThread");
        }
    }

    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println("Hello MyRun");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();

        //Lamdba表达式创建匿名线程
        new Thread(()->{
            System.out.println("Hello  Lambda");
        });
    }
}
