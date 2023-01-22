package com.cars.api.dto;

import jakarta.validation.constraints.NotNull;

public record CarsDTO(
        @NotNull String modelo,
        @NotNull String fabricante,
        @NotNull String dataFabricacao,
        @NotNull Double valor,
        @NotNull Integer anoModelo) {

}
