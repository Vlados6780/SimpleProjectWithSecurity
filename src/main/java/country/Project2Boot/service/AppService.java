package country.Project2Boot.service;

import country.Project2Boot.country.models.Application;
import country.Project2Boot.country.models.MyUser;
import country.Project2Boot.country.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class AppService {

    @Getter
    private List<Application> apps;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void loadAppInDb(){
     apps = List.of(
             Application.builder().
                     id(1).
                     name("Project2Boot").
                     author("Som").
                     version("1.0.0").
                     build(),
             Application.builder().
                     id(2).
                     name("Project").
                     author("Some").
                     version("2.0.0").
                     build()
     );

    }

    public Application getApplicationById(int id){
        return apps.stream().filter(app -> app.getId() == id).findFirst().orElse(null);
    }

    public void addUser(MyUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }



}
