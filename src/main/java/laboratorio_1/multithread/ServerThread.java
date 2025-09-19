package laboratorio_1.src.main.java.multithread;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread{
    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    //Il parametro del costruttore è una socket stabilita
    public ServerThread(Socket s){
        connectionSocket = s;
        try{
            //Inizializza lo stream di input dalla socket
            inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            //Inizializza lo stream di output verso la socket
            outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        String clientSentence;
        String capitalizedSentence;

        try{
            //Legge una linea di input dal client
            clientSentence = inFromClient.readLine();

            //Simula un tempo di elaborazione di 5 secondi
            Thread.sleep(5000);

            //Costruisce la risposta
            capitalizedSentence = clientSentence.toUpperCase() + '\n';

            //Invia la risposta al client
            outToClient.writeBytes(capitalizedSentence);

            //Chiude la socket
            connectionSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
