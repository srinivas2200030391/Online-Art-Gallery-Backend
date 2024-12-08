package com.klef.jfsd.OnlineArtGallery.controllers;

import com.klef.jfsd.OnlineArtGallery.models.ArtWork;
import com.klef.jfsd.OnlineArtGallery.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitors")
@CrossOrigin
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    // Endpoint to view all artworks
    @GetMapping("/artworks")
    public List<ArtWork> viewAllArtworks() {
        return visitorService.viewAllArtworks();
    }

    // Endpoint to view a specific artwork by ID
    @GetMapping("/artworks/{id}")
    public ArtWork viewArtworkById(@PathVariable Integer id) {
        return visitorService.viewArtworkById(id);
    }

    // Endpoint to view all exhibitions
    @GetMapping("/exhibitions")
    public List<String> viewAllExhibitions() {
        return visitorService.viewAllExhibitions();
    }
}