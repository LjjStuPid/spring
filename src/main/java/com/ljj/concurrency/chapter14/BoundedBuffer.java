package com.ljj.concurrency.chapter14;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/25 11:16
 */
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {


    protected BoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        doPut(v);
        notifyAll();
    }

    public synchronized V take() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        V v = doTake();
        notifyAll();
        return v;
    }
}
