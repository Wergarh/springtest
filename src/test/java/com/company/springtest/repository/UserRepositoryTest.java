package com.company.springtest.repository;

import com.company.springtest.model.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    private static final int USER_COUNT = 2;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll() {

        User user1 = new User("Alex", 26, null);
        User user2 = new User("Paul", 26, null);

        userRepository.save(user1);
        userRepository.save(user2);

        assertEquals(USER_COUNT, userRepository.findAll().size());
    }

    @Test
    public void findUserById() throws Exception {
        User expectedUser = new User("Alex", 26, null);
        userRepository.save(expectedUser);

        User actualUser = userRepository.findById(expectedUser.getUserId()).orElse(null);

        assertNotNull(actualUser);
        assertEquals(expectedUser.getUserId(), actualUser.getUserId());
    }

    @After
    public void tearDown() throws Exception {
        userRepository.deleteAll();
    }
}