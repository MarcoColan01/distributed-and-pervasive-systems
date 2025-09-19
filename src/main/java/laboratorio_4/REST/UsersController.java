package REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired //tells Spring to automatically resolve and inject the required bean (object) into the class where it's used
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    // Return list of users
    @GetMapping
    public ResponseEntity<List<User>> getUsersList() {
        return ResponseEntity.ok(userService.getUsersList());
    }

    // Add a new user
    @PostMapping("/add")
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        userService.add(user);
        return ResponseEntity.ok().build();
    }

    // Get user by name
    @GetMapping("/get/{name}")
    public ResponseEntity<User> getByName(@PathVariable String name) {
        User user = userService.getByName(name);
        System.out.println(name);
        if (user != null)
            return ResponseEntity.ok(user);
        else
            return ResponseEntity.notFound().build();
    }
}





