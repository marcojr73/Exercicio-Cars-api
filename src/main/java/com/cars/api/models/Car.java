package com.cars.api.models;

import com.cars.api.dto.CarsDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Car {

    public Car(CarsDTO car){
        this.modelo = car.modelo();
        this.fabricante = car.fabricante();
        this.anoModelo = car.anoModelo();
        this.dataFabricacao = car.dataFabricacao();
        this.valor = car.valor();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 200, nullable = false)
    private String modelo;
    
    @Column(length = 200, nullable = false)
    private String fabricante;

    @Column(length = 200, nullable = false)
    private String dataFabricacao;

    @Column(length = 200, nullable = false)
    private Double valor;

    @Column(length = 200, nullable = false)
    private Integer anoModelo;

}
