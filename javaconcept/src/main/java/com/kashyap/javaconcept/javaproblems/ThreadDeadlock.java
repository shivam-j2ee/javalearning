package com.kashyap.javaconcept.javaproblems;

public class ThreadDeadlock {
    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Thread t1 = new Thread(new SycThread(obj1, obj2), "t1");
        Thread t2 = new Thread(new SycThread(obj2, obj3), "t2");
        Thread t3 = new Thread(new SycThread(obj3, obj1), "t3");

        t1.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
        t3.start();
    }

}

class SycThread implements Runnable{

    private Object obj1;
    private Object obj2;

    public SycThread(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }


    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " acquiring lock on1 " + obj1);
        synchronized (obj1){
            System.out.println(threadName + " acquired lock on2 " + obj1);
            work();
            System.out.println(threadName + " acquiring lock on3 " + obj2);
            synchronized (obj2) {
                System.out.println(threadName + " acquired lock on4 " + obj2);
                work();
            }
            System.out.println(threadName + " released lock on4 " + obj2);
        }
        System.out.println(threadName + " released lock on6 " + obj1);
        System.out.println(threadName + " finished execution.");
    }

    private void work() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
