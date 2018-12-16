package com.company.springtest.repository;

import com.company.springtest.model.Car;
import com.company.springtest.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarRepositoryTest {

    private final static int CAR3_ID = 3;
    private final static int CAR_COUNT = 2;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarRepository carRepository;

    private User user1;
    private Car car1;
    private Car car2;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(carRepository);
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAllCars() throws Exception {

        user1 = new User("Alex", 36, null);
        userRepository.save(user1);

        car1 = new Car("Red", "Ferrari", user1);
        car2 = new Car("Black", "Lamborgini", user1);

        carRepository.save(car1);
        carRepository.save(car2);

        Assert.assertEquals(CAR_COUNT, carRepository.findAll().size());
    }

    @Test
    public void getCarById_success() throws Exception {

        user1 = new User("Alex", 36, null);
        userRepository.save(user1);

        Car expectedCar = new Car("Red", "Ferrari", user1);
        carRepository.save(expectedCar);

        Car actualCar = carRepository.findById(expectedCar.getCarId()).orElse(null);

        assertEquals(expectedCar.getCarId(), actualCar.getCarId());
    }

    @Test
    public void getCarById_failure() throws Exception {
        assertNull(carRepository.findById(CAR3_ID).orElse(null));
    }

    @After
    public void tearDown() throws Exception {
        carRepository.deleteAll();
        userRepository.deleteAll();
    }
}