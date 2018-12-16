package com.company.springtest.controller;

import com.company.springtest.model.Car;
import com.company.springtest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(path = "/car")
    public Iterable<Car> getAll() {
        return carService.findAll();
    }

    @RequestMapping(path = "/car/{id}")
    public Optional<Car> findById(@PathVariable(name = "id") Integer id) {
        return carService.findById(id);
    }
}
