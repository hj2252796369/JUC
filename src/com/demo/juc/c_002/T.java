package com.demo.juc.c_002;

import com.sun.xml.internal.bind.v2.model.runtime.RuntimeBuiltinLeafInfo;

/**
 * @author by        hujie
 * @class_name T
 * @description
 *          synchronized 关键字
 *          对对象进行加锁
 *
 *          synchronized 可重入  也必须是可重入的
 * @create_date 20:48 2020-06-07
 */
public class T implements Runnable {
    private int count = 10;

    @Override
    public synchronized void run() {
        count --;
        System.out.println(Thread.currentThread().getName()+" count = " + count);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            T t= new T();
            new Thread(t, "THREAD" +i).start();
        }
    }



}
