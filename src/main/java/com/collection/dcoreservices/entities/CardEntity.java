package com.collection.dcoreservices.entities;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_DC_GETACCOUNTDETAILS")
public class CardEntity {

    @Id
    @Column(name = "card_Acc_Number")
    private String cardAccNumber;

    @Column(name = "card_Number")
    private String cardNumber;

    @Column(name = "bin_Number")
    private String binNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "cif")
    private String cif;

    @Column(name = "credit_Limit")
    private String creditLimit;

    @Column(name = "total_outstanding_balance")
    private String totalOutstandingBalance;

    @Column(name = "future_due_amount")
    private String future_due_amount;

    @Column(name = "minimum_Due")
    private String minimumDue;

    @Column(name = "total_principle_amount")
    private String totalPrincipleAmount;

    @Column(name = "total_overdue_amount")
    private String totalOverdueAmount;

    @Column(name = "payment_due_date")
    private String paymentDueDate;

    @Column(name = "over_limit_Amount")
    private String overlimitAmount;

    @Column(name = "product_type")
    private String productType;
    
    @Column(name = "billing_Cycle_Date")
    private String billingCycleDate;
    
   

	@Column(name = "billing_Cycle_Day")
    private String billingCycleDay;

    @Column(name = "isptplive")
    private String isPTPLive;

    @Column(name = "is_settlement_live")
    private String isSettlementLive;

    @Column(name = "is_settlement_offer")
    private String isSettlementOffer;

    @Column(name = "subscribed_offer")
    private String subscribedOffer;

    //@Column(name = "notificationType")
    //private String notificationType;

    @Column(name = "npa_stage")
    private String npaStage;

    @Column(name = "eom")
    private String eom;

    @Column(name = "predue_flag")
    private String predueFlag;

    @Column(name = "dpd")
    private String dpd;

    @Column(name = "agrseq")
    private String agrseq;

    @Column(name = "blockCode1")
    private String blockCode1;

    @Column(name = "blockCode2")
    private String blockCode2;

    @Column(name = "IPP_Flag")
    private String ippFlag;

    
    public String getBillingCycleDate() {
		return billingCycleDate;
	}

	public void setBillingCycleDate(String billingCycleDate) {
		this.billingCycleDate = billingCycleDate;
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

	

	public String getFuture_due_amount() {
		return future_due_amount;
	}

	public void setFuture_due_amount(String future_due_amount) {
		this.future_due_amount = future_due_amount;
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

	public String getTotalOverdueAmount() {
		return totalOverdueAmount;
	}

	public void setTotalOverdueAmount(String totalOverdueAmount) {
		this.totalOverdueAmount = totalOverdueAmount;
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




   
}
