package com.acejhonatan.parkingcontrol.api.controller;

import com.acejhonatan.parkingcontrol.domain.service.CrudService;
import com.acejhonatan.parkingcontrol.core.util.GetterUtil;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.data.domain.Sort.Direction.ASC;

@RestController
public abstract class CrudController<DtoRequest, DtoResponse extends GetterUtil<ID>, Entity, ID> {

    @Autowired
    private CrudService<DtoRequest, DtoResponse, Entity, ID> service;

    @PostMapping
    public ResponseEntity<DtoResponse> insert(@RequestBody @Valid DtoRequest dtoRequest) {

        var newObject = service.create(dtoRequest);

        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
        URI uri = builder.path("/{id}").buildAndExpand(newObject.getId()).toUri();

        return ResponseEntity.created(uri).body(newObject);
    }

    @GetMapping
    public ResponseEntity<Page<DtoResponse>> getAll(@PageableDefault(page = 0, size = 5, sort = "id", direction = ASC) Pageable pageable) {
        var list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoResponse> getById(@PathVariable ID id) {
        var object = service.findById(id);
        return ResponseEntity.ok().body(object);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DtoResponse> update(@PathVariable ID id, @RequestBody @Valid DtoRequest dtoRequest) {
        var objectUpdated = service.update(id, dtoRequest);
        return ResponseEntity.ok().body(objectUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
