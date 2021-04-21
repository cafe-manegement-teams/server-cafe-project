package com.example.cafeserver.login.dao;

import com.example.cafeserver.login.model.User;
import org.springframework.data.jpa.repository.*;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
    User findUserById(Integer id);
}

