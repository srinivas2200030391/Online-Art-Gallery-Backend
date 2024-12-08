package com.klef.jfsd.OnlineArtGallery.services;

import com.klef.jfsd.OnlineArtGallery.models.Artist;
import com.klef.jfsd.OnlineArtGallery.models.ArtWork;
import com.klef.jfsd.OnlineArtGallery.repositories.ArtistRepo;
import com.klef.jfsd.OnlineArtGallery.repositories.ArtWorkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepo artistRepo;

    @Autowired
    private ArtWorkRepo artWorkRepo;

    // Method to create a new artwork
    public void createArtwork(ArtWork artWork) {
        artWorkRepo.save(artWork);
    }

    // Method to update an existing artwork
    public void updateArtwork(ArtWork artWork) {
        artWorkRepo.save(artWork);
    }

    // Method to delete an artwork by ID
    public void deleteArtwork(Integer id) {
        artWorkRepo.deleteById(id);
    }

    // Method to get all artworks by an artist
    public List<ArtWork> getArtworksByArtist(String artistName) {
        return artWorkRepo.findArtWorkByArtist(artistName);
    }

    public List<ArtWork> getArtworks() {
        return artWorkRepo.findAll();
    }
    // Method to get all artists
    public List<Artist> getAllArtists() {
        return artistRepo.findAll();
    }

    // Method to add a new artist
    public void addArtist(Artist artist) {
        artistRepo.save(artist);
    }

    // Method to delete an artist by ID
    public void deleteArtist(Integer id) {
        artistRepo.deleteById(id);
    }
}