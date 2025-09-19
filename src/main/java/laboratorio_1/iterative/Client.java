package laboratorio_1.src.main.java.iterative;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        String sentence;
        String modifiedSentence;

        //Inizializza lo stream di input (tastiera dell'utente)
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        //Inizializzazione della socket del client con indirizzo IP e numero porta del servizio del server
        Socket clientSocket = new Socket("localhost", 6789);

        //Inizializza lo stream di output verso la socket
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        //Inizializza lo stream di input dalla socket
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //Legge una linea di input
        sentence = inFromUser.readLine();

        //Invia la linea al server
        outToServer.writeBytes(sentence + '\n');

        //Legge la risposta dal server
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);

        //Chiude la socket
        clientSocket.close();
    }
}
