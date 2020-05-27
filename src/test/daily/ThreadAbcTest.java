package test.daily;

import java.util.concurrent.Semaphore;

/**
 * @author liyh2333@163.com
 * @package test.daily
 * @date 2020/4/7 11:05
 */
public class ThreadAbcTest {

    private volatile static int flag = 0;

    public static void main(String[] args) {
        Object o = new Object();
        new Thread(() -> {
            while(true) {
                synchronized (o) {
                    if (flag == 0) {
                        System.out.println(Thread.currentThread().getName());
                        flag = 1;
                        o.notifyAll();
                    } else {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"A").start();
        new Thread(() -> {
            while(true) {
                synchronized (o) {
                    if (flag == 1) {
                        System.out.println(Thread.currentThread().getName());
                        flag = 2;
                        o.notifyAll();
                    } else {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"B").start();
        new Thread(() -> {
            while(true) {
                synchronized (o) {
                    if (flag == 2) {
                        System.out.println(Thread.currentThread().getName());
                        flag = 0;
                        o.notifyAll();
                    } else {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"C").start();
    }

}

