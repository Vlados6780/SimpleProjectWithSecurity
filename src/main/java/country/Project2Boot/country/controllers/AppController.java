package country.Project2Boot.country.controllers;


import country.Project2Boot.country.models.Application;
import country.Project2Boot.country.models.MyUser;
import country.Project2Boot.service.AppService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@AllArgsConstructor
public class AppController {

    private AppService appService;

    @GetMapping
    public String welcome(){
        return "Welcome to country SecurityProject!";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/all")
    public List<Application> getApps(){
        return appService.getApps();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable("id") int id){
        return appService.getApplicationById(id);
    }

    @PostMapping("/new-user")
    public String newUser(@RequestBody MyUser user){
        appService.addUser(user);
        return "User is saved";
    }

}
