package com.frankmoley.school.school.Controller;

import com.frankmoley.school.school.Data.Entity.User;
import com.frankmoley.school.school.Service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;



    @GetMapping
    public List<User> users()
    {return userService.userList();}

    @PostMapping
    public User addUser(User user)
    {return userService.createUser(user);}

}
