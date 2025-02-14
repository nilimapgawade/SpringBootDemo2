package com.collection.dcoreservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.collection.dcoreservices.entities.CheckDcrnEntity;



@Repository
public interface CheckDcrnRepository extends JpaRepository<CheckDcrnEntity, Long> {
    
    // Method to check if a value exists in the 'SZENCRYPTEDDCRNNO' column
    boolean existsByEncryptedDcrnNo(String Dcrn);
    
    //@Query("SELECT CASE WHEN trunc(t.dturlexpiry) < trunc(SYSDATE) THEN 'Y' ELSE 'N' END FROM CheckDcrnEntity t WHERE t.encryptedDcrnNo = :encryptedDcrnNo")
   // @Query("SELECT CASE WHEN trunc(t.dturlexpiry) < trunc(CURRENT_DATE) THEN 'Y' ELSE 'N' END FROM CheckDcrnEntity t WHERE t.encryptedDcrnNo = :encryptedDcrnNo")
   // String checkUrlExpiry(@Param("encryptedDcrnNo") String encryptedDcrnNo);

    @Query("SELECT CASE WHEN t.dturlexpiry < CURRENT_DATE THEN 'Y' ELSE 'N' END FROM CheckDcrnEntity t WHERE t.encryptedDcrnNo = :encryptedDcrnNo")
    String checkUrlExpiry(@Param("encryptedDcrnNo") String encryptedDcrnNo);


    
}