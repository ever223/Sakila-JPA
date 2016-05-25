package com.xg.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 12:48.
 * @DESCRIPTION:
 */


@Entity
@Table(name = "RENTAL")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rental implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RENTAL_ID")
    private int id;

    @Column(name = "RENTAL_DATE", nullable = false)
    private Date rentalDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "INVENTORY_ID", nullable = false)
    private Inventory inventory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @Column(name = "RETURN_DATE", nullable = true)
    private Date returnDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STAFF_ID", nullable = false)
    private Staff staff;

    @Column(name = "LAST_UPDATE", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
