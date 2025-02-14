package com.collection.dcoreservices.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_DC_DCRNDTL")
public class DcrnDetailEntity {

    @Id
    @Column(name = "encryptedDcrnNo")
    private String encryptedDcrnNo;

    @Column(name = "dcrnNo")
    private String dcrnNo;

    @Column(name = "expiryFlag")
    private String expiryFlag;

    @Column(name = "productType")
    private String productType;

    @Column(name = "urlExpiryDate")
    private String urlExpiryDate;

    @Column(name = "status")
    private String status;

    @Column(name = "entity")
    private String entity;

    @Column(name = "notificationType")
    private String notificationType;

    @Column(name = "cif")
    private String cif;

    @Column(name = "acc_status")
    private String acc_status;
    
    @Column(name = "agrseq")
    private String agrseq;
    
    
    

    public String getAgrseq() {
		return agrseq;
	}

	public void setAgrseq(String agrseq) {
		this.agrseq = agrseq;
	}

	public String getEncryptedDcrnNo() {
        return encryptedDcrnNo;
    }

    public void setEncryptedDcrnNo(String encryptedDcrnNo) {
        this.encryptedDcrnNo = encryptedDcrnNo;
    }

    public String getDcrnNo() {
        return dcrnNo;
    }

    public void setDcrnNo(String dcrnNo) {
        this.dcrnNo = dcrnNo;
    }

    public String getExpiryFlag() {
        return expiryFlag;
    }

    public void setExpiryFlag(String expiryFlag) {
        this.expiryFlag = expiryFlag;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getUrlExpiryDate() {
        return urlExpiryDate;
    }

    public void setUrlExpiryDate(String urlExpiryDate) {
        this.urlExpiryDate = urlExpiryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getAcc_status() {
        return acc_status;
    }

    public void setAcc_status(String acc_status) {
        this.acc_status = acc_status;
    }

}
