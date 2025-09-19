package laboratorio_2.src.main.java.ChatService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception{
        Queue queue = new Queue();
        KeyboardThread kt = new KeyboardThread(queue);
        kt.start();

        Socket clientSocket = new Socket("localhost", 6789);
        ToOtherUserThread ous = new ToOtherUserThread(clientSocket, queue);
        ous.start();

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        while(true){
            System.out.println("FROM SERVER: " + inFromServer.readLine());
        }
    }
}
