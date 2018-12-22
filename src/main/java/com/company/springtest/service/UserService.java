package com.company.springtest.service;

import com.company.springtest.model.User;
import com.company.springtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository usersDao;

    public UserService() {
    }

    public List<User> findAll() {
        return usersDao.findAll();
    }

    public User findById(Integer id) {
        return usersDao.findById(id).orElse(null);
    }

    public void updateUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }
}

