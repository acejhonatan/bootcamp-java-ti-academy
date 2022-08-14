package com.acejhonatan.parkingcontrol.api.controller;

import com.acejhonatan.parkingcontrol.api.dto.apartment.ApartmentDtoRequest;
import com.acejhonatan.parkingcontrol.api.dto.apartment.ApartmentDtoResponse;
import com.acejhonatan.parkingcontrol.domain.persistence.entity.Apartment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apartments")
public class ApartmentController extends CrudController<ApartmentDtoRequest, ApartmentDtoResponse, Apartment, Long> {

}
