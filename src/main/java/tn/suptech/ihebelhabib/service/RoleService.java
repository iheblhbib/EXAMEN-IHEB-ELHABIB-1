package tn.suptech.ihebelhabib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.domain.Role;
import tn.suptech.ihebelhabib.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    public Role getOne(Long id){
        return roleRepository.findById(id).get();
    }

    public Role add(Role role){
        return  roleRepository.save(role);
    }

    public Role update (Role role){
        return  roleRepository.save(role);
    }

    public  Role getRoleByRoleName(String roleName){
        return  roleRepository.findRoleByName(roleName);
    }
}
