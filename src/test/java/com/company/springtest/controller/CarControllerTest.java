package com.company.springtest.controller;

import com.company.springtest.model.Car;
import com.company.springtest.model.User;
import com.company.springtest.repository.CarRepository;
import com.company.springtest.service.CarService;
import com.company.springtest.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
@AutoConfigureMockMvc
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserService userService;

    @TestConfiguration
    static class CarServiceTestContextConfiguration {
        @Bean
        public CarService employeeService() {
            return new CarService();
        }
    }

    @Before
    public void setUp() {
        User user = new User("Alex", 23, null);
        Car car = new Car("Red", "Ferrari", user);

        when(userService.findById(user.getUserId()).orElse(null))
                .thenReturn(user);

        when(carRepository.findById(car.getCarId()).orElse(null))
                .thenReturn(car);
    }

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(mockMvc);
//        assertNotNull(carService);
    }

    @Test
    public void getAll() throws Exception {

        Car car1 = new Car("Red", "Ferrari", null);
        Car car2 = new Car("Black", "Ferrari", null);

//        when(carService.findAll()).thenReturn(Arrays.asList(car1, car2));

        mockMvc.perform(get("/car"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Mock")));
    }

    @Test
    public void findById() {
    }

    @After
    public void tearDown() throws Exception {
    }
}