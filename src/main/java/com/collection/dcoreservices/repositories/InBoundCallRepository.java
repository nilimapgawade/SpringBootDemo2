package com.collection.dcoreservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collection.dcoreservices.entities.InBoundCallResponseEntity;



@Repository
public interface InBoundCallRepository extends JpaRepository<InBoundCallResponseEntity, String> {

	public InBoundCallResponseEntity findByAccountNO(String accountNO);

}
