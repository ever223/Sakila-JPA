package com.xg.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 12:58.
 * @DESCRIPTION:
 */

@Entity
@Table(name = "LANGUAGE")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Language implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "LANGUAGE_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_UPDATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
