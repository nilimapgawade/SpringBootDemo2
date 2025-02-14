package com.collection.dcoreservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.collection.dcoreservices.entities.PtpViewEntity;



import java.util.List;

@Repository
public interface PtpViewRepository extends JpaRepository<PtpViewEntity, String> {

    // Method to fetch PTP details by reference number
    List<PtpViewEntity> findByAgrseq(String agrseq);
}
