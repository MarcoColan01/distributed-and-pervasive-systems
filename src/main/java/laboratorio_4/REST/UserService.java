package REST;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service //Spring automatically makes this class a singleton bean
public class UserService {

    private final List<User> usersList = new ArrayList<>();

    public synchronized List<User> getUsersList() {
        return new ArrayList<>(usersList);
    }

    public synchronized void setUsersList(List<User> users) {
        usersList.clear();
        usersList.addAll(users);
    }

    public synchronized void add(User user) {
        usersList.add(user);
    }

    public synchronized User getByName(String name) {
        System.out.println("called");
        for (User user : usersList) {
            System.out.println(user.getName());
            System.out.println(name);
            if (user.getName() != null && user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null; // Not found
    }
}
