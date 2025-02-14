package com.collection.dcoreservices.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.ParameterMode;

@Entity
@NamedStoredProcedureQuery(
	    name = "FollowUp.PRC_RegisterFollowup",
	    procedureName = "PRC_RegisterFollowup",
	    parameters = {
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_dcrn", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_agrseq", type = Long.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_userId", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_actionDate", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_actionCode", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_resultCode", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nextAction", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nextActionDateTime", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_promiseDate", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_promiseAmount", type = Long.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_remark", type = String.class),
	        
	        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_status", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_dcrnno", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_out_reason", type = String.class)
	    }
	)
public class FollowUpEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // If you want auto-generated ID
    private Long id; // Primary key for the entity, auto-generated

    private String p_out_status;
    private String p_out_dcrnno;
    private String p_out_reason;
    
    private String p_dcrn;  // DCRN
    private String p_agrseq; // Agreement Sequence
    private String p_userId; // User ID
    private String p_actionDate; // Action Date
    private String p_actionCode; // Action Code
    private String p_resultCode; // Result Code
    private String p_nextAction; // Next Action
    private String p_nextActionDateTime; // Next Action Date Time
    private String p_promiseDate; // Promise Date
    private String p_promiseAmount; // Promise Amount
    private String remark; // Remark
    
	public Long getId() {
		return id;
	}
	public String getP_dcrn() {
		return p_dcrn;
	}
	public void setP_dcrn(String p_dcrn) {
		this.p_dcrn = p_dcrn;
	}
	public String getP_agrseq() {
		return p_agrseq;
	}
	public void setP_agrseq(String p_agrseq) {
		this.p_agrseq = p_agrseq;
	}
	public String getP_userId() {
		return p_userId;
	}
	public void setP_userId(String p_userId) {
		this.p_userId = p_userId;
	}
	public String getP_actionDate() {
		return p_actionDate;
	}
	public void setP_actionDate(String p_actionDate) {
		this.p_actionDate = p_actionDate;
	}
	public String getP_actionCode() {
		return p_actionCode;
	}
	public void setP_actionCode(String p_actionCode) {
		this.p_actionCode = p_actionCode;
	}
	public String getP_resultCode() {
		return p_resultCode;
	}
	public void setP_resultCode(String p_resultCode) {
		this.p_resultCode = p_resultCode;
	}
	public String getP_nextAction() {
		return p_nextAction;
	}
	public void setP_nextAction(String p_nextAction) {
		this.p_nextAction = p_nextAction;
	}
	public String getP_nextActionDateTime() {
		return p_nextActionDateTime;
	}
	public void setP_nextActionDateTime(String p_nextActionDateTime) {
		this.p_nextActionDateTime = p_nextActionDateTime;
	}
	public String getP_promiseDate() {
		return p_promiseDate;
	}
	public void setP_promiseDate(String p_promiseDate) {
		this.p_promiseDate = p_promiseDate;
	}
	public String getP_promiseAmount() {
		return p_promiseAmount;
	}
	public void setP_promiseAmount(String p_promiseAmount) {
		this.p_promiseAmount = p_promiseAmount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getP_out_status() {
		return p_out_status;
	}
	public void setP_out_status(String p_out_status) {
		this.p_out_status = p_out_status;
	}
	public String getP_out_dcrnno() {
		return p_out_dcrnno;
	}
	public void setP_out_dcrnno(String p_out_dcrnno) {
		this.p_out_dcrnno = p_out_dcrnno;
	}
	public String getP_out_reason() {
		return p_out_reason;
	}
	public void setP_out_reason(String p_out_reason) {
		this.p_out_reason = p_out_reason;
	}
    
    
    	
}
