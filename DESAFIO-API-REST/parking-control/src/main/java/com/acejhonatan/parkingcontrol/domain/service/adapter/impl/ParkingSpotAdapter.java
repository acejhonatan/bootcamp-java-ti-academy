package com.acejhonatan.parkingcontrol.domain.service.adapter.impl;

import com.acejhonatan.parkingcontrol.api.dto.parkingspot.ParkingSpotDtoRequest;
import com.acejhonatan.parkingcontrol.api.dto.parkingspot.ParkingSpotDtoResponse;
import com.acejhonatan.parkingcontrol.domain.persistence.entity.ParkingSpot;
import com.acejhonatan.parkingcontrol.domain.service.ApartmentService;
import com.acejhonatan.parkingcontrol.domain.service.adapter.Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotAdapter implements Adapter<ParkingSpotDtoRequest, ParkingSpotDtoResponse, ParkingSpot> {

    @Autowired
    private ApartmentAdapter apartmentAdapter;

    @Autowired
    private ApartmentService apartmentService;

    @Override
    public ParkingSpotDtoResponse fromEntity(ParkingSpot parkingSpot) {
        return new ParkingSpotDtoResponse(
                parkingSpot.getId(),
                parkingSpot.getNumber(),
                apartmentAdapter.fromEntity(parkingSpot.getApartment())
        );
    }

    @Override
    public ParkingSpot fromDtoRequest(ParkingSpotDtoRequest dtoRequest) {
        return new ParkingSpot(
                dtoRequest.getNumber(),
                apartmentService.getById(dtoRequest.getApartmentId())
        );
    }
}
