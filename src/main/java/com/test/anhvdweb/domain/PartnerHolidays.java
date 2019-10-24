package com.test.anhvdweb.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PARTNER_HOLIDAY")
public class PartnerHolidays implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PARTNER_ID")
    private Integer partnerId;

    @Column(name = "BUSINESS_DATE")
    private String businessDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }
}
