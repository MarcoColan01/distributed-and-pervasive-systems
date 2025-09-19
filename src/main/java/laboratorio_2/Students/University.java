package laboratorio_2;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.*;

public class University {
    public static void main(String[] args) throws Exception{
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true){
            Socket clientSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

            System.out.println("SERVER: socket ok");
            String clientSentence = inFromClient.readLine();
            System.out.println("FROM CLIENT: " + clientSentence);
            Gson jsonObject = new Gson();
            Student unmarshalled = jsonObject.fromJson(clientSentence, Student.class);
            System.out.println("FROM CLIENT UNMARSHALLED:");
            System.out.println(unmarshalled.toString());
            //outToClient.writeBytes("OK!!");

            //clientSocket.close();
        }
    }
}
