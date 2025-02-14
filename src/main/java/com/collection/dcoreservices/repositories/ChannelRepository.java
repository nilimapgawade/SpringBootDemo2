package com.collection.dcoreservices.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.collection.dcoreservices.entities.ColMstSettingsEntity;
import com.collection.dcoreservices.entities.ColMstSettingsPK;



@Repository
public interface ChannelRepository extends JpaRepository<ColMstSettingsEntity, ColMstSettingsPK> {

	@Query("SELECT s.szvalue FROM ColMstSettingsEntity s WHERE s.szconditiontype = 'APIChannelMaster' AND s.szcondition = 'ChannelID'")
	String findChannelIdFromSettings();

	@Query("SELECT s.szvalue FROM ColMstSettingsEntity s WHERE s.szconditiontype = 'APIChannelMaster' AND s.szcondition = 'RHSSO URL'")
	String findRHSSOURLFromSettings();
	
	@Query("SELECT s.szvalue FROM ColMstSettingsEntity s WHERE s.szconditiontype = 'ApiIssuer' AND s.szcondition = 'Issuer'")
	String findISSUERFromSettings();
}
