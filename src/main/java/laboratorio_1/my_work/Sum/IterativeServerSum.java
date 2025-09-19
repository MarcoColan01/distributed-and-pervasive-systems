package laboratorio_1.src.main.java.my_work.Sum;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class IterativeServerSum {

    public static void main(String[] args) throws Exception{
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            clientSentence = inFromClient.readLine();
            System.out.println("RICEVUTO: " + clientSentence + " DAL CLIENT");
            String[] app = clientSentence.split(" ");
            int n1 = Integer.parseInt(app[0]);
            int n2 = Integer.parseInt(app[1]);
            capitalizedSentence = String.valueOf(n1+n2) + '\n';
            outToClient.writeBytes(capitalizedSentence);

            connectionSocket.close();
        }
    }
}
