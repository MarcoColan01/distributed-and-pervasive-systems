package laboratorio_2.src.main.java.ChatService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyboardThread extends Thread{
    private Queue queue;

    public KeyboardThread(Queue queue){
        this.queue = queue;
    }

    @Override
    public void run(){
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try{
                queue.put(inFromUser.readLine());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
