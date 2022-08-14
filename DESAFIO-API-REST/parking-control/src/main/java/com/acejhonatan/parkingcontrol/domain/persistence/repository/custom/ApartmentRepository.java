package com.acejhonatan.parkingcontrol.domain.persistence.repository.custom;

import com.acejhonatan.parkingcontrol.domain.persistence.entity.Apartment;
import com.acejhonatan.parkingcontrol.domain.persistence.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApartmentRepository extends CrudRepository<Apartment, Long> {

    Optional<Apartment> findByNumber(String number);
}
