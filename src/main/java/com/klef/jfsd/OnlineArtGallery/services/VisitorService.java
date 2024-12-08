package com.klef.jfsd.OnlineArtGallery.services;

import com.klef.jfsd.OnlineArtGallery.models.ArtWork;
import com.klef.jfsd.OnlineArtGallery.repositories.ArtWorkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {

    @Autowired
    private ArtWorkRepo artWorkRepo;

    // Method to view all artworks
    public List<ArtWork> viewAllArtworks() {
        return artWorkRepo.findAll();
    }

    // Method to view a specific artwork by ID
    public ArtWork viewArtworkById(Integer id) {
        return artWorkRepo.findById(id).orElse(null);
    }

    // Method to view all exhibitions
    public List<String> viewAllExhibitions() {
        // Assuming there is a method to get all exhibition names
        // This is a placeholder implementation
        return List.of("Exhibition 1", "Exhibition 2", "Exhibition 3");
    }

}