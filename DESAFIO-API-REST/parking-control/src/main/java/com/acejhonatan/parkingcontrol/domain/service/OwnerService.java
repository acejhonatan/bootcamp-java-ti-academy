package com.acejhonatan.parkingcontrol.domain.service;

import com.acejhonatan.parkingcontrol.api.dto.owner.OwnerDtoRequest;
import com.acejhonatan.parkingcontrol.api.dto.owner.OwnerDtoResponse;
import com.acejhonatan.parkingcontrol.domain.persistence.entity.Owner;
import com.acejhonatan.parkingcontrol.domain.persistence.repository.custom.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Objects;

@Service
public class OwnerService extends CrudService<OwnerDtoRequest, OwnerDtoResponse, Owner, Long> {

    @Autowired
    private OwnerRepository repository;

    @Override
    protected void updateData(OwnerDtoRequest dtoRequest, Owner owner) {
        checkRequest(dtoRequest, owner);
        owner.setName(dtoRequest.getName());
        owner.setDocument(dtoRequest.getDocument());
    }

    @Override
    protected void checkRequest(OwnerDtoRequest dtoRequest, Owner toSave) {
        boolean entityExists = repository.findByDocument(dtoRequest.getDocument())
                .stream()
                .anyMatch(obtained -> !Objects.equals(obtained, toSave));
        if (entityExists) {
            throw new EntityExistsException("An owner with this document already exists.");
        }
    }
}
