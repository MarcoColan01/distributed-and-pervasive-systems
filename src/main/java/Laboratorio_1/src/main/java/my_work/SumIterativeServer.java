package Laboratorio_1.src.main.java.my_work;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SumIterativeServer {
    public static void main(String[] args) throws Exception{
        String[] clientSentence;
        String capitalizedSentence;

        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true){
            Socket connectionSocket = welcomeSocket.accept();

            BufferedReader inFromClient =
                    new BufferedReader(
                            new InputStreamReader(connectionSocket.getInputStream()));

            /* Initialize output stream towards the socket */
            DataOutputStream outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());

            /* Read a line (ending with '\n') from the client */
            clientSentence = inFromClient.readLine().split(" ");

            //Thread.sleep(10000);

            int n1 = Integer.parseInt(clientSentence[0]);
            int n2 = Integer.parseInt(clientSentence[1]);

            String sumSentence = String.valueOf(n1+n2) + '\n';

            outToClient.writeBytes(sumSentence);

            /* Close the connection socket */
            connectionSocket.close();
        }

    }
}
