package com.driver.services;

import com.driver.models.User;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    public User createUser(String username, String password){
      User obj=new User(username,password);

      userRepository3.save(obj);
      return obj;

    }

    public void deleteUser(int userId){
        userRepository3.deleteById(userId);
    }

    public User updateUser(Integer id, String password){
        User obj=userRepository3.findById(id).orElse(null);
        if(obj==null)
            return null;
        obj.setPassword(password);
        userRepository3.save(obj);
        return obj;
    }
}
