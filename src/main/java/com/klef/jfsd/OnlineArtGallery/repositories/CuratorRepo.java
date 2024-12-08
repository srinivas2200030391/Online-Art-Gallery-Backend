package com.klef.jfsd.OnlineArtGallery.repositories;

import com.klef.jfsd.OnlineArtGallery.models.Curator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuratorRepo extends JpaRepository<Curator, Integer> {
    Curator findCuratorByName(String username);
}
