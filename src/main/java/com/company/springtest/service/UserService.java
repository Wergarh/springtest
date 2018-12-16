package com.company.springtest.service;

import com.company.springtest.repository.UserRepository;
import com.company.springtest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository usersDao;

    public UserService() {
    }

    public Iterable<User> findAll() {
        return usersDao.findAll();
    }

    public Optional<User> findById(Integer id) {
        return usersDao.findById(id);
    }

    public void updateUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }
}

