package com.acejhonatan.parkingcontrol.api.dto.vehicle;

import com.acejhonatan.parkingcontrol.api.dto.owner.OwnerDtoResponse;
import com.acejhonatan.parkingcontrol.core.util.GetterUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class VehicleDtoResponse implements GetterUtil<Long>, Serializable {

    private static final long serialVersionUID = -230873965662221636L;

    private final Long id;
    private final String licensePlate;
    private final String brand;
    private final String model;
    private final String color;
    private final OwnerDtoResponse owner;
}
