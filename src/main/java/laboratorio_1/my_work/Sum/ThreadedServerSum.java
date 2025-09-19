package laboratorio_1.src.main.java.my_work.Sum;

import java.net.*;

public class ThreadedServerSum {
    public static void main(String[] args) throws Exception{
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            SumThread theThread = new SumThread(connectionSocket);
            theThread.start();
        }
    }
}

