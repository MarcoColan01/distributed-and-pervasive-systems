package laboratorio_1.src.main.java.iterative;

import java.io.*;
import java.net.*;


public class IterativeServer {
    public static void main(String[] args) throws Exception{
        String clientSentence;
        String capitalizedSentence;

        //Crea una socket in ascolto sulla porta specificata
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true){
            //Quando arriva una nuova connessione, una nuova socket stabilita viene creata
            Socket connectionSocket = welcomeSocket.accept();

            //Inizializza lo stream di input dalla socket
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            //Inizializza lo stream di output verso la socket
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            //Legge una linea di input dal client
            clientSentence = inFromClient.readLine();
            System.out.println("RICEVUTO: " + clientSentence + " DAL CLIENT");

            //Simula un tempo di elaborazione di 10 secondi
            //Thread.sleep(10000);

            //Costruisce la rispsota
            capitalizedSentence = clientSentence.toUpperCase() + '\n';

            //Invia la risposta al client
            outToClient.writeBytes(capitalizedSentence);

            //Chiude la socket
            connectionSocket.close();
        }

    }
}
