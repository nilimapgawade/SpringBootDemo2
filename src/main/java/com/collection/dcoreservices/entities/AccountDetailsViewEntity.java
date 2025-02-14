package com.collection.dcoreservices.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_DC_GETACCOUNTDETAILS")
public class AccountDetailsViewEntity {

	 @Id
	    @Column(name = "agrseq")
	    private String agrseq;
	    
	    @Column(name = "loan_acc_number")
	    private String loanAccNumber;  // loanAccNumber

	    @Column(name = "first_name")
	    private String firstName;  // firstName

	    @Column(name = "full_name")
	    private String fullName;  // fullName

	    @Column(name = "cif")
	    private String cif;  // cif

	     @Column(name = "finance_amount")
	     private String financeAmount;  // financeAmount

	   

		@Column(name = "total_outstanding_balance")
	    private String totalOutstandingBalance;  // totalOutstandingBalance

	    @Column(name = "future_due_amount")
	    private String totalDueAmount;  // totalDueAmount

	     @Column(name = "installment_amount")
	     private String installmentAmount;  // installmentAmount

	   

		@Column(name = "total_principle_amount")
	    private String totalPrincipleAmount;  // totalPrincipleAmount

	    @Column(name = "total_overdue_amount")
	    private String totalOverdueAmount;  // totalOverdueAmount

	    @Column(name = "payment_due_date")
	    private String paymentDueDate;  // paymentDueDate (Unix Timestamp)

	    @Column(name = "product_type")
	    private String productType;  // productType (Map to CPORTFOLIOCODE)

	    @Column(name = "isptplive")
	    private String isPTPLive;  // isPTPLive

	    @Column(name = "is_settlement_live")
	    private String isSettlementLive;  // isSettlementLive

	    @Column(name = "billing_Cycle_Day")
	    private String billingCycleDay;  // isSettlementLive

	    @Column(name = "is_settlement_offer")
	    private String isSettlementOffer;  // isSettlementOffer (Y/N)

	    @Column(name = "subscribed_offer")
	    private String subscribedOffer;  // subscribedOffer

	  
	    @Column(name = "npa_stage")
	    private String npaStage;  // npaStage (WO for Write-Off)

	    @Column(name = "eom")
	    private String eom;  // eom (Unix Timestamp)

	    @Column(name = "predue_flag")
	    private String predueFlag;  // predueFlag

	    @Column(name = "dpd")
	    private String dpd;  // dpd (Days Past Due)

	    
	    
	    public String getBillingCycleDay() {
			return billingCycleDay;
		}

		public void setBillingCycleDay(String billingCycleDay) {
			this.billingCycleDay = billingCycleDay;
		}

		public String getInstallmentAmount() {
			return installmentAmount;
		}

		public void setInstallmentAmount(String installmentAmount) {
			this.installmentAmount = installmentAmount;
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

		public String getTotalOutstandingBalance() {
			return totalOutstandingBalance;
		}

		public void setTotalOutstandingBalance(String totalOutstandingBalance) {
			this.totalOutstandingBalance = totalOutstandingBalance;
		}

		public String getTotalDueAmount() {
			return totalDueAmount;
		}

		public void setTotalDueAmount(String totalDueAmount) {
			this.totalDueAmount = totalDueAmount;
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


		 public String getFinanceAmount() {
				return financeAmount;
			}

			public void setFinanceAmount(String financeAmount) {
				this.financeAmount = financeAmount;
			}
	
	
}
