package com.acejhonatan.parkingcontrol.domain.service.adapter;

import com.acejhonatan.parkingcontrol.api.dto.owner.OwnerDtoRequest;
import com.acejhonatan.parkingcontrol.api.dto.owner.OwnerDtoResponse;
import com.acejhonatan.parkingcontrol.domain.persistence.entity.Owner;
import org.springframework.stereotype.Service;

@Service
public class OwnerAdapter {

    public OwnerDtoResponse fromEntity(Owner owner) {
        return new OwnerDtoResponse(
                owner.getId(),
                owner.getName(),
                owner.getDocument()
        );
    }

    public Owner fromDtoRequest(OwnerDtoRequest dtoRequest) {
        return new Owner(
                dtoRequest.getName(),
                dtoRequest.getDocument()
        );
    }
}
