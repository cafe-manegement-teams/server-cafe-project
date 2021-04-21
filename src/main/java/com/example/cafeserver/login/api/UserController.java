package com.example.cafeserver.login.api;

import com.example.cafeserver.login.dao.UserRepository;
import com.example.cafeserver.login.model.User;
import com.example.cafeserver.login.service.UserService;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/login")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  UserService userService;


    @PostMapping(path= "/add")
    public @ResponseBody String createUser(@RequestBody User user){
        return userService.createStaff(user);
    }

    @GetMapping
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Boolean Login(@RequestBody User user){
                return userService.validateUser(user);
        }

    @GetMapping(path = "/test")
    public @ResponseBody boolean test(@RequestParam String username){
        return userService.isUserExist(username);
    }

}
