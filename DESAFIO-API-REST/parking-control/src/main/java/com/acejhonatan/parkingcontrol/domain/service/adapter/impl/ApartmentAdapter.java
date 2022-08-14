package com.acejhonatan.parkingcontrol.domain.service.adapter.impl;

import com.acejhonatan.parkingcontrol.api.dto.apartment.ApartmentDtoRequest;
import com.acejhonatan.parkingcontrol.api.dto.apartment.ApartmentDtoResponse;
import com.acejhonatan.parkingcontrol.domain.persistence.entity.Apartment;
import com.acejhonatan.parkingcontrol.domain.service.OwnerService;
import com.acejhonatan.parkingcontrol.domain.service.adapter.Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartmentAdapter implements Adapter<ApartmentDtoRequest, ApartmentDtoResponse, Apartment> {

    @Autowired
    private OwnerAdapter ownerAdapter;

    @Autowired
    private OwnerService ownerService;

    @Override
    public ApartmentDtoResponse fromEntity(Apartment apartment) {
        return new ApartmentDtoResponse(
                apartment.getId(),
                apartment.getNumber(),
                ownerAdapter.fromEntity(apartment.getOwner())
        );
    }

    @Override
    public Apartment fromDtoRequest(ApartmentDtoRequest dtoRequest) {
        return new Apartment(
                dtoRequest.getNumber(),
                ownerService.getById(dtoRequest.getOwnerId())
        );
    }
}
