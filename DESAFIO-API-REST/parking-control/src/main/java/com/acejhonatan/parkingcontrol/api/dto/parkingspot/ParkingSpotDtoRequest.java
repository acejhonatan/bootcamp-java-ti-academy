package com.acejhonatan.parkingcontrol.api.dto.parkingspot;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class ParkingSpotDtoRequest {

    @NotBlank
    @Size(max = 10)
    private String number;

    @NotNull
    private Long apartmentId;
}
