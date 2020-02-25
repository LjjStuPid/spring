package com.ljj.concurrency.chapter14;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/25 16:04
 */
public class OneShotLatch {

    private class sync extends AbstractQueuedSynchronizer{
        @Override
        protected int tryAcquireShared(int ingored){
            return (getState() == 1)?1:-1;
        }

        @Override
        protected boolean tryReleaseShared(int ingored){
            setState(1);
            return true;
        }
    }
}
