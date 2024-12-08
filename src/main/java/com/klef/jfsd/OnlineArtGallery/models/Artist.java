package com.klef.jfsd.OnlineArtGallery.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "artists")
@Component
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String bio;
    private String username; // Add this field
    private String password;

    // Constructors
    public Artist() {}

    public Artist(String name, String bio, String username, String password) {
        this.name = name;
        this.bio = bio;
        this.username = username; // Add this field
        this.password = password;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Methods for artist tasks
    public void createArtwork() {
        // Implementation for creating artwork
    }

    public void updateArtwork() {
        // Implementation for updating artwork
    }

    public void deleteArtwork() {
        // Implementation for deleting artwork
    }
}