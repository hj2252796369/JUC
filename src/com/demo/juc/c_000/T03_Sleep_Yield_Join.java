package com.demo.juc.c_000;

/**
 * @author by        hujie
 * @class_name T03_Sleep_Yield_Join
 * @description
 * @create_date 20:15 2020-06-07
 */
public class T03_Sleep_Yield_Join {

    //yield()  当前执行的线程释放CPU，进行等待队列中
    static void testYield(){
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                if(i%10 == 0) Thread.yield();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("B" + i);
                if(i%10 == 0) Thread.yield();
            }
        }).start();
    }


    //sleep()  线程睡眠
    //join()  调用线程其他线程.join(), 把其他线程加入自己线程中，直至其他线程运行完毕再运行
    static void testJoin(){
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{

                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        });
    }
}
