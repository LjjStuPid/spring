package com.ljj.concurrency.chapter14;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/25 10:14
 */
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    protected SleepyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public void put(V v) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isFull()) {
                    doPut(v);
                    return;
                }
                Thread.sleep(20);
            }
        }
    }

    public V take() throws InterruptedException {
        while (true){
            synchronized (this){
                if(!isEmpty()){
                    return doTake();
                }
                Thread.sleep(20);
            }
        }
    }
}
