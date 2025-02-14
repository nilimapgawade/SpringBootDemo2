package com.collection.dcoreservices.dto;

public class DcrnDetailDto {

    private String cif;
    private String productType;
    private String expiryDate;
    private String status;
    private String entity;
    private String notificationType;

    
   

	public DcrnDetailDto() {
    }

    public DcrnDetailDto(String cif, String productType, String expiryDate, String status, String entity,String notificationType) {
        this.cif = cif;
        this.productType = productType;
        this.expiryDate = expiryDate;
        this.status = status;
        this.entity = entity;
        this.notificationType = notificationType;
    }




    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
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
}
