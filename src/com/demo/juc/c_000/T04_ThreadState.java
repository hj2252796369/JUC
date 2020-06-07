package com.demo.juc.c_000;

/**
 * @author by        hujie
 * @class_name T04_ThreadState
 * @description
 *  1。new   创建
 *  2、Runnable  运行
 *         ready
 *         Running
 *   3。Teminated    运行完成
 *   4、TimedWaiting  按照时间等待
 *   5、Wait 等待
 *   6、Blocked  阻塞
 * @create_date 20:20 2020-06-07
 */
public class T04_ThreadState {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getState());

            for(int i=0; i<10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();

        System.out.println(t.getState());

        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getState());

    }
}
