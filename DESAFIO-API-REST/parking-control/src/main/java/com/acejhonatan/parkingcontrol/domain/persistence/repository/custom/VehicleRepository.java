package com.acejhonatan.parkingcontrol.domain.persistence.repository.custom;

import com.acejhonatan.parkingcontrol.domain.persistence.entity.Vehicle;
import com.acejhonatan.parkingcontrol.domain.persistence.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    Optional<Vehicle> findByLicensePlate(String licensePlate);
}
