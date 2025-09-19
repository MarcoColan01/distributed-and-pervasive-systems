package laboratorio_2.src.main.java.Veterinary;

public class WaitingRoom {
    private int dogs;
    private int cats;

    public synchronized void enterRoom(Animals animal, int id) throws InterruptedException{
        while(!checkConditions(animal)) wait();
        if(animal.name().equals("DOG")) dogs++;
        else if(animal.name().equals("CAT")) cats ++;

        System.out.println("Animal " + animal.name() + id + " entered! Dogs: " + dogs + ", cats: " + cats);
    }

    public synchronized void exitRoom(Animals animal, int id){
        if(animal.name().equals("DOG")) dogs--;
        else if (animal.name().equals("CAT")) cats--;

        notifyAll();
        System.out.println("Animal " + animal.name() + id + " exited! Dogs: " + dogs + ", cats: " + cats);
    }

    private boolean checkConditions(Animals animal) {
        if(animal.name().equals("CAT"))
            return dogs <= 0 && cats <= 0;
        else {
            if(cats > 0)
                return false;
            else
                return dogs < 3;
        }
    }

}
