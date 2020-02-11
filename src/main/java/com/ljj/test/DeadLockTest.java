package com.ljj.test;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2020/2/11 8:55
 */
public class DeadLockTest {


    static class SynAddRunnable implements Runnable {

        int a, b;

        public SynAddRunnable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(b)) {
                synchronized (Integer.valueOf(a)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunnable(1, 2)).start();
            new Thread(new SynAddRunnable(2, 1)).start();
        }
    }
}
