package com.collection.dcoreservices.repositories;

import com.collection.dcoreservices.entities.DcrnDetailEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DcrnDetailRepository extends JpaRepository<DcrnDetailEntity, String> {

    // Custom query to find the record by encryptedDcrnNo
	DcrnDetailEntity findByEncryptedDcrnNo(String encryptedDcrnNo);
}
