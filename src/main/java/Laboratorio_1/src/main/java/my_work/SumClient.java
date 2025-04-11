package Laboratorio_1.src.main.java.my_work;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

class SumClient {
    public static void main(String[] args) throws Exception{
        String sentence;
        String modSentence;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", 6789);

        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        /* Initialize input stream from the socket */
        BufferedReader inFromServer =
                new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

        sentence = inFromUser.readLine();

        /* Send the line to the server*/
        outToServer.writeBytes(sentence + '\n');

        modSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modSentence);

        /* Close the socket */
        clientSocket.close();
    }
}
