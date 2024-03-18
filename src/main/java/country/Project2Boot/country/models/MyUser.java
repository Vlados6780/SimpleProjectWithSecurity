package country.Project2Boot.country.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "roles")
    private String roles;

}
