package com.collection.dcoreservices.dto;

public class SettlementDto {

	private String referenceNo;  // Existing field
    private String installmentDate;  // Existing field
    private String dueInstallmentAmount;  // Added based on JSON structure
    private String installmentPaid;  // Added based on JSON structure
    private String installmentLeft;  // Added based on JSON structure
    private String totalNoOfInstallment;  // Added based on JSON structure
    private String totalBrokenInstallment;  // Added based on JSON structure
    private String settlementAmount;  // Added based on JSON structure
    private String settlementPaidAmount;  // Added based on JSON structure
    private String balanceAmount;  // Added based on JSON structure
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
	public String getDueInstallmentAmount() {
		return dueInstallmentAmount;
	}
	public void setDueInstallmentAmount(String dueInstallmentAmount) {
		this.dueInstallmentAmount = dueInstallmentAmount;
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
