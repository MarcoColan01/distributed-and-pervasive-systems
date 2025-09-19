package laboratorio_2.src.main.java.ChatService;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class ToOtherUserThread extends Thread{
    private Socket socket;
    private Queue queue;

    public ToOtherUserThread(Socket socket, Queue queue){
        this.socket = socket;
        this.queue = queue;
    }

    @Override
    public void run(){
        DataOutputStream outToServer = null;
        try{
            outToServer = new DataOutputStream(socket.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }

        String newMessage;
        while(true){
            newMessage = queue.take();
            try{
                outToServer.writeBytes(newMessage + '\n');
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
