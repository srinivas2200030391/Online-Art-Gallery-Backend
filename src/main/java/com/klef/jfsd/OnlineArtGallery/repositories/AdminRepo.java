package com.klef.jfsd.OnlineArtGallery.repositories;

import com.klef.jfsd.OnlineArtGallery.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
    Admin findAdminByUsername(String username);
}
