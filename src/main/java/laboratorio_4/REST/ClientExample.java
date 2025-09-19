package REST;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class ClientExample {

    public static void main(String[] args) {
        RestTemplate client = new RestTemplate();
        String serverAddress = "http://localhost:8080";

        // POST EXAMPLE
        String postPath = "/users/add";
        User user = new User("John", "Cena");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, headers);

        ResponseEntity<Void> postResponse = client.postForEntity(serverAddress + postPath, request, Void.class);
        System.out.println("POST Response: " + postResponse.getStatusCode());

        // GET REQUEST #1 (get all users)
        String getPath = "/users";
        ResponseEntity<User[]> getAllResponse = client.getForEntity(serverAddress + getPath, User[].class);
        System.out.println("GET All Response: " + getAllResponse.getStatusCode());

        User[] users = getAllResponse.getBody();
        if (users != null) {
            System.out.println("Users List:");
            for (User u : users) {
                System.out.println("Name: " + u.getName() + ", Surname: " + u.getSurname());
            }
        }

        // GET REQUEST #2 (get by name)
        String getUserPath = "/users/get/john";
        ResponseEntity<User> userResponse = client.getForEntity(serverAddress + getUserPath, User.class);
        User u = userResponse.getBody();
        if (u != null) {
            System.out.println("Name: " + u.getName() + ", Surname: " + u.getSurname());
        } else {
            System.out.println("User not found.");
        }
    }
}
