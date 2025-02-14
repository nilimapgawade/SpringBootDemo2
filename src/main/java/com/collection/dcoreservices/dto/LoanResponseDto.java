package com.collection.dcoreservices.dto;

import java.util.List;

public class LoanResponseDto {
	
	private String loanAccNumber;
    private String firstName;
    private String fullName;
    private String cif;
    private String financeAmount;  // Changed to String
    private String totalOutstandingBalance;  // Changed to String
    private String futureDueAmount;  // Changed to String
    private String installmentAmount;  // Changed to String
    private String totalPrincipleAmount; //needed
    private String totalPastdueAmount;  // Changed to String
   // private String totalOverdueAmount;  not needed
    private String paymentDueDate;  // Changed to String
    private String billingCycleDay;
    
	private String productType;
    private String isPTPLive;
    private String isSettlementLive;
   
    private String isSettlementOffer;
    private String subscribedOffer;
    private String npaStage;
    private String eom;  // Changed to String
    private String predueFlag;
    private String dpd;  // Changed to String
    private String agrseq;  // Changed to String
    //private String expiryDate;  not needed
    private List<PtpDto> ptp; // Added
    private LoanDcrnDetail dcrnDetail;
    private List<SettlementDto> settlement;
    
    public LoanResponseDto() {
    }
    
	public LoanResponseDto(String loanAccNumber, String firstName, String fullName, String cif, String financeAmount,
			String totalOutstandingBalance, String futureDueAmount, String installmentAmount,
			String totalPrincipleAmount, String totalPastdueAmount, String paymentDueDate, String billingCycleDay,
			String productType, String isPTPLive, String isSettlementLive, String isSettlementOffer,
			String subscribedOffer, String npaStage, String eom, String predueFlag, String dpd, String agrseq,
			List<PtpDto> ptp, LoanDcrnDetail dcrnDetail, List<SettlementDto> settlement) {
		
		this.loanAccNumber = loanAccNumber;
		this.firstName = firstName;
		this.fullName = fullName;
		this.cif = cif;
		this.financeAmount = financeAmount;
		this.totalOutstandingBalance = totalOutstandingBalance;
		this.futureDueAmount = futureDueAmount;
		this.installmentAmount = installmentAmount;
		this.totalPrincipleAmount = totalPrincipleAmount;
		this.totalPastdueAmount = totalPastdueAmount;
		this.paymentDueDate = paymentDueDate;
		this.billingCycleDay = billingCycleDay;
		this.productType = productType;
		this.isPTPLive = isPTPLive;
		this.isSettlementLive = isSettlementLive;
		this.isSettlementOffer = isSettlementOffer;
		this.subscribedOffer = subscribedOffer;
		this.npaStage = npaStage;
		this.eom = eom;
		this.predueFlag = predueFlag;
		this.dpd = dpd;
		this.agrseq = agrseq;
		this.ptp = ptp;
		this.dcrnDetail = dcrnDetail;
		this.settlement = settlement;
	}

	public String getLoanAccNumber() {
		return loanAccNumber;
	}

	public void setLoanAccNumber(String loanAccNumber) {
		this.loanAccNumber = loanAccNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getFinanceAmount() {
		return financeAmount;
	}

	public void setFinanceAmount(String financeAmount) {
		this.financeAmount = financeAmount;
	}

	public String getTotalOutstandingBalance() {
		return totalOutstandingBalance;
	}

	public void setTotalOutstandingBalance(String totalOutstandingBalance) {
		this.totalOutstandingBalance = totalOutstandingBalance;
	}

	public String getFutureDueAmount() {
		return futureDueAmount;
	}

	public void setFutureDueAmount(String futureDueAmount) {
		this.futureDueAmount = futureDueAmount;
	}

	public String getInstallmentAmount() {
		return installmentAmount;
	}

	public void setInstallmentAmount(String installmentAmount) {
		this.installmentAmount = installmentAmount;
	}

	public String getTotalPrincipleAmount() {
		return totalPrincipleAmount;
	}

	public void setTotalPrincipleAmount(String totalPrincipleAmount) {
		this.totalPrincipleAmount = totalPrincipleAmount;
	}

	public String getTotalPastdueAmount() {
		return totalPastdueAmount;
	}

	public void setTotalPastdueAmount(String totalPastdueAmount) {
		this.totalPastdueAmount = totalPastdueAmount;
	}

	public String getPaymentDueDate() {
		return paymentDueDate;
	}

	public void setPaymentDueDate(String paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}

	public String getBillingCycleDay() {
		return billingCycleDay;
	}

	public void setBillingCycleDay(String billingCycleDay) {
		this.billingCycleDay = billingCycleDay;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getIsPTPLive() {
		return isPTPLive;
	}

	public void setIsPTPLive(String isPTPLive) {
		this.isPTPLive = isPTPLive;
	}

	public String getIsSettlementLive() {
		return isSettlementLive;
	}

	public void setIsSettlementLive(String isSettlementLive) {
		this.isSettlementLive = isSettlementLive;
	}

	public String getIsSettlementOffer() {
		return isSettlementOffer;
	}

	public void setIsSettlementOffer(String isSettlementOffer) {
		this.isSettlementOffer = isSettlementOffer;
	}

	public String getSubscribedOffer() {
		return subscribedOffer;
	}

	public void setSubscribedOffer(String subscribedOffer) {
		this.subscribedOffer = subscribedOffer;
	}

	public String getNpaStage() {
		return npaStage;
	}

	public void setNpaStage(String npaStage) {
		this.npaStage = npaStage;
	}

	public String getEom() {
		return eom;
	}

	public void setEom(String eom) {
		this.eom = eom;
	}

	public String getPredueFlag() {
		return predueFlag;
	}

	public void setPredueFlag(String predueFlag) {
		this.predueFlag = predueFlag;
	}

	public String getDpd() {
		return dpd;
	}

	public void setDpd(String dpd) {
		this.dpd = dpd;
	}

	public String getAgrseq() {
		return agrseq;
	}

	public void setAgrseq(String agrseq) {
		this.agrseq = agrseq;
	}

	public List<PtpDto> getPtp() {
		return ptp;
	}

	public void setPtp(List<PtpDto> ptp) {
		this.ptp = ptp;
	}

	public LoanDcrnDetail getDcrnDetail() {
		return dcrnDetail;
	}

	public void setDcrnDetail(LoanDcrnDetail dcrnDetail) {
		this.dcrnDetail = dcrnDetail;
	}

	public List<SettlementDto> getSettlement() {
		return settlement;
	}

	public void setSettlement(List<SettlementDto> settlement) {
		this.settlement = settlement;
	}
	
	
    
    

}
