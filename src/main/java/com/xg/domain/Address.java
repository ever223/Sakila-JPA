package com.xg.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 12:24.
 * @DESCRIPTION:
 */
@Entity
@Table(name = "ADDRESS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESS_ID")
    private int id;

    @Column(name = "ADDRESS", nullable = false, length = 50)
    private String address;

    @Column(name = "ADDRESS2", nullable = true, length = 50)
    private String address2;

    @Column(name = "DISTRICT", nullable = false, length = 20)
    private String district;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CITY_ID")
    private City city;

    @Column(name = "POSTAL_CODE", nullable = false, length = 10)
    private String postalCode;

    @Column(name = "PHONE", nullable = false, length = 20)
    private String phone;

    @Column(name = "LAST_UPDATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
