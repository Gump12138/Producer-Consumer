package com.gant.lock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 缓冲区
 *
 * @author 甘明波
 * @date 2019-08-05
 */
class PoolLock<T> {
    private final LinkedList<T> list = new LinkedList<>();
    private final Integer max;
    private final Lock lock = new ReentrantLock(true);
    private final Condition producer = lock.newCondition();
    private final Condition consumer = lock.newCondition();

    PoolLock(Integer max) {
        this.max = max;
    }

    void add(T t) throws InterruptedException {
        lock.lock();
        if (list.size() == max) {
            consumer.signal();
            producer.await();
        } else {
            list.addFirst(t);
            System.out.println(Thread.currentThread().getName() + "生产了" + t + "\t当前钱包里有：" + list.size());
        }
        lock.unlock();
    }

    void remove() throws InterruptedException {
        lock.lock();
        if (list.size() != max) {
            producer.signal();
            consumer.await();
        } else {
            T t = list.removeLast();
            System.out.println(Thread.currentThread().getName() + "消费了" + t + "\t当前钱包里有：" + list.size());
        }
        lock.unlock();
    }
}
