package projekt.My_BB_world.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String userName;
    private String email;
    private String password;
}
