package com.cars.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.api.dto.CarsDTO;
import com.cars.api.models.Car;
import com.cars.api.repository.CarRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/car")
public class CarsController {

    @Autowired
    private CarRepository repository;

    @PostMapping
    public void postCar(@RequestBody @Valid CarsDTO req){
        repository.save(new Car(req));
    }

    @GetMapping
    public List<Car> getCars(){
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void updateCar(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void deleteCar(@PathVariable Long id, @RequestBody @Valid CarsDTO req){
        repository.findById(id).map(car -> {
            car.setAnoModelo(req.anoModelo());
            car.setDataFabricacao(req.dataFabricacao());
            car.setFabricante(req.fabricante());
            car.setModelo(req.modelo());
            return repository.save(car);
        });
    }

}
