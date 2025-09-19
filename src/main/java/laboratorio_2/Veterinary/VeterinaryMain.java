package laboratorio_2.src.main.java.Veterinary;

import java.util.ArrayList;
import java.util.Random;

public class VeterinaryMain {
    public static void main(String[] args) {
        Random r = new Random();
        int r_int;
        Animals animal;
        WaitingRoom wr = new WaitingRoom();
        ArrayList<Thread> threads = new ArrayList<Thread>();

        for(int i = 0; i < 10; i++){
            r_int = r.nextInt(2);
            if(r_int == 0) animal = Animals.DOG;
            else animal = Animals.CAT;
            AnimalThread at = new AnimalThread(animal, r_int, r, wr);
            threads.add(at);
        }

        for(Thread t: threads){
            t.start();
        }
    }
}
