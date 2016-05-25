package com.xg.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 13:02.
 * @DESCRIPTION:
 */

@Entity
@Table(name = "FILM")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Film implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "FILM_ID")
    private int id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "RELEASE_YEAR")
    //@JsonFormat(pattern = "yyyy")
    private java.sql.Date releaseYear;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LANGUAGE_ID", nullable = false)
    private Language language;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORIGINAL_LANGUAGE_ID")
    private Language originalLanguage;

    @Column(name = "RENTAL_DURATION")
    private int rentalDuration;

    @Column(name = "RENTAL_RATE", precision = 4, scale = 2)
    private Double rentalRate;

    @Column(name = "LENGTH")
    private int length;

    @Column(name = "REPLACEMENT_COST", nullable = false, precision = 5, scale = 2)
    private Double replacementCost;
//    private RatingType rating;

    @Column(name = "RATING")
    private String rating;

    @Column(name = "SPECIAL_FEATURES")
    private String specialFeatures;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "FILM_CATEGORY",
            joinColumns = {@JoinColumn(name = "FILM_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID")})
    private Set<Category> categories;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "FILM_ACTOR",
            joinColumns = {@JoinColumn(name = "FILM_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ACTOR_ID")})
    private Set<Actor> actors;

    @Column(name = "LAST_UPDATE")
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.sql.Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(java.sql.Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(Language originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
