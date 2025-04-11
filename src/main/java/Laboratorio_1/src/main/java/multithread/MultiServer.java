package Laboratorio_1.src.main.java.multithread;

import java.io.*;
import java.net.*;

class MultiServer {
    public static void main(String argv[]) throws Exception {

        /* Create a "listening socket" on the specified port */
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true) {
            /*
             * Call to accept function (blocking call).
             * When a new connection arrives a new "established socket" is created
             */
            Socket connectionSocket = welcomeSocket.accept();

            /* Thread creation passing the established socket as argument */
            ServerThread theThread =
                    new ServerThread(connectionSocket);

            /* Start the thread*/
            theThread.start();
        }
    }
}
