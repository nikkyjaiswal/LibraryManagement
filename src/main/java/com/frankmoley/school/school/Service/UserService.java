package com.frankmoley.school.school.Service;

import com.frankmoley.school.school.Data.Entity.User;
import com.frankmoley.school.school.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configuration
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user)
    {return userRepository.save(user);}

    public List<User> userList()
    {
        return userRepository.findAll();
    }

}
