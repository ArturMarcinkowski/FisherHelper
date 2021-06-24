package helper.fisher.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true, length = 60)
    private String username;
    private String password;
    @Column(nullable = false, unique = true)
    private String email;

    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public boolean isAdmin(){
        for(Role role:roles){
            if(role.getName().equals("ROLE_ADMIN")){
                return true;
            }
        }
        return false;
    }


}