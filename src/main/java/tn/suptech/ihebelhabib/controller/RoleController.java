package tn.suptech.ihebelhabib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Role;
import tn.suptech.ihebelhabib.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @PostMapping("/add")
    public Role createRole(@RequestBody Role role) {
        return roleService.add(role);
    }

    @GetMapping(path="/role/{id}")
    public Role getRole(@PathVariable Long id){
        return  roleService.getOne(id);
    }


}