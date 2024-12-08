package com.klef.jfsd.OnlineArtGallery.repositories;

import com.klef.jfsd.OnlineArtGallery.models.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepo extends JpaRepository<Visitor, Integer> {
    Visitor findVisitorByName(String username);
}
