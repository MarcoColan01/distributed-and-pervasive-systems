package Laboratorio_1.src.main.java.multithread;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread {
    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    // the constructor argument is an established socket
    public ServerThread(Socket s) {
        connectionSocket = s;
        try {

            /* Initialize input stream from the socket */
            inFromClient =
                    new BufferedReader(
                            new InputStreamReader(connectionSocket.getInputStream()));

            /* Initialize output stream towards the socket */
            outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String clientSentence;
        String capitalizedSentence;
        try {
            /* Read a line (ending with '\n') from the client */
            clientSentence = inFromClient.readLine();

            /* simulate a processing time of 10 seconds*/
            //Thread.sleep(10000);

            /* Build the response */
            capitalizedSentence = clientSentence.toUpperCase() + '\n';

            /* Send the response to the client */
            outToClient.writeBytes(capitalizedSentence);

            /* Close the connection socket */
            connectionSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
