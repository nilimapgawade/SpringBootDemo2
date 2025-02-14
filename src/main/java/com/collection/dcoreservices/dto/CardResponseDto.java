package com.collection.dcoreservices.dto;

import java.util.List;


public class CardResponseDto {

	    private String cardAccNumber;
	    private String cardNumber;
	    private String binNumber;
	    private String firstName;
	    private String fullName;
	    private String cif;
	    private String creditLimit;
	    private String totalOutstandingBalance;
	    private String futureDueAmount;
	    private String minimumDue;
	    private String totalPrincipleAmount;
	    private String totalPastdueAmount;
	    private String paymentDueDate;
	    private String overlimitAmount;
	    private String productType;
	    private String billingCycleDate;
	    private String billingCycleDay;
	    private String isPTPLive;
	    private String isSettlementLive;
	    private String isSettlementOffer;
	    private String subscribedOffer;
	    private String npaStage;
	    private String eom;
	    private String predueFlag;
	    private String dpd;
	    private String agrseq;
	    private String blockCode1;
	    private String blockCode2;
	    private String ippFlag;
	    private List<PtpDto> ptp;
	    private LoanDcrnDetail dcrnDetail;
	    private List<SettlementDto> settlement;
	    
	    
	    public CardResponseDto() {
	    }
	   	    
		public CardResponseDto(String cardAccNumber, String cardNumber, String binNumber, String firstName,
				String fullName, String cif, String creditLimit, String totalOutstandingBalance, String futureDueAmount,
				String minimumDue, String totalPrincipleAmount, String totalPastdueAmount, String paymentDueDate,
				String overlimitAmount, String productType, String billingCycleDate, String billingCycleDay,
				String isPTPLive, String isSettlementLive, String isSettlementOffer, String subscribedOffer,
				String npaStage, String eom, String predueFlag, String dpd, String agrseq, String blockCode1,
				String blockCode2, String ippFlag, List<PtpDto> ptp, LoanDcrnDetail dcrnDetail,
				List<SettlementDto> settlement) {
			super();
			this.cardAccNumber = cardAccNumber;
			this.cardNumber = cardNumber;
			this.binNumber = binNumber;
			this.firstName = firstName;
			this.fullName = fullName;
			this.cif = cif;
			this.creditLimit = creditLimit;
			this.totalOutstandingBalance = totalOutstandingBalance;
			this.futureDueAmount = futureDueAmount;
			this.minimumDue = minimumDue;
			this.totalPrincipleAmount = totalPrincipleAmount;
			this.totalPastdueAmount = totalPastdueAmount;
			this.paymentDueDate = paymentDueDate;
			this.overlimitAmount = overlimitAmount;
			this.productType = productType;
			this.billingCycleDate = billingCycleDate;
			this.billingCycleDay = billingCycleDay;
			this.isPTPLive = isPTPLive;
			this.isSettlementLive = isSettlementLive;
			this.isSettlementOffer = isSettlementOffer;
			this.subscribedOffer = subscribedOffer;
			this.npaStage = npaStage;
			this.eom = eom;
			this.predueFlag = predueFlag;
			this.dpd = dpd;
			this.agrseq = agrseq;
			this.blockCode1 = blockCode1;
			this.blockCode2 = blockCode2;
			this.ippFlag = ippFlag;
			this.ptp = ptp;
			this.dcrnDetail = dcrnDetail;
			this.settlement = settlement;
		}
		
		
		public LoanDcrnDetail getDcrnDetail() {
			return dcrnDetail;
		}

		public void setDcrnDetail(LoanDcrnDetail dcrnDetail) {
			this.dcrnDetail = dcrnDetail;
		}

		public String getCardAccNumber() {
			return cardAccNumber;
		}
		public void setCardAccNumber(String cardAccNumber) {
			this.cardAccNumber = cardAccNumber;
		}
		public String getCardNumber() {
			return cardNumber;
		}
		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}
		public String getBinNumber() {
			return binNumber;
		}
		public void setBinNumber(String binNumber) {
			this.binNumber = binNumber;
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
		public String getCreditLimit() {
			return creditLimit;
		}
		public void setCreditLimit(String creditLimit) {
			this.creditLimit = creditLimit;
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
		public String getMinimumDue() {
			return minimumDue;
		}
		public void setMinimumDue(String minimumDue) {
			this.minimumDue = minimumDue;
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
		public String getOverlimitAmount() {
			return overlimitAmount;
		}
		public void setOverlimitAmount(String overlimitAmount) {
			this.overlimitAmount = overlimitAmount;
		}
		public String getProductType() {
			return productType;
		}
		public void setProductType(String productType) {
			this.productType = productType;
		}
		public String getBillingCycleDate() {
			return billingCycleDate;
		}
		public void setBillingCycleDate(String billingCycleDate) {
			this.billingCycleDate = billingCycleDate;
		}
		public String getBillingCycleDay() {
			return billingCycleDay;
		}
		public void setBillingCycleDay(String billingCycleDay) {
			this.billingCycleDay = billingCycleDay;
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
		public String getBlockCode1() {
			return blockCode1;
		}
		public void setBlockCode1(String blockCode1) {
			this.blockCode1 = blockCode1;
		}
		public String getBlockCode2() {
			return blockCode2;
		}
		public void setBlockCode2(String blockCode2) {
			this.blockCode2 = blockCode2;
		}
		public String getIppFlag() {
			return ippFlag;
		}
		public void setIppFlag(String ippFlag) {
			this.ippFlag = ippFlag;
		}
		public List<PtpDto> getPtp() {
			return ptp;
		}
		public void setPtp(List<PtpDto> ptp) {
			this.ptp = ptp;
		}
		public List<SettlementDto> getSettlement() {
			return settlement;
		}
		public void setSettlement(List<SettlementDto> settlement) {
			this.settlement = settlement;
		}
	    
	
}
