package com.company;

public class MyRunnable implements Runnable {
    private Thread threadToBeCreated;
    private String nameOfThread;

    public static void main(String args[]) {
        //Creating 10 threads so that context switching can be seen fully ...
        System.out.println("There are "+Thread.activeCount()+ " threads ");
        for (int i = 0; i < 10; i++) {
            MyRunnable R1 = new MyRunnable("Thread: " + i );
            R1.start(); // Kicks off start() which eventually reached run()
            System.out.println("There are "+Thread.activeCount()+ " threads ");

        }
//        MyRunnable R2 = new MyRunnable( "Second Thread-2");
//        R2.start();
    }

    // Constructor so that name of thread can be assigned to each one

    MyRunnable(String name) {
        nameOfThread = name;
        System.out.println("Creating " + nameOfThread + " :ID : " + Thread.currentThread().getId());
    }

    // run() overriding method from Runnable interface
    public void run() {
        System.out.println("Running " + nameOfThread);

        try {
            for (int i = 0; i < 10; i++) {

                System.out.println("Thread currently in Context: " + nameOfThread
                        + " : ID : " + Thread.currentThread().getId());
                // Set the thread sleep to see a context switch.
                Thread.sleep(500); //.5 of a second sleep interval
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + nameOfThread + ": ID :"
                    + Thread.currentThread().getId() + " interrupted.");

        }
        System.out.println("Thread " + nameOfThread + ": ID :"
                + Thread.currentThread().getId() + " finishing ...");
    }

    // start() which corresponds to Thread class start()
    public void start() {
        System.out.println("Starting " + nameOfThread + ": ID :"
                + Thread.currentThread().getId());
        // If the thread isn't already created, create it!!
        if (threadToBeCreated == null) {
            threadToBeCreated = new Thread(this, nameOfThread);
            threadToBeCreated.start();
        }
    }
}// End of class
