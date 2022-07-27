package com.acejhonatan.parkingcontrol.api.dto.owner;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OwnerDtoResponse {

    private Long id;
    private String name;
    private String document;
}
