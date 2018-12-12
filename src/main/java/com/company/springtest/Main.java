package com.company.springtest;

import com.company.springtest.models.Auto;
import com.company.springtest.models.User;
import com.company.springtest.services.UserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        User user = new User("Masha", 28);
        userService.saveUser(user);
        Auto vaz = new Auto("vaz", "green");
        vaz.setUser(user);
        user.addAuto(vaz);
        Auto lamborghini = new Auto("Lamborghini", "yellow");
        lamborghini.setUser(user);
        user.addAuto(lamborghini);
        userService.updateUser(user);
    }
}
