package com.acejhonatan.parkingcontrol.domain.persistence.repository;

import com.acejhonatan.parkingcontrol.domain.persistence.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Optional<Owner> findByDocument(String document);
}
