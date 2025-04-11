package Laboratorio_1.src.main.java.iterative;

import java.io.*;
import java.net.*;

class IterativeServer {
    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String capitalizedSentence;

        /* Create a "listening socket" on the specified port */
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true) {
            /*
             * Call to accept function (blocking call).
             * When a new connection arrives a new "established socket" is created
             */
            Socket connectionSocket = welcomeSocket.accept();

            /* Initialize input stream from the socket */
            BufferedReader inFromClient =
                    new BufferedReader(
                            new InputStreamReader(connectionSocket.getInputStream()));

            /* Initialize output stream towards the socket */
            DataOutputStream outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());

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
        }
    }
}
