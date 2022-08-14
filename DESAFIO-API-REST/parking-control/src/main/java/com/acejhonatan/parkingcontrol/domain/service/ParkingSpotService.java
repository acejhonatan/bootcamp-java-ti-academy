package com.acejhonatan.parkingcontrol.domain.service;

import com.acejhonatan.parkingcontrol.api.dto.parkingspot.ParkingSpotDtoRequest;
import com.acejhonatan.parkingcontrol.api.dto.parkingspot.ParkingSpotDtoResponse;
import com.acejhonatan.parkingcontrol.domain.persistence.entity.ParkingSpot;
import com.acejhonatan.parkingcontrol.domain.persistence.repository.custom.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Objects;

@Service
public class ParkingSpotService extends CrudService<ParkingSpotDtoRequest, ParkingSpotDtoResponse, ParkingSpot, Long> {

    @Autowired
    private ParkingSpotRepository repository;

    @Override
    protected void updateData(ParkingSpotDtoRequest dtoRequest, ParkingSpot parkingSpot) {
        checkRequest(dtoRequest, parkingSpot);
        parkingSpot.setNumber(dtoRequest.getNumber());
    }

    @Override
    protected void checkRequest(ParkingSpotDtoRequest dtoRequest, ParkingSpot toSave) {
        boolean entityExists = repository.findByNumber(dtoRequest.getNumber())
                .stream()
                .anyMatch(obtained -> !Objects.equals(obtained, toSave));
        if (entityExists) {
            throw new EntityExistsException("A parking spot with this number already exists.");
        }
    }
}
