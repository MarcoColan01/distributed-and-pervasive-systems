package laboratorio_2.src.main.java.Veterinary;

import java.util.Random;

public class AnimalThread extends Thread{
    private final Animals animal;
    private final int id;
    private final Random rnd;
    private final WaitingRoom wr;

    public AnimalThread(Animals animal, int id, Random rnd, WaitingRoom wr){
        this.animal = animal;
        this.id = id;
        this.rnd = rnd;
        this.wr = wr;
    }

    @Override
    public void run(){
        System.out.println("Animal: " + animal.name() + " " + id + " tries to enter!");
        try{
            wr.enterRoom(animal, id);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        int seconds = rnd.nextInt(10)+1;
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        wr.exitRoom(animal, id);
    }


}
