package Laboratorio_1.src.main.java.iterative;

import java.io.*;
import java.net.*;

class Client {
    public static void main(String argv[]) throws Exception {
        String sentence;
        String modifiedSentence;

        /* Initialize input stream (from user keyboard) */
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

		/* client socket initialization
			localhost: server address
			6789: server service port number */
        Socket clientSocket = new Socket("localhost", 6789);

        /* Initialize output stream towards the socket */
        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        /* Initialize input stream from the socket */
        BufferedReader inFromServer =
                new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

        /* Read an input line */
        sentence = inFromUser.readLine();

        /* Send the line to the server*/
        outToServer.writeBytes(sentence + '\n');

        /* Read response from the server (string ending with '\n') */
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);

        /* Close the socket */
        clientSocket.close();
    }
}
