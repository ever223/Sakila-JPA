package com.xg.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 12:28.
 * @DESCRIPTION:
 */
@Entity
@Table(name = "CUSTOMER")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "STORE_ID", nullable = false)
    private Store store;

    @Column(name = "FIRST_NAME", length = 45, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 45, nullable = false)
    private String lastName;

    @Column(name = "EMAIL", length = 50)
    private String email = null;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", nullable = false)
    private Address address;

    @Column(name = "ACTIVE", nullable = false)
    private boolean active = true;

    @Column(name = "CREATE_DATE", nullable = false)
    private Timestamp createDate;

    @Column(name = "LAST_UPDATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
