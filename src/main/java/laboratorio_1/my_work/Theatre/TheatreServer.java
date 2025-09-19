package laboratorio_1.src.main.java.my_work.Theatre;

import laboratorio_1.src.main.java.my_work.Sum.SumThread;

import java.net.ServerSocket;
import java.net.Socket;

public class TheatreServer {
    public static void main(String[] args) throws Exception{
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            SumThread theThread = new SumThread(connectionSocket);
            theThread.start();
        }
    }
}
