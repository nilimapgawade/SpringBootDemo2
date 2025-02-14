package com.collection.dcoreservices.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="Col_Trn_Mail")
public class CheckDcrnEntity {

	@Id
    @Column(name = "IMAILSEQNO") // Assuming IMAILSEQNO is the primary key
    private Long imailSeqNo;

    @Column(name = "SZENCRYPTEDDCRNNO")
    private String encryptedDcrnNo;

    @Column(name = "dturlexpiry")
    private LocalDate dturlexpiry;
    
    public LocalDate getDturlexpiry() {
		return dturlexpiry;
	}

	public void setDturlexpiry(LocalDate dturlexpiry) {
		this.dturlexpiry = dturlexpiry;
	}

	// Getter and Setter for encryptedDcrnNo
    public String getEncryptedDcrnNo() {
        return encryptedDcrnNo;
    }

    public void setEncryptedDcrnNo(String encryptedDcrnNo) {
        this.encryptedDcrnNo = encryptedDcrnNo;
    }

    // Getter and Setter for imailSeqNo (Primary Key)
    public Long getImailSeqNo() {
        return imailSeqNo;
    }

    public void setImailSeqNo(Long imailSeqNo) {
        this.imailSeqNo = imailSeqNo;
    }
}
