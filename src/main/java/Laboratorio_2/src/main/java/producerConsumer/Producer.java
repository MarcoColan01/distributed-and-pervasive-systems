package Laboratorio_2.src.main.java.producerConsumer;

public class Producer implements Runnable {

    private final String id;
    private final Queue queue;

    public Producer(String id, Queue q) { this.id = id; queue = q; }

    public void run() {
        while (true) {
            String message = produce();
            System.out.println("Prod. " + id + ": " + message);
            queue.put(message);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int counter = 0;

    public String produce() {
        counter++;
        return "Message number " + counter + " from " + id;
    }

}
