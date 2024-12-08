package com.klef.jfsd.OnlineArtGallery.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "artworks")
@Component
public class ArtWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String artist;
    private Double price;

    // Constructors
    public ArtWork() {}

    public ArtWork(String title, String description, String artist, Double price) {
        this.title = title;
        this.description = description;
        this.artist = artist;
        this.price = price;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Methods for artwork tasks
    public void displayDetails() {
        // Implementation for displaying artwork details
        System.out.println("Title: " + title + ", Description: " + description + ", Artist: " + artist + ", Price: " + price);
    }
}