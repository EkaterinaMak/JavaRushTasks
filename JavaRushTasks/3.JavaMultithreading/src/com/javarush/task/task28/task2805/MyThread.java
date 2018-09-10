package com.javarush.task.task28.task2805;

/**
 * Created by Alexander on 18.04.2018.
 */
public class MyThread extends Thread {
    private static int prioCount = Thread.MIN_PRIORITY;

    private void initPrio() {
        if (this.getThreadGroup()!=null) {
            if (prioCount >= this.getThreadGroup().getMaxPriority()) {
                setPriority(this.getThreadGroup().getMaxPriority());
            } else {
                setPriority(prioCount);
            }
        } else {
            setPriority(prioCount);
        }
        if (prioCount==Thread.MAX_PRIORITY)
            prioCount=Thread.MIN_PRIORITY;
        else
            prioCount++;
    }

    public MyThread() {
        initPrio();
    }

    public MyThread(Runnable target) {
        super(target);
        initPrio();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        initPrio();
    }

    public MyThread(String name) {
        super(name);
        initPrio();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        initPrio();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        initPrio();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        initPrio();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        initPrio();
    }
}
