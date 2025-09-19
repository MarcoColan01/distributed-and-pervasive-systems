package laboratorio_1.src.main.java.multithread;

import java.io.*;
import java.net.*;


public class MultiServer {
    public static void main(String[] args) throws Exception{
        //Cra una socket in ascolto sulla porta specificata
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true){
            //Quando arriva una nuova connessione, una nuova socket stabilita viene creata
            Socket connectionSocket = welcomeSocket.accept();

            //Creazione del thread passando la socket stabilita come parametro
            ServerThread theThread = new ServerThread(connectionSocket);

            //Inizializza il thread
            theThread.start();
        }
    }
}
