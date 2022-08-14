package com.acejhonatan.parkingcontrol.domain.service.adapter;

public interface Adapter<DtoRequest, DtoResponse, Entity> {

    DtoResponse fromEntity(Entity entity);

    Entity fromDtoRequest(DtoRequest dtoRequest);
}
