package com.gant.lock;

import com.gant.Money;


/**
 * @author 甘明波
 * @date 2019-08-06
 */
public class Test {
    public static void main(String[] args) {
        PoolLock<Money> pool = new PoolLock<>(5);
        Thread p1 = new Producer("生产者一", pool);
        Thread c1 = new Consumer("消费者一", pool);
        Thread c2 = new Consumer("消费者二", pool);
        p1.start();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c2.start();
        c1.start();
    }
}
