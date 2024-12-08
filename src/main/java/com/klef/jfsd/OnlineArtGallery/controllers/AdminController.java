package com.klef.jfsd.OnlineArtGallery.controllers;

import com.klef.jfsd.OnlineArtGallery.models.Admin;
import com.klef.jfsd.OnlineArtGallery.models.ArtWork;
import com.klef.jfsd.OnlineArtGallery.models.Artist;
import com.klef.jfsd.OnlineArtGallery.models.Curator;
import com.klef.jfsd.OnlineArtGallery.models.Visitor;
import com.klef.jfsd.OnlineArtGallery.services.Adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = {"http://localhost:5173","https://imaginariumtheatre.vercel.app/"})
public class AdminController {

    @Autowired
    private Adminservice adminService;

    // Endpoint to add an artist
    @PostMapping("/artists")
    public void addArtist(@RequestBody Artist artist) {
        adminService.addArtist(artist);
    }

    // Endpoint to get all artists
    @GetMapping("/artists")
    public List<Artist> getAllArtists() {
        return adminService.getAllArtists();
    }

    // Endpoint to add an artwork
    @PostMapping("/artworks")
    public void addArt(@RequestBody ArtWork artWork) {
        adminService.addArt(artWork);
    }

    // Endpoint to get all artworks
    @GetMapping("/artworks")
    public List<ArtWork> getAllArtworks() {
        return adminService.getAllArtworks();
    }

    // Endpoint to remove an artwork
    @DeleteMapping("/artworks/{id}")
    public void removeArt(@PathVariable Integer id) {
        adminService.removeArt(id);
    }

    // Endpoint to add a curator
    @PostMapping("/curators")
    public void addCurator(@RequestBody Curator curator) {
        adminService.addCurator(curator);
    }

    // Endpoint to get all curators
    @GetMapping("/curators")
    public List<Curator> getAllCurators() {
        return adminService.getAllCurators();
    }

    // Endpoint to get all stats
    @GetMapping("/stats")
    public Map<String, Integer> getAllStats() {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("numberOfVisitors", adminService.getNumberOfVisitors());
        stats.put("numberOfArtworks", adminService.getNumberOfArtworks());
        stats.put("numberOfArtists", adminService.getNumberOfArtists());
        stats.put("numberOfCurators", adminService.getNumberOfCurators());
        return stats;
    }

    // Endpoint to delete an artist by ID
    @DeleteMapping("/artists/{id}")
    public void deleteArtist(@PathVariable Integer id) {
        adminService.deleteArtist(id);
    }

    // Endpoint to add a visitor
    @PostMapping("/visitors")
    public void addVisitor(@RequestBody Visitor visitor) {
        adminService.addVisitor(visitor);
    }
}