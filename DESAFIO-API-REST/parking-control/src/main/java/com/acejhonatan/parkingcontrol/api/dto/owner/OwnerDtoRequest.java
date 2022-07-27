package com.acejhonatan.parkingcontrol.api.dto.owner;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class OwnerDtoRequest {

    @NotBlank
    @Size(max = 60)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String document;
}
