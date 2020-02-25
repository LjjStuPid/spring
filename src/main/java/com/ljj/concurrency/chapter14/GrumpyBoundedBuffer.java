package com.ljj.concurrency.chapter14;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/25 9:46
 */
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    protected GrumpyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) {
        if (isFull()) {
            throw new RuntimeException();
        }
        doPut(v);
    }

    public synchronized V take() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return doTake();
    }
}
