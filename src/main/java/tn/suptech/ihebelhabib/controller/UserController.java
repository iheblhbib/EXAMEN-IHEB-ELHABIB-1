package tn.suptech.ihebelhabib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.User;
import tn.suptech.ihebelhabib.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/add")
    public User createUser(@RequestBody User user){
        return userService.add(user);
    }

    @PutMapping(path = "/update")
    public  User updateUser(@RequestBody User user){
        return  userService.update(user);
    }

    @DeleteMapping(path="/delete/{id}")
    public  User deleteUser(@PathVariable Long id){
        return  userService.delete(id);
    }

    @GetMapping(path="/user/{id}")
    public  User getUser(@PathVariable Long id){
        return  userService.getOne(id);
    }

    @GetMapping(path="/")
    public List<User> getAllUser(){

        return  userService.getAll();
    }


}
