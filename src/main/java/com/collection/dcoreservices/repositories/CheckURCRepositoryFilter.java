package com.collection.dcoreservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collection.dcoreservices.entities.ApiLogEntity;



@Repository
public interface CheckURCRepositoryFilter extends JpaRepository<ApiLogEntity, Long> {
	boolean existsByUrc(String SZURC);
}
