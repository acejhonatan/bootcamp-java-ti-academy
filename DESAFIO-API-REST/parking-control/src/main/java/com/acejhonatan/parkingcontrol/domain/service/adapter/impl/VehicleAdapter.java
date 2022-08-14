package com.acejhonatan.parkingcontrol.domain.service.adapter.impl;

import com.acejhonatan.parkingcontrol.api.dto.vehicle.VehicleDtoRequest;
import com.acejhonatan.parkingcontrol.api.dto.vehicle.VehicleDtoResponse;
import com.acejhonatan.parkingcontrol.domain.persistence.entity.Vehicle;
import com.acejhonatan.parkingcontrol.domain.service.OwnerService;
import com.acejhonatan.parkingcontrol.domain.service.adapter.Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleAdapter implements Adapter<VehicleDtoRequest, VehicleDtoResponse, Vehicle> {

    @Autowired
    private OwnerAdapter ownerAdapter;

    @Autowired
    private OwnerService ownerService;

    @Override
    public VehicleDtoResponse fromEntity(Vehicle vehicle) {
        return new VehicleDtoResponse(
                vehicle.getId(),
                vehicle.getLicensePlate(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getColor(),
                ownerAdapter.fromEntity(vehicle.getOwner())
        );
    }

    @Override
    public Vehicle fromDtoRequest(VehicleDtoRequest dtoRequest) {
        return new Vehicle(
                dtoRequest.getLicensePlate(),
                dtoRequest.getBrand(),
                dtoRequest.getModel(),
                dtoRequest.getColor(),
                ownerService.getById(dtoRequest.getOwnerId())
        );
    }
}
