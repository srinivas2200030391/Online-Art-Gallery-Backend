package com.klef.jfsd.OnlineArtGallery.controllers;

import com.klef.jfsd.OnlineArtGallery.models.ArtWork;
import com.klef.jfsd.OnlineArtGallery.models.Artist;
import com.klef.jfsd.OnlineArtGallery.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
@CrossOrigin
public class ArtistController {

    @Autowired
    private ArtistService artistService;
    @Autowired
    private ArtWork artWork;

    // Endpoint to create a new artwork
    @PostMapping("/artworks")
    public String createArtwork(@RequestBody ArtWork artWork) {
        artistService.createArtwork(artWork);
        return "Artwork Added Successfully";
    }

    // Endpoint to update an existing artwork
    @PutMapping("/artworks")
    public void updateArtwork(@RequestBody ArtWork artWork) {
        artistService.updateArtwork(artWork);
    }

    // Endpoint to delete an artwork by ID
    @DeleteMapping("/artworks/{id}")
    public void deleteArtwork(@PathVariable Integer id) {
        artistService.deleteArtwork(id);
    }

    // Endpoint to get all artworks by an artist
    @GetMapping("/{artist}")
    public List<ArtWork> getArtworksByArtist(@PathVariable String artist) {
        return artistService.getArtworksByArtist(artist);
    }

    @GetMapping("/getarts")
    public List<ArtWork> getArtworks() {
        return artistService.getArtworks();
    }

    // Endpoint to get all artists
    @GetMapping("/getall")
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

    // Endpoint to add a new artist
    @PostMapping("/addartist")
    public void addArtist(@RequestBody Artist artist) {
        artistService.addArtist(artist);
    }

    // Endpoint to delete an artist by ID
    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable Integer id) {
        artistService.deleteArtist(id);
    }
}