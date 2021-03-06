package com.demo.juc.c_001;

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
public class T2 {
    private int count = 10;

    public  synchronized void m(){ //等同于在方法的代码执行时要synchronized(this)

            count --;
            System.out.println(Thread.currentThread().getName()+" count = " + count);

    }

    public void n() { //访问这个方法的时候不需要上锁
        count++;
    }
}
