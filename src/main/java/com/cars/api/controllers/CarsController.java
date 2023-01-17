package com.cars.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.api.dto.CarsDTO;
import com.cars.api.models.Car;
import com.cars.api.repository.CarRepository;


@RestController
@RequestMapping("/car")
public class CarsController {

    @Autowired
    private CarRepository repository;

    @PostMapping
    public void postCar(@RequestBody CarsDTO req){
        System.out.println(req);
        repository.save(new Car(req));
    }

    @GetMapping
    public List<Car> getCars(){
        return repository.findAll();
    }
}
