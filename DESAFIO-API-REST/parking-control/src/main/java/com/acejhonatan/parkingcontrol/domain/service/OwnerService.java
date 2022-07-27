package com.acejhonatan.parkingcontrol.domain.service;

import com.acejhonatan.parkingcontrol.api.dto.owner.OwnerDtoRequest;
import com.acejhonatan.parkingcontrol.api.dto.owner.OwnerDtoResponse;
import com.acejhonatan.parkingcontrol.domain.persistence.entity.Owner;
import com.acejhonatan.parkingcontrol.domain.persistence.repository.OwnerRepository;
import com.acejhonatan.parkingcontrol.domain.service.adapter.OwnerAdapter;
import com.acejhonatan.parkingcontrol.domain.service.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Objects;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository repository;

    @Autowired
    private OwnerAdapter adapter;

    public OwnerDtoResponse create(OwnerDtoRequest dtoRequest) {
        Owner newOwner = adapter.fromDtoRequest(dtoRequest);
        checkRequest(dtoRequest, newOwner);
        return adapter.fromEntity(repository.save(newOwner));
    }

    public Page<OwnerDtoResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(adapter::fromEntity);
    }

    public OwnerDtoResponse findById(Long id) {
        return adapter.fromEntity(getById(id));
    }

    public OwnerDtoResponse update(Long id, OwnerDtoRequest dtoRequest) {
        Owner owner = getById(id);
        updateData(dtoRequest, owner);
        return adapter.fromEntity(repository.save(owner));
    }

    private Owner getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Owner.class, id));
    }

    private void updateData(OwnerDtoRequest dtoRequest, Owner owner) {
        checkRequest(dtoRequest, owner);
        owner.setName(dtoRequest.getName());
        owner.setDocument(dtoRequest.getDocument());
    }

    private void checkRequest(OwnerDtoRequest dtoRequest, Owner toSave) {
        boolean entityExists = repository.findByDocument(dtoRequest.getDocument())
                .stream()
                .anyMatch(obtained -> !Objects.equals(obtained, toSave));
        if (entityExists) {
            throw new EntityExistsException("An owner with this document already exists.");
        }
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
