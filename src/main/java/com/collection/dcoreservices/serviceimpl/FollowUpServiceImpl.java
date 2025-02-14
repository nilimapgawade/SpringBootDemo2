package com.collection.dcoreservices.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collection.dcoreservices.dto.FollowUpRequestDto;
import com.collection.dcoreservices.dto.FollowUpResponseDto;
import com.collection.dcoreservices.repositories.FollowUpRepository;
import com.collection.dcoreservices.services.FollowUpService;
import com.collection.dcoreservices.entities.FollowUpEntity;
import com.collection.dcoreservices.exceptions.ValidateFollowupException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class FollowUpServiceImpl implements FollowUpService  {

	private static final Logger logger = LoggerFactory.getLogger(FollowUpServiceImpl.class);

	@Autowired
	private FollowUpRepository followUpRepository;

	@Override
	public FollowUpResponseDto registerFollowUp(FollowUpRequestDto followUpRequestDto) throws Exception {
		FollowUpResponseDto response = new FollowUpResponseDto();
		String outStatus = null;
		String outDcrnno = null;
		String outReason = null;

		String actionDateMillis = followUpRequestDto.getActionDate();
		String nextActionDateTimeMillis = followUpRequestDto.getNextActionDateTime();
		String promiseDateMillis = followUpRequestDto.getPromiseDate();

		Date actionDate = new Date(Long.parseLong(actionDateMillis));
		Date nextActionDateTime = new Date(Long.parseLong(nextActionDateTimeMillis));
		Date promiseDate = new Date(Long.parseLong(promiseDateMillis));

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		String formattedActionDate = sdf.format(actionDate);
		String formattedNextActionDateTime = sdf.format(nextActionDateTime);
		String formattedPromiseDate = sdf.format(promiseDate);

		Long agrseqLong = Long.parseLong(followUpRequestDto.getAgrseq());

		BigDecimal promiseAmountBigDecimal = new BigDecimal(followUpRequestDto.getPromiseAmount());
		Long promiseAmountLong = promiseAmountBigDecimal.longValue();

		FollowUpEntity followUp = new FollowUpEntity();
		followUp.setP_dcrn(followUpRequestDto.getDcrn());
		followUp.setP_userId(followUpRequestDto.getUserId());
		followUp.setP_actionDate(formattedActionDate);
		followUp.setP_actionCode(followUpRequestDto.getActionCode());
		followUp.setP_resultCode(followUpRequestDto.getResultCode());
		followUp.setP_nextAction(followUpRequestDto.getNextAction());
		followUp.setP_nextActionDateTime(formattedNextActionDateTime);
		followUp.setP_promiseDate(formattedPromiseDate);
		followUp.setRemark(followUpRequestDto.getRemark());

		try {

			logger.info("Calling stored procedure with parameters: ");
			logger.info("Dcrn: {}", followUp.getP_dcrn());
			logger.info("Agrseq: {}", agrseqLong);
			logger.info("UserId: {}", followUp.getP_userId());
			logger.info("ActionDate: {}", followUp.getP_actionDate());
			logger.info("ActionCode: {}", followUp.getP_actionCode());
			logger.info("ResultCode: {}", followUp.getP_resultCode());
			logger.info("NextAction: {}", followUp.getP_nextAction());
			logger.info("NextActionDateTime: {}", followUp.getP_nextActionDateTime());
			logger.info("PromiseDate: {}", followUp.getP_promiseDate());
			logger.info("PromiseAmount: {}", promiseAmountLong);
			logger.info("Remark: {}", followUp.getRemark());

			logger.info("Executing stored procedure PRC_RegisterFollowup...");
			Map<String, Object> result = followUpRepository.PRC_RegisterFollowup(followUp.getP_dcrn(), agrseqLong,
					followUp.getP_userId(), followUp.getP_actionDate(), followUp.getP_actionCode(),
					followUp.getP_resultCode(), followUp.getP_nextAction(), followUp.getP_nextActionDateTime(),
					followUp.getP_promiseDate(), promiseAmountLong, followUp.getRemark(), null, null, null);

			outStatus = (String) result.get("p_out_status");
			outDcrnno = (String) result.get("p_out_dcrnno");
			outReason = (String) result.get("p_out_reason");
			
			logger.info("Stored procedure result: Status={}, Dcrnno={}, Reason={}", outStatus, outDcrnno, outReason);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error executing stored procedure", e);
		}
       //Need to discuss if fail status come then should we send this dcrn no or not
		if(outStatus.equalsIgnoreCase("SUCCESS")) {
		response.setReferenceNumber(outDcrnno);
		}
		logger.info("FollowUp registration successful. Reference number: {}", outDcrnno);
		if(outStatus.equalsIgnoreCase("FAILED")) {
			 throw new ValidateFollowupException (outReason, "10031");
		}

		return response;
	}

}
