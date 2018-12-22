package com.company.springtest.controller;

import com.company.springtest.model.Car;
import com.company.springtest.model.User;
import com.company.springtest.service.CarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
@AutoConfigureMockMvc
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    private User user1;
    private Car car1;
    private Car car2;

    @Before
    public void setUp() throws Exception {

        user1 = new User("Alex", 23, null);

        car1 = new Car("Red", "Ferrari", user1);
        car2 = new Car("Blue", "BMV", user1);

        List<Car> carList = Arrays.asList(car1, car2);

        given(carService.findAll()).willReturn(carList);
        given(carService.findById(car1.getCarId())).willReturn(Optional.of(car1));
    }

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/car")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void findById() throws Exception {
        mockMvc.perform(get("/car/" + car1.getCarId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.carId", is(car1.getCarId())));
    }
}