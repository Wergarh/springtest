package com.company.springtest.repository;

import com.company.springtest.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
    @Override
    List<Car> findAll();
}
