package com.acejhonatan.parkingcontrol.api.controller;

import com.acejhonatan.parkingcontrol.api.dto.owner.OwnerDtoRequest;
import com.acejhonatan.parkingcontrol.api.dto.owner.OwnerDtoResponse;
import com.acejhonatan.parkingcontrol.domain.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService service;

    @PostMapping
    public ResponseEntity<OwnerDtoResponse> insert(@RequestBody @Valid OwnerDtoRequest dtoRequest) {
        OwnerDtoResponse newOwner = service.create(dtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOwner);
    }

    @GetMapping
    public ResponseEntity<Page<OwnerDtoResponse>> getAll(@PageableDefault(page = 0, size = 5, sort = "id",
            direction = Sort.Direction.ASC) Pageable pageable) {
        Page<OwnerDtoResponse> owners = service.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(owners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDtoResponse> getById(@PathVariable Long id) {
        OwnerDtoResponse owner = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(owner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerDtoResponse> update(@PathVariable Long id, @RequestBody @Valid OwnerDtoRequest dtoRequest) {
        OwnerDtoResponse ownerUpdated = service.update(id, dtoRequest);
        return ResponseEntity.status(HttpStatus.OK).body(ownerUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
