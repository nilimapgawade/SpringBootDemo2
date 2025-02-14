package com.collection.dcoreservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collection.dcoreservices.entities.CheckURCEntity;




@Repository
public interface CheckURCRepository extends JpaRepository<CheckURCEntity, Long> {
	boolean existsByUrc(String SZURC);
}
