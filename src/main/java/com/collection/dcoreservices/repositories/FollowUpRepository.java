package com.collection.dcoreservices.repositories;


import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.collection.dcoreservices.entities.FollowUpEntity;

@Repository
public interface FollowUpRepository extends JpaRepository<FollowUpEntity, Long> {

	 @Procedure(name = "FollowUp.PRC_RegisterFollowup")
	 Map<String, Object> PRC_RegisterFollowup(
	        String p_dcrn,
	        Long p_agrseq,
	        String p_userId,
	        String p_actionDate,
	        String p_actionCode,
	        String p_resultCode,
	        String p_nextAction,
	        String p_nextActionDateTime,
	        String p_promiseDate,
	        Long p_promiseAmount,
	        String p_remark,
	        @Param("p_out_status") String p_out_status,   // OUT parameter: p_out_status
	        @Param("p_out_dcrnno") String p_out_dcrnno,   // OUT parameter: p_out_dcrnno
	        @Param("p_out_reason") String p_out_reason  
	    );
}
