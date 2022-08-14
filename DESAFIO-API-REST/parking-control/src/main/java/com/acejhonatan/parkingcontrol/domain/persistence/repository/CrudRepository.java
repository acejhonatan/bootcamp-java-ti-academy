package com.acejhonatan.parkingcontrol.domain.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CrudRepository<Entity, ID> extends JpaRepository<Entity, ID> {

}
