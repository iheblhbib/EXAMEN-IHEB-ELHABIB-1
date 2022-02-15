package tn.suptech.ihebelhabib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.domain.User;
import tn.suptech.ihebelhabib.repository.UserRepository;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getOne(Long id){
        return userRepository.findById(id).get();
    }

    public User add(User user){
        String cryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(cryptedPassword);
        return  userRepository.save(user);
    }

    public User update (User user){
        String cryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(cryptedPassword);
        return  userRepository.save(user);
    }

    public User delete (Long id ){
        User userDeletet=this.getOne(id);
        userRepository.delete(userDeletet);
        return  userDeletet;
    }

    public  User findByUserName(String userName){
        return  userRepository.findByUserame(userName);
    }


}
