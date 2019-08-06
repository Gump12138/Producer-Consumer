package com.gant.synchronize;

import com.gant.Money;

/**
 * 消费者
 *
 * @author 甘明波
 * @date 2019-08-05
 */
public class Consumer extends Thread {
    private PoolSynchronize<Money> pool;

    Consumer(String name, PoolSynchronize<Money> pool) {
        super(name);
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(300);
                pool.remove();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
