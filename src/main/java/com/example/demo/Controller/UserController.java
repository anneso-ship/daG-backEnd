package com.example.demo.Controller;

import com.example.demo.Model.Agent;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;


    //requete création user
    @PostMapping(value = "registration")
    public void addUser(@RequestBody User user){
        System.out.println(user);
        userService.createUser(user);
    }

    //Afficher les utilisateurs
    @GetMapping(value= "get_users_details")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    //requete suppression user
    @DeleteMapping ("user/delete/{name}")
    public void deleteUserByName(@RequestBody String name){
        this.userService.deleteUserByName(name);
    }

    //requete pour retrouver un utilisateur grace a son nom
    @GetMapping("user/findUserWithName/{name}")
    public void getUserByName(@RequestBody String name){
        this.userService.getUserByName(name);
    }

    //requete pour retrouver un utilisateur grace a son prénom
    @GetMapping("user/findUserWithFirstName/{firstName}")
    public void getUserByFirstName(@RequestBody String firstName){
        this.userService.getUserByFirstName(firstName);
    }


}
