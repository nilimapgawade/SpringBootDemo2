package com.collection.dcoreservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collection.dcoreservices.entities.InBoundCallHeaderEntity;


@Repository
public interface InBoundCallHeaderRepository extends JpaRepository<InBoundCallHeaderEntity, Long> {



}
