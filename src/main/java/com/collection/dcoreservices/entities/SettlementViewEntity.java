package com.collection.dcoreservices.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_DC_GETSETTLEMENTDETAILS")
public class SettlementViewEntity {

    @Id
    @Column(name = "agrseq")
    private String agrseq;
    

	@Column(name = "reference_no")  
    private String referenceNo;

    @Column(name = "installment_date")  
    private String installmentDate;

    @Column(name = "due_amount")  
    private String dueAmount;

    @Column(name = "installment_paid") 
    private String installmentPaid;  

    @Column(name = "installment_left")  
    private String installmentLeft;  

    @Column(name = "total_no_of_installment")  
    private String totalNoOfInstallment;  

    @Column(name = "total_broken_installment")  
    private String totalBrokenInstallment;  

    @Column(name = "fsettlementamount")  
    private String settlementAmount;  

    @Column(name = "fsettlementpaidamount")  
    private String settlementPaidAmount;  

    @Column(name = "fbalanceamount")  
    private String balanceAmount;

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

	public String getInstallmentDate() {
		return installmentDate;
	}

	public void setInstallmentDate(String installmentDate) {
		this.installmentDate = installmentDate;
	}

	public String getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(String dueAmount) {
		this.dueAmount = dueAmount;
	}

	public String getInstallmentPaid() {
		return installmentPaid;
	}

	public void setInstallmentPaid(String installmentPaid) {
		this.installmentPaid = installmentPaid;
	}

	public String getInstallmentLeft() {
		return installmentLeft;
	}

	public void setInstallmentLeft(String installmentLeft) {
		this.installmentLeft = installmentLeft;
	}

	public String getTotalNoOfInstallment() {
		return totalNoOfInstallment;
	}

	public void setTotalNoOfInstallment(String totalNoOfInstallment) {
		this.totalNoOfInstallment = totalNoOfInstallment;
	}

	public String getTotalBrokenInstallment() {
		return totalBrokenInstallment;
	}

	public void setTotalBrokenInstallment(String totalBrokenInstallment) {
		this.totalBrokenInstallment = totalBrokenInstallment;
	}

	public String getSettlementAmount() {
		return settlementAmount;
	}

	public void setSettlementAmount(String settlementAmount) {
		this.settlementAmount = settlementAmount;
	}

	public String getSettlementPaidAmount() {
		return settlementPaidAmount;
	}

	public void setSettlementPaidAmount(String settlementPaidAmount) {
		this.settlementPaidAmount = settlementPaidAmount;
	}

	public String getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(String balanceAmount) {
		this.balanceAmount = balanceAmount;
	}  
    
    
    
    
}
