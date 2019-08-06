package com.gant.synchronize;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 缓冲区
 *
 * @author 甘明波
 * @date 2019-08-05
 */
class PoolSynchronize<T> {
    private final LinkedList<T> list = new LinkedList<>();
    private final Integer max;

    PoolSynchronize(Integer max) {
        this.max = max;
    }

    synchronized void add(T t) throws InterruptedException {
        if (list.size() == max) {
            notifyAll();
            this.wait();
        } else {
            list.addFirst(t);
            System.out.println(Thread.currentThread().getName() + "生产了" + t + "\t当前钱包里有" + list.size());
        }
    }

    synchronized void remove() throws InterruptedException {
        if (list.size() != max) {
            notifyAll();
            this.wait();
        } else {
            T t = list.removeLast();
            System.out.println(Thread.currentThread().getName() + "消费了了" + t + "\t当前钱包里有" + list.size());
        }
    }
}
