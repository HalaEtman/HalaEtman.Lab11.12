package com.company;

public class Priority_task3 implements Runnable {
    Thread TD;
    int CT;
    static boolean SP = false;
    static String C_name;

    Priority_task3(String name){
        TD = new Thread(this, name);
        CT = 0;
        C_name = name;
    }

    public void run(){
        System.out.println(TD.getName() + "starting to operate");
        do {
            CT++;
            if (C_name.compareTo(TD.getName()) != 0) {
                C_name = TD.getName();
                System.out.println(C_name + " is executed");
            }
        }
        while (SP == false && CT < 10_000_000);
        SP = true;
        System.out.println("\n" + TD.getName() + "finished running");


    }

}

class priorityDemo{
    public static void main(String[] args){
        Priority_task3 Pt1 = new Priority_task3("Hight priority thread");
        Priority_task3 Pt2 = new Priority_task3("Thread with low priority");
        Priority_task3 Pt3 = new Priority_task3("Thread #1 with normal priority");
        Priority_task3 Pt4 = new Priority_task3("Thread #2 with normal priority");
        Priority_task3 Pt5 = new Priority_task3("Thread #3 with normal priority");

        Pt1.TD.setPriority(Thread.MAX_PRIORITY);
        Pt2.TD.setPriority(Thread.MIN_PRIORITY);

        Pt1.TD.start();
        Pt2.TD.start();
        Pt3.TD.start();
        Pt4.TD.start();
        Pt5.TD.start();
        try {
            Pt1.TD.join();
            Pt2.TD.join();
            Pt3.TD.join();
            Pt4.TD.join();
            Pt5.TD.join();
        }
        catch (InterruptedException e){System.out.println("The main thread starts running");}

        System.out.println("\nHigh priority thread counted to " + Pt1.CT);
        System.out.println("The low priority thread added to " + Pt2.CT);
        System.out.println("#1 Normal priority thread added to " + Pt3.CT);
        System.out.println("#2 Normal priority thread added to " + Pt4.CT);
        System.out.println("#3 Normal priority thread added to " + Pt5.CT);

    }
}