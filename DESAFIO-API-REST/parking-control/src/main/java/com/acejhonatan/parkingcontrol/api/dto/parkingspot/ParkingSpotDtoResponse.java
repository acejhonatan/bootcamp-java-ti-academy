package com.acejhonatan.parkingcontrol.api.dto.parkingspot;

import com.acejhonatan.parkingcontrol.api.dto.apartment.ApartmentDtoResponse;
import com.acejhonatan.parkingcontrol.core.util.GetterUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class ParkingSpotDtoResponse implements GetterUtil<Long>, Serializable {

    private static final long serialVersionUID = -1237863607184043282L;

    private final Long id;
    private final String number;
    private final ApartmentDtoResponse apartment;
}
