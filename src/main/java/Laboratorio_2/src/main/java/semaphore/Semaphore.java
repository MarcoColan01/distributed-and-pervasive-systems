package Laboratorio_2.src.main.java.semaphore;//Class that implements a semaphore, thanks to wait() and notify()
//If you need to recap what a semaphore is, Google is your best friend.

public class Semaphore {
    private int maxNumber; //Maximum number of threads
    private int threadsIn; //Number of threads in the critical region

    Semaphore(int max) {
        maxNumber = max;
        threadsIn = 0;
    }

    public synchronized void enter() {
        System.out.println("" + threadsIn + " in the critical region...");
        //When we reach the maximum number of threads, new threads need to wait
        while (threadsIn >= maxNumber) {
            try {this.wait();}
            catch(InterruptedException ie) {ie.printStackTrace();}
        }

        threadsIn++;
    }

    public synchronized void exit() {
        threadsIn--;
        //Whena thread exits the critical region, it awakens another thread that is waiting (if there is one)
        this.notify();
    }
}

