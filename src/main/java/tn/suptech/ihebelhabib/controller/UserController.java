package tn.suptech.ihebelhabib.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.domain.User;
import tn.suptech.ihebelhabib.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping(path="/add")
    public User createUser(@RequestBody User user){
        logger.info("ajout un utilisateur");
        return userService.add(user);
    }

    @PutMapping(path = "/update")
    public  User updateUser(@RequestBody User user){
        logger.info("mis à jour un utilisateur");
        return  userService.update(user);
    }

    @DeleteMapping(path="/delete/{id}")
    public  User deleteUser(@PathVariable Long id){
        logger.info("supprimer un utilisateur");
        return  userService.delete(id);
    }

    @GetMapping(path="/user/{id}")
    public  User getUser(@PathVariable Long id){
        logger.info("obtenir un utilisateur");
        return  userService.getOne(id);
    }

    @GetMapping(path="/")
    public List<User> getAllUser(){
        logger.info("obtenir les utilisateur");
        return  userService.getAll();
    }


}
