package com.demo.juc.c_006;

import java.util.concurrent.TimeUnit;

/**
 * @author by        hujie
 * @class_name T
 * @description
 *  Volatile (每次写都会被线程读到
 *    )
 *      - 保证线程可见性
 *          MEESI
 *          缓存一致性协议
 *      - 禁止指令重排序(CPU)
 *          DCL单例
 *          Double Check Lock
 *          Mgr06.java
 * @create_date 21:11 2020-06-08
 */
public class T {
    volatile boolean running = true;
    void m(){
        System.out.println("m()  start......");
        while (running){

        }
        System.out.println("m()  emd。。。。。");

    }
    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running=false;
    }
}
