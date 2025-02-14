package com.collection.dcoreservices.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class FollowUpRequestDto {
	
	 @NotNull(message = "DCRN is required")
	    @Size(max = 100, message = "DCRN cannot exceed 100 characters")
	    private String dcrn;

	    @NotNull(message = "Agreement sequence number is required")
	    private String agrseq;

	    @NotNull(message = "UserId is required")
	    @Size(max = 50, message = "UserId cannot exceed 50 characters")
	    private String userId;

	    @NotNull(message = "Action date is required")
	    private String actionDate;

	    @NotNull(message = "Action code is required")
	    @Size(max = 10, message = "Action code cannot exceed 10 characters")
	    private String actionCode;

	    @NotNull(message = "Result code is required")
	    @Size(max = 20, message = "Result code cannot exceed 20 characters")
	    private String resultCode;

	    @Size(max = 20, message = "Next action cannot exceed 20 characters")
	    private String nextAction;

	    private String nextActionDateTime;

	    @NotNull(message = "Promise date is required")
	    private String promiseDate;

	    @NotNull(message = "Promise amount is required")
	    private String promiseAmount;

	    @Size(max = 300, message = "Remark cannot exceed 300 characters")
	    private String remark;

		public String getDcrn() {
			return dcrn;
		}

		public void setDcrn(String dcrn) {
			this.dcrn = dcrn;
		}

		public String getAgrseq() {
			return agrseq;
		}

		public void setAgrseq(String agrseq) {
			this.agrseq = agrseq;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getActionDate() {
			return actionDate;
		}

		public void setActionDate(String actionDate) {
			this.actionDate = actionDate;
		}

		public String getActionCode() {
			return actionCode;
		}

		public void setActionCode(String actionCode) {
			this.actionCode = actionCode;
		}

		public String getResultCode() {
			return resultCode;
		}

		public void setResultCode(String resultCode) {
			this.resultCode = resultCode;
		}

		public String getNextAction() {
			return nextAction;
		}

		public void setNextAction(String nextAction) {
			this.nextAction = nextAction;
		}

		public String getNextActionDateTime() {
			return nextActionDateTime;
		}

		public void setNextActionDateTime(String nextActionDateTime) {
			this.nextActionDateTime = nextActionDateTime;
		}

		public String getPromiseDate() {
			return promiseDate;
		}

		public void setPromiseDate(String promiseDate) {
			this.promiseDate = promiseDate;
		}

		public String getPromiseAmount() {
			return promiseAmount;
		}

		public void setPromiseAmount(String promiseAmount) {
			this.promiseAmount = promiseAmount;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		
	   

}
