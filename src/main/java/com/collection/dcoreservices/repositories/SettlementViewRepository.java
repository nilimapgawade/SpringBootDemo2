package com.collection.dcoreservices.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collection.dcoreservices.entities.SettlementViewEntity;

import java.util.List;

@Repository
public interface SettlementViewRepository extends JpaRepository<SettlementViewEntity, String> {

    // Method to fetch settlement details by reference number
    List<SettlementViewEntity> findByAgrseq(String agrseq);
}
