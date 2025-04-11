package Laboratorio_1.src.main.java.my_work;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SumThreadedServer extends Thread {
    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    // the constructor argument is an established socket
    public SumThreadedServer(Socket s) {
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
        String[] clientSentence;
        String sumSentence;
        try {
            /* Read a line (ending with '\n') from the client */
            clientSentence = inFromClient.readLine().split(" ");
            //if (clientSentence[0].isEmpty() || clientSentence[1].isEmpty()) throw new IllegalArgumentException("No empty input");
            int n1 = 0;
            int n2 = 0;
            try{
                n1 = Integer.parseInt(clientSentence[0]);
                n2 = Integer.parseInt(clientSentence[1]);
            }catch (NumberFormatException e){
                e.printStackTrace();
            }


            /* simulate a processing time of 10 seconds*/
            Thread.sleep(10000);
            /* Build the response */
            sumSentence = String.valueOf(n1 + n2) + '\n';

            /* Send the response to the client */
            outToClient.writeBytes(sumSentence);

            /* Close the connection socket */
            connectionSocket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            SumThreadedServer sumThread = new SumThreadedServer(connectionSocket);
            sumThread.start();
        }
    }

}
