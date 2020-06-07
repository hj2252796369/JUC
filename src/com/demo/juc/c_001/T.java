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
public class T {
    private int count = 10;
    private Object o = new Object();

    public void m(){
        synchronized (o){
            count --;
            System.out.println(Thread.currentThread().getName()+" count = " + count);
        }
    }

}
