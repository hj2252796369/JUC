package com.demo.juc.c_001;

/**
 * @author by        hujie
 * @class_name T
 * @description synchronized 关键字
 * 对对象进行加锁
 * <p>
 * synchronized 可重入  也必须是可重入的
 * @create_date 20:48 2020-06-07
 */
public class T3 {
    private static int count = 10;


    public synchronized void m() { //等同于在方法的代码执行时要synchronized(this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);

    }

    public static void mm() { //访问这个方法的时候不需要上锁
        synchronized (T3.class){   //静态方法加锁
            count--;
        }

    }
}
