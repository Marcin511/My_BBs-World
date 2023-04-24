package projekt.My_BB_world.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserRepository userRepository;
@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    User addUser(User user){
    return userRepository.save(user);
    }
    List<User> showUsers(){
    return userRepository.findAll();
    }
    User getUser(Long id){
    User user = userRepository.findUserById(id).orElseThrow(()-> new NoSuchElementException("User isn't exist"));
    return user;
    }
    User deleteUser(Long id){
    User user = userRepository.findUserById(id).orElseThrow(()->new NoSuchElementException("User isn't exist"));
    userRepository.deleteById(id);
    return user;
    }
    User updateUser(Long id, @RequestBody User userToUpdate){
    return userRepository.findUserById(id).map(user -> {user.setUserName(userToUpdate.getUserName());
    user.setEmail(userToUpdate.getEmail());
    user.setPassword(userToUpdate.getPassword());
    return userRepository.save(user);}).orElseThrow(()-> new NoSuchElementException("User isn't exist"));
    }
}
