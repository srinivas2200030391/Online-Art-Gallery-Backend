package com.klef.jfsd.OnlineArtGallery.services;

import com.klef.jfsd.OnlineArtGallery.models.ArtWork;
import com.klef.jfsd.OnlineArtGallery.models.Visitor;
import com.klef.jfsd.OnlineArtGallery.repositories.ArtWorkRepo;
import com.klef.jfsd.OnlineArtGallery.repositories.VisitorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuratorService {

    @Autowired
    private ArtWorkRepo artWorkRepo;
    @Autowired
    private VisitorRepo visitorRepo;

    // Method to review an artwork
    public void reviewArtwork(Integer artworkId, String review) {
        ArtWork artWork = artWorkRepo.findById(artworkId).orElse(null);
        if (artWork != null) {
            // Implementation for reviewing the artwork
            System.out.println("Reviewing artwork: " + artWork.getTitle() + " - " + review);
        }
    }

    // Method to organize an exhibition
    public void organizeExhibition(String exhibitionName, List<ArtWork> artworks) {
        // Implementation for organizing an exhibition
        System.out.println("Organizing exhibition: " + exhibitionName);
        for (ArtWork artWork : artworks) {
            System.out.println("Including artwork: " + artWork.getTitle());
        }
    }

    // Method to get all artworks
    public List<ArtWork> getAllArtworks() {
        return artWorkRepo.findAll();
    }
    // Method to add a visitor
    public void addVisitor(Visitor visitor) {
        visitorRepo.save(visitor);
    }    public void addArtWork(ArtWork artWork) {
        artWorkRepo.save(artWork);
    }
}