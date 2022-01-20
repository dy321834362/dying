package com.dai;

public class 多线程1 {
    static volatile int count = 1;
    static volatile boolean b = true;
    static Object o1 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (count <= 100) {
                synchronized (o1) {
                    if(b) {
                        System.out.println(Thread.currentThread() + "---"+ count++);
                        b = false;
                    } else {
                        o1.notifyAll();
                        try {
                            o1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (count <= 100) {
                synchronized (o1) {
                    if(!b) {
                        System.out.println(Thread.currentThread() + "---"+ count++);
                        b = true;
                    } else {
                        o1.notifyAll();
                        try {
                            o1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        });
        t1.start();
        t2.start();
    }


}

