package com.collection.dcoreservices.serviceimpl;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collection.dcoreservices.repositories.ChannelRepository;
import com.collection.dcoreservices.services.ChannelService;



@Service
public class ChannelServiceImpl implements ChannelService{

	private static final Logger logger = LoggerFactory.getLogger(ChannelServiceImpl.class);
	
	@Autowired
	private ChannelRepository repo;
	
	
	
	
	
	public boolean isValidChannel(String channelid) {
	  String  Channel = repo.findChannelIdFromSettings();
	  logger.info("Value of channel id from database: {}", Channel);

		if((channelid != null) && (Channel.equalsIgnoreCase(channelid))) {
			return true;
		}
		return false;
	}
	
	
	
	

	
}
