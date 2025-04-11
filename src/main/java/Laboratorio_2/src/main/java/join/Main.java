package Laboratorio_2.src.main.java.join;//package join;


import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String arg[]) throws Exception {
        Random r = new Random();
        ArrayList<Thread> threads = new ArrayList<Thread>();
        //Create some threads
        for (int i=0; i<10; i++) {
            MyThread mt = new MyThread(r);
            threads.add(mt);
        }
        System.out.println("All threads have been created.");
        //Start all the threads
        for (Thread t: threads) {
            t.start();
        }
        System.out.println("All threads have been started.");
        System.out.println("Start waiting for all thread to finish...");
        //Wait all the thread to finish
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("...All thread finished!");
    }

}

