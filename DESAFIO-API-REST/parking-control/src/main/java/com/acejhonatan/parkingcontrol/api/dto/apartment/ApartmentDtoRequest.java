package com.acejhonatan.parkingcontrol.api.dto.apartment;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class ApartmentDtoRequest {

    @NotBlank
    @Size(max = 4)
    private String number;

    @NotBlank
    private Long ownerId;
}
