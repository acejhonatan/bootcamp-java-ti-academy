package com.acejhonatan.parkingcontrol.domain.service;

import com.acejhonatan.parkingcontrol.api.dto.vehicle.VehicleDtoRequest;
import com.acejhonatan.parkingcontrol.api.dto.vehicle.VehicleDtoResponse;
import com.acejhonatan.parkingcontrol.domain.persistence.entity.Vehicle;
import com.acejhonatan.parkingcontrol.domain.persistence.repository.custom.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Objects;

@Service
public class VehicleService extends CrudService<VehicleDtoRequest, VehicleDtoResponse, Vehicle, Long> {

    @Autowired
    private VehicleRepository repository;
    @Override
    protected void updateData(VehicleDtoRequest dtoRequest, Vehicle vehicle) {
        checkRequest(dtoRequest, vehicle);
        vehicle.setLicensePlate(dtoRequest.getLicensePlate());
        vehicle.setBrand(dtoRequest.getBrand());
        vehicle.setModel(dtoRequest.getModel());
        vehicle.setColor(dtoRequest.getColor());
    }

    @Override
    protected void checkRequest(VehicleDtoRequest dtoRequest, Vehicle toSave) {
        boolean entityExists = repository.findByLicensePlate(dtoRequest.getLicensePlate())
                .stream()
                .anyMatch(obtained -> !Objects.equals(obtained, toSave));
        if (entityExists) {
            throw new EntityExistsException("A vehicle with this license plate already exists.");
        }
    }
}
