package com.javarush.task.task25.task2506;

/**
 * Created by Alexander on 06.02.2018.
 */
public class LoggingStateThread extends Thread {
    Thread thread;
    State state;
    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        state= thread.getState();
    }

    @Override
    public void run() {
        //super.run();

        System.out.println(state);
        while (true) {
            State newState = thread.getState();
            if (state!=newState) {
                System.out.println(newState);
                state=newState;
            }
            if (state==State.TERMINATED)
                break;
        }
    }
}
