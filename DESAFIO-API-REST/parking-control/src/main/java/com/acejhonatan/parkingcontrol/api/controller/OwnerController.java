package com.acejhonatan.parkingcontrol.api.controller;

import com.acejhonatan.parkingcontrol.api.dto.owner.OwnerDtoRequest;
import com.acejhonatan.parkingcontrol.api.dto.owner.OwnerDtoResponse;
import com.acejhonatan.parkingcontrol.domain.persistence.entity.Owner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owners")
public class OwnerController extends CrudController<OwnerDtoRequest, OwnerDtoResponse, Owner, Long> {

}
