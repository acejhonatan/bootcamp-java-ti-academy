package com.acejhonatan.parkingcontrol.domain.service.adapter.impl;

import com.acejhonatan.parkingcontrol.api.dto.owner.OwnerDtoRequest;
import com.acejhonatan.parkingcontrol.api.dto.owner.OwnerDtoResponse;
import com.acejhonatan.parkingcontrol.domain.persistence.entity.Owner;
import com.acejhonatan.parkingcontrol.domain.service.adapter.Adapter;
import org.springframework.stereotype.Service;

@Service
public class OwnerAdapter implements Adapter<OwnerDtoRequest, OwnerDtoResponse, Owner> {

    @Override
    public OwnerDtoResponse fromEntity(Owner owner) {
        return new OwnerDtoResponse(
                owner.getId(),
                owner.getName(),
                owner.getDocument()
        );
    }

    @Override
    public Owner fromDtoRequest(OwnerDtoRequest dtoRequest) {
        return new Owner(
                dtoRequest.getName(),
                dtoRequest.getDocument()
        );
    }
}
