package com.acejhonatan.parkingcontrol.api.controller;

import com.acejhonatan.parkingcontrol.api.dto.parkingspot.ParkingSpotDtoRequest;
import com.acejhonatan.parkingcontrol.api.dto.parkingspot.ParkingSpotDtoResponse;
import com.acejhonatan.parkingcontrol.domain.persistence.entity.ParkingSpot;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parking-spots")
public class ParkingSpotController extends CrudController<ParkingSpotDtoRequest, ParkingSpotDtoResponse, ParkingSpot, Long> {

}
