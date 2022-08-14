package com.acejhonatan.parkingcontrol.domain.service.exception;

public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -8405058800830309815L;

    public EntityNotFoundException(String entityName, Object id) {
        super(entityName + " ID #" + id + " not found.");
    }
}
