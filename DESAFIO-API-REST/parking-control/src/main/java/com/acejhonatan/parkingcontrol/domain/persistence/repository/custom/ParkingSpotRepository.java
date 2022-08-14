package com.acejhonatan.parkingcontrol.domain.persistence.repository.custom;

import com.acejhonatan.parkingcontrol.domain.persistence.entity.ParkingSpot;
import com.acejhonatan.parkingcontrol.domain.persistence.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingSpotRepository extends CrudRepository<ParkingSpot, Long> {

    Optional<ParkingSpot> findByNumber(String number);
}
