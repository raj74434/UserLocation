package com.userLocation.ambula.repositories;

import com.userLocation.ambula.models.User;
import com.userLocation.ambula.services.User_type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserRepoTest {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private User user;

    @BeforeEach
    @Test
    void findByName() {

        User result_user=new User("Raj","12345");

        user.setUser_type(User_type.ADMIN);
        user.setName("Raj2");
        user.setPassword("12345");
        userRepo.save(user);
        User result=userRepo.findByName(user.getName());
        assertThat(result_user.getPassword()).isEqualTo(user.getPassword());
    }
}