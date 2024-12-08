package com.klef.jfsd.OnlineArtGallery.repositories;

import com.klef.jfsd.OnlineArtGallery.models.ArtWork;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtWorkRepo extends JpaRepository<ArtWork, Integer> {
    List<ArtWork> findArtWorkByArtist(String artistName);
}
