package com.acejhonatan.parkingcontrol.api.dto.vehicle;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class VehicleDtoRequest {

    @NotBlank
    @Size(max = 7)
    private String licensePlate;

    @NotBlank
    @Size(max = 40)
    private String brand;

    @NotBlank
    @Size(max = 40)
    private String model;

    @NotBlank
    @Size(max = 40)
    private String color;

    @NotNull
    private Long ownerId;
}
