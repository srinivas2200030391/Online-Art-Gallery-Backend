package com.klef.jfsd.OnlineArtGallery.services;

import com.klef.jfsd.OnlineArtGallery.models.Admin;
import com.klef.jfsd.OnlineArtGallery.models.ArtWork;
import com.klef.jfsd.OnlineArtGallery.models.Artist;
import com.klef.jfsd.OnlineArtGallery.models.Curator;
import com.klef.jfsd.OnlineArtGallery.models.Visitor;
import com.klef.jfsd.OnlineArtGallery.repositories.AdminRepo;
import com.klef.jfsd.OnlineArtGallery.repositories.ArtWorkRepo;
import com.klef.jfsd.OnlineArtGallery.repositories.ArtistRepo;
import com.klef.jfsd.OnlineArtGallery.repositories.CuratorRepo;
import com.klef.jfsd.OnlineArtGallery.repositories.VisitorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Adminservice {

    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private ArtWorkRepo artWorkRepo;
    @Autowired
    private ArtistRepo artistRepo;
    @Autowired
    private CuratorRepo curatorRepo;
    @Autowired
    private VisitorRepo visitorRepo;

    // Method to add an artist
    public void addArtist(Artist artist) {
        artist.setPassword(new BCryptPasswordEncoder(5).encode(artist.getPassword()));
        artistRepo.save(artist);
    }

    // Method to get all artists
    public List<Artist> getAllArtists() {
        return artistRepo.findAll();
    }

    // Method to add an artwork
    public void addArt(ArtWork artWork) {
        artWorkRepo.save(artWork);
    }

    // Method to get all artworks
    public List<ArtWork> getAllArtworks() {
        return artWorkRepo.findAll();
    }

    // Method to remove an artwork
    public void removeArt(Integer id) {
        artWorkRepo.deleteById(id);
    }

    // Method to add a curator
    public void addCurator(Curator curator) {
        curator.setPassword(new BCryptPasswordEncoder(5).encode(curator.getPassword()));
        curatorRepo.save(curator);
    }

    // Method to get all curators
    public List<Curator> getAllCurators() {
        return curatorRepo.findAll();
    }

    // Method to get the number of visitors
    public int getNumberOfVisitors() {
        return (int) visitorRepo.count();
    }

    // Method to get the number of artworks
    public int getNumberOfArtworks() {
        return (int) artWorkRepo.count();
    }

    // Method to get the number of artists
    public int getNumberOfArtists() {
        return (int) artistRepo.count();
    }

    // Method to get the number of curators
    public int getNumberOfCurators() {
        return (int) curatorRepo.count();
    }

    // Method to delete an artist by ID
    public void deleteArtist(Integer id) {
        artistRepo.deleteById(id);
    }

    // Method to add a visitor
    public void addVisitor(Visitor visitor) {
        visitor.setPassword(new BCryptPasswordEncoder(5).encode(visitor.getPassword()));
        visitorRepo.save(visitor);
    }
}