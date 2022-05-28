package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("the main thread is starting to run");

        myThreads Mt1 = myThreads.createAndStart("child thread 1");
        myThreads Mt2 = myThreads.createAndStart("child thread 2");
        myThreads Mt3 = myThreads.createAndStart("child thread 3");
        try {
            Mt1.Thread_Name.join();
            Mt2.Thread_Name.join();
            Mt3.Thread_Name.join();

        }
        catch (InterruptedException Ie){
            Ie.printStackTrace();
            System.out.println("The main thread is exiting");
        }
        System.out.println("The main thread is exiting");
    }
}

class myThreads implements Runnable{

    Thread Thread_Name;

    myThreads(String name) {
        Thread_Name = new Thread(this, name);
    }

    public static myThreads createAndStart(String name){
        myThreads mt = new myThreads(name);
        mt.Thread_Name.start();
        return mt;
    }

    public void run(){
        System.out.println(Thread_Name.getName() + "starts operating");
        try {
            for (int C = 0; C < 10; C++){
                Thread.sleep(100);
                System.out.println(Thread_Name.getName() + "is executed, the value of the counter is: "+ C);
            }
        }
        catch (InterruptedException IE){
            System.out.println(Thread_Name.getName() + "System has been interrupted");
        }
        System.out.println(Thread_Name.getName() + "finished running");
    }
}
