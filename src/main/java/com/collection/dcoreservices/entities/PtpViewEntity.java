package com.collection.dcoreservices.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_DC_GETPTPDETAILS")
public class PtpViewEntity {

    @Id
    @Column(name = "agrseq")
    private String agrseq;
    
    @Column(name = "reference_no")
    private String referenceNo;

    @Column(name = "ptp_date")
    private String ptpDate;

    @Column(name = "amount")
    private String amount;

	public String getAgrseq() {
		return agrseq;
	}

	public void setAgrseq(String agrseq) {
		this.agrseq = agrseq;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getPtpDate() {
		return ptpDate;
	}

	public void setPtpDate(String ptpDate) {
		this.ptpDate = ptpDate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	
    
    
}