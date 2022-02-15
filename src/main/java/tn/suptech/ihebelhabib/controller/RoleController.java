package tn.suptech.ihebelhabib.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.domain.Role;
import tn.suptech.ihebelhabib.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    Logger logger = LoggerFactory.getLogger(RoleController.class);

    @GetMapping("/")
    public List<Role> getAll() {
        logger.info("obtenir les roles");
        return roleService.getAll();
    }

    @PostMapping("/add")
    public Role createRole(@RequestBody Role role) {
        logger.info("ajout un role");
        return roleService.add(role);
    }

    @GetMapping(path="/role/{id}")
    public Role getRole(@PathVariable Long id){
        logger.info("obtenir un role");
        return  roleService.getOne(id);
    }


}