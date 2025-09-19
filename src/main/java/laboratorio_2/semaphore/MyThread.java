package laboratorio_2.src.main.java.semaphore;

import java.util.Random;

public class MyThread extends Thread {
    private final Random rnd;
    private final int id;
    private final Semaphore sem;

    MyThread(Random r, int i, Semaphore s) {
        rnd = r;
        id = i;
        sem=s;
    }

    public void run() {
        wasteSomeTime(); //Simulate the thread is doing something else
        System.out.println("Thread " + id + " wants to enter in the critical region");
        sem.enter();
        System.out.println("Thread " + id + " entered in the critical region!");
        wasteSomeTime(); //It takes some times to compleate the work in the critical region
        System.out.println("Thread " + id + " is going to get out from the critical region");
        sem.exit();
    }//end run

    private void wasteSomeTime() {
        int seconds = rnd.nextInt(10) + 1;
        try {Thread.sleep(seconds*1000);}
        catch(Exception ex) {ex.printStackTrace();}
    }
} //end class

