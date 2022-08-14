package com.acejhonatan.parkingcontrol.domain.persistence.repository.custom;

import com.acejhonatan.parkingcontrol.domain.persistence.entity.Owner;
import com.acejhonatan.parkingcontrol.domain.persistence.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Optional<Owner> findByDocument(String document);
}
