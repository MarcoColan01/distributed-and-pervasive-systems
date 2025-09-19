package laboratorio_1.src.main.java.my_work.Sum;

import laboratorio_1.src.main.java.my_work.Theatre.Reservations;

import java.io.*;
import java.net.*;

public class SumThread extends Thread{
    private Socket connectionSocket = null;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;
    private Reservations reservations;

    public SumThread(Socket s){
        connectionSocket = s;
        try{
            inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
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
            //outToClient.writeBytes(this.reservations.reserveTicket() + '\n');
            connectionSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

