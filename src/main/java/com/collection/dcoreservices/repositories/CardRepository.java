package com.collection.dcoreservices.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.collection.dcoreservices.entities.CardEntity;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, String> {

    
    CardEntity findByAgrseq( String agrseq);
}

