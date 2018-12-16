package com.company.springtest;

import com.company.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
//        User user = new User("Masha", 28);
//        userService.saveUser(user);
//        Car vaz = new Car("vaz", "green");
//        vaz.setUser(user);
//        user.addAuto(vaz);
//        Car lamborghini = new Car("Lamborghini", "yellow");
//        lamborghini.setUser(user);
//        user.addAuto(lamborghini);
//        userService.updateUser(user);
    }
}
