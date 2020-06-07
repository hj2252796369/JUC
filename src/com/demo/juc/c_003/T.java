package com.demo.juc.c_003;

/**
 * @author by        hujie
 * @class_name T
 * @description
 *  同步方法和非同步方法能否同时调用
 * @create_date 22:49 2020-06-07
 */
public class T  {
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + " m1 start././././././ ");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1  end......... ");
    }

    public void m2(){
        System.out.println(Thread.currentThread().getName() +"m2 start。。。。。。。。。。。。。。。。");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 end");
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m1, "t1").start();
        new Thread(t::m2, "t2").start();
    }
}
