package com.acejhonatan.parkingcontrol.domain.service;

import com.acejhonatan.parkingcontrol.api.dto.apartment.ApartmentDtoRequest;
import com.acejhonatan.parkingcontrol.api.dto.apartment.ApartmentDtoResponse;
import com.acejhonatan.parkingcontrol.domain.persistence.entity.Apartment;
import com.acejhonatan.parkingcontrol.domain.persistence.repository.custom.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Objects;

@Service
public class ApartmentService extends CrudService<ApartmentDtoRequest, ApartmentDtoResponse, Apartment, Long> {

    @Autowired
    private ApartmentRepository repository;

    @Override
    protected void updateData(ApartmentDtoRequest dtoRequest, Apartment apartment) {
        checkRequest(dtoRequest, apartment);
        apartment.setNumber(dtoRequest.getNumber());
    }

    @Override
    protected void checkRequest(ApartmentDtoRequest dtoRequest, Apartment toSave) {
        boolean entityExists =  repository.findByNumber(dtoRequest.getNumber())
                .stream()
                .anyMatch(obtained -> !Objects.equals(obtained, toSave));
        if (entityExists) {
            throw new EntityExistsException("An apartment with this number already exists.");
        }
    }
}
