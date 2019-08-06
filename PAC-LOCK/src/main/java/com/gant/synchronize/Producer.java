package com.gant.synchronize;

import com.gant.Money;
import com.gant.synchronize.PoolSynchronize;

/**
 * 生产者
 *
 * @author 甘明波
 * @date 2019-08-05
 */
public class Producer extends Thread {
    private PoolSynchronize<Money> pool;

    Producer(String name, PoolSynchronize<Money> pool) {
        super(name);
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            int i = 1;
            for (;;) {
                Thread.sleep(300);
                pool.add(new Money("美元", i++));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
