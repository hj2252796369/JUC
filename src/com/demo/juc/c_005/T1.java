package com.demo.juc.c_005;

import java.util.concurrent.TimeUnit;

/**
 * @author by        hujie
 * @class_name T1
 * @description
 * @create_date 23:02 2020-06-07
 */
public class T1 {
    synchronized void m() {
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new TT().m();
    }
}

class TT extends T1 {
    @Override
    synchronized void m() {
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
