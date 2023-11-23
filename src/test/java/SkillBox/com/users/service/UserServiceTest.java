package SkillBox.com.users.service;

import SkillBox.com.users.PostgreSQLInitializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
@SpringBootTest
@ContextConfiguration(initializers = {PostgreSQLInitializer.class})
class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    void createUser() {
    }

    @Test
    void getUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void getUsers() {

    }
}