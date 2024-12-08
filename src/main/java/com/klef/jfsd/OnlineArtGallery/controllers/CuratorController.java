package com.klef.jfsd.OnlineArtGallery.controllers;

import com.klef.jfsd.OnlineArtGallery.models.ArtWork;
import com.klef.jfsd.OnlineArtGallery.models.Visitor;
import com.klef.jfsd.OnlineArtGallery.services.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curators")
@CrossOrigin(origins = {"http://localhost:5173","https://imaginariumtheatre.vercel.app/"})
public class CuratorController {

    @Autowired
    private CuratorService curatorService;

    // Endpoint to review an artwork
    @PostMapping("/artworks/{id}/review")
    public void reviewArtwork(@PathVariable Integer id, @RequestBody String review) {
        curatorService.reviewArtwork(id, review);
    }

    // Endpoint to organize an exhibition
    @PostMapping("/exhibitions")
    public void organizeExhibition(@RequestParam String exhibitionName, @RequestBody List<ArtWork> artworks) {
        curatorService.organizeExhibition(exhibitionName, artworks);
    }

    // Endpoint to get all artworks
    @GetMapping("/artworks")
    public List<ArtWork> getAllArtworks() {
        return curatorService.getAllArtworks();
    }
    // Endpoint to add a visitor
    @PostMapping("/visitors")
    public void addVisitor(@RequestBody Visitor visitor) {
        curatorService.addVisitor(visitor);
    }

    @PostMapping("/arts")
    public void addArt(@RequestBody ArtWork artwork){
        curatorService.addArtWork(artwork);
    }
}