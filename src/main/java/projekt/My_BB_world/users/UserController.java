package projekt.My_BB_world.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    private final UserService userService;
@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user){
    userService.addUser(user);
    return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/users")
    List<User> getAllUsers(){
    return userService.showUsers();
    }
    @GetMapping("/view/{id}")
    User getOneUser(@PathVariable Long id){
    return userService.getUser(id);
    }
    @PutMapping("/user/{id}")
    User updateUser(@PathVariable Long id,@RequestBody User user){
    return userService.updateUser(id,user);
    }
    @DeleteMapping("/user/{id}")
    User removeUser(@PathVariable Long id){
    return userService.deleteUser(id);
    }
}
