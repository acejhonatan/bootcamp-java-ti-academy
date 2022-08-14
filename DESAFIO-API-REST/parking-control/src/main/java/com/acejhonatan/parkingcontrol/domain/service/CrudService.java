package com.acejhonatan.parkingcontrol.domain.service;

import com.acejhonatan.parkingcontrol.domain.persistence.repository.CrudRepository;
import com.acejhonatan.parkingcontrol.domain.service.adapter.Adapter;
import com.acejhonatan.parkingcontrol.core.util.ServiceUtil;
import com.acejhonatan.parkingcontrol.domain.service.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public abstract class CrudService<DtoRequest, DtoResponse, Entity, ID> extends ServiceUtil {

    @Autowired
    private CrudRepository<Entity, ID> repository;

    @Autowired
    private Adapter<DtoRequest, DtoResponse, Entity> adapter;

    public DtoResponse create(DtoRequest dtoRequest) {
        Entity newEntity = adapter.fromDtoRequest(dtoRequest);
        checkRequest(dtoRequest, newEntity);
        return adapter.fromEntity(repository.save(newEntity));
    }

    public Page<DtoResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(adapter::fromEntity);
    }

    public DtoResponse findById(ID id) {
        return adapter.fromEntity(getById(id));
    }

    public DtoResponse update(ID id, DtoRequest dtoRequest) {
        Entity entity = getById(id);
        updateData(dtoRequest, entity);
        return adapter.fromEntity(repository.save(entity));
    }

    public Entity getById(ID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(getEntityName(), id));
    }

    protected abstract void updateData(DtoRequest dtoRequest, Entity entity);

    protected abstract void checkRequest(DtoRequest dtoRequest, Entity toSave);

    public void delete(ID id) {
        repository.delete(getById(id));
    }
}
