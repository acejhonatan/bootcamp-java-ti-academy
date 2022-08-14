package com.acejhonatan.parkingcontrol.api.controller;

import com.acejhonatan.parkingcontrol.api.dto.vehicle.VehicleDtoRequest;
import com.acejhonatan.parkingcontrol.api.dto.vehicle.VehicleDtoResponse;
import com.acejhonatan.parkingcontrol.domain.persistence.entity.Vehicle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehicleController extends CrudController<VehicleDtoRequest, VehicleDtoResponse, Vehicle, Long> {

}
