package com.gant.synchronize;

import com.gant.Money;
import com.gant.synchronize.Consumer;
import com.gant.synchronize.PoolSynchronize;
import com.gant.synchronize.Producer;

/**
 * @author 甘明波
 * @date 2019-08-05
 */
public class Test {
    public static void main(String[] args) {
        PoolSynchronize<Money> poolSynchronize = new PoolSynchronize<>(5);
        Thread p1 = new Producer("生产者一", poolSynchronize);
        Thread c1 = new Consumer("消费者一", poolSynchronize);
        Thread c2 = new Consumer("消费者二", poolSynchronize);
        p1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c1.start();
        c2.start();
    }
}
