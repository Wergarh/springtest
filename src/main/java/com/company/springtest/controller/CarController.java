package com.company.springtest.controller;

import com.company.springtest.model.Car;
import com.company.springtest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(path = "/car")
    public ResponseEntity<List<Car>> getAll() {
        return new ResponseEntity<>(carService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/car/{id}")
    public ResponseEntity<Car> findById(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(carService.findById(id).orElse(null), HttpStatus.OK);
    }
}
