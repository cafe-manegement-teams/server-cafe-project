package com.example.cafeserver.login.service;

import com.example.cafeserver.login.dao.UserRepository;
import com.example.cafeserver.login.model.User;
import org.mindrot.jbcrypt.BCrypt;


//import io.jsonwebtoken.Jwts;

//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import java.security.Key;

import org.springframework.stereotype.*;

import org.springframework.beans.factory.annotation.*;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User test(String input) {
        return userRepository.findUserByUsername(input);
    }

    public String createStaff(User user) {
        User newUser = new User();
        if(isUserExist(user.getUsername()) == false) {
            newUser.setUsername(user.getUsername());
            String hash = hashPassword(user.getPassword());
            newUser.setPassword(hash);
            userRepository.save(newUser);
            return "Saved";
        } else { return "User existed"; }

    }

    public boolean isUserExist (String userName) {
        boolean allOk = false;
        try {
            User userExist = new User();
            userExist = userRepository.findUserByUsername(userName);
            if(userExist != null) {
                allOk = true;
            } else {
                allOk = false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return allOk;
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(8));
    }

    public Boolean validateUser(User user) {
        Boolean validated = false;
        try {
            Boolean isUserExist = isUserExist(user.getUsername( ));
            User userforcheck = new User();
            if (isUserExist == true) {
                userforcheck = userRepository.findUserByUsername(user.getUsername());
                // Compare Password
                Boolean isCorrectPS = BCrypt.checkpw(user.getPassword(), userforcheck.getPassword());
                if (isCorrectPS == true) {
                    validated = true;
//                    message = "Validated with token response :";
                    // Create a token string to response to client
//                    token = Jwts.builder()
//                            .setId(newUser.getId().toString())
//                            .signWith(SECRET_KEY)
//                            .compact();
                } else {
                    validated = false;
//                    message = "Wrong Password";
                }
            } else {
                validated = false;
//                message = "User does not exist";
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return validated;
    }

}






