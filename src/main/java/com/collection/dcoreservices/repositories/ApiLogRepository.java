package com.collection.dcoreservices.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.collection.dcoreservices.entities.ApiLogEntity;



public interface ApiLogRepository extends JpaRepository<ApiLogEntity, Long> {

}
