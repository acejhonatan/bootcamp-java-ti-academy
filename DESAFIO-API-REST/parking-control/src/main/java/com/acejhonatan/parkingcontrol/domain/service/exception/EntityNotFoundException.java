package com.acejhonatan.parkingcontrol.domain.service.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class entity, Long id) {
        super(entity.getSimpleName() + " ID #" + id + " not found.");
    }
}
