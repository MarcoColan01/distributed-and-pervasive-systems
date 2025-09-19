package laboratorio_2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class Client{
    public static void main(String[] args) throws Exception{
        Socket clientSocket = new Socket("localhost", 6789);
        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("CLIENT: socket fatta");
        List<Address> residences = new ArrayList<>();
        residences.add(new Address("Via pascarella 21, Milano"));
        residences.add(new Address("Viale zara 45, Milano"));

        List<Exam> examsPassed = new ArrayList<>();
        examsPassed.add(new Exam("Statistica", 25, "04/07/2024"));
        examsPassed.add(new Exam("Programmazione", 30, "23/06/2024"));
        examsPassed.add(new Exam("Logica", 21, "10/09/2024"));

        Student student = new Student ("Ayeye", "Brazorf", 1968, residences, examsPassed);
        Gson jsonObject = new Gson();
        String sentence = jsonObject.toJson(student);
        System.out.println("CLIENT: Json fatto");

        outToServer.writeBytes(sentence + '\n');
        System.out.println("CLIENT: inviato a server");
        String response = inFromServer.readLine();
        System.out.println("FROM SERVER: " + response);

        clientSocket.close();
    }

}
