package com.demo.juc.c_004;

import java.util.concurrent.TimeUnit;

/**
 * @author by        hujie
 * @class_name Account
 * @description
 *
 *  * 面试题：模拟银行账户
 *  * 对业务写方法加锁
 *  * 对业务读方法不加锁
 *  * 这样行不行？
 *  *
 *  * 容易产生脏读问题（dirtyRead）
 *
 *
 * @create_date 22:55 2020-06-07
 */
public class Account {

    String name;
    double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public /**synchronized*/ double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        Account account = new Account();
        new Thread(()->account.set("zhangsan", 100)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance("zhangsan"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getBalance("zhangsan"));
    }

}
