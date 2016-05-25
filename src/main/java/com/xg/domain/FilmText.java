package com.xg.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 13:03.
 * @DESCRIPTION:
 */

@Entity
@Table(name = "FILM_TEXT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmText implements Serializable {

    @Id
    @Column(name = "FILM_ID")
    private int id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "LAST_UPDATE", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
