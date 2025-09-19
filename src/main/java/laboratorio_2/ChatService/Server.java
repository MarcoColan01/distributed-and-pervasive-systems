package laboratorio_2.src.main.java.ChatService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception{
        Queue queue = new Queue();
        KeyboardThread kt = new KeyboardThread(queue);
        kt.start();

        ServerSocket welcomeSocket = new ServerSocket(6789);
        Socket clientSocket = welcomeSocket.accept();

        ToOtherUserThread ous = new ToOtherUserThread(clientSocket, queue);
        ous.start();

        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        while(true){
            System.out.println("FROM CLIENT: " + inFromClient.readLine());
        }
    }
}
