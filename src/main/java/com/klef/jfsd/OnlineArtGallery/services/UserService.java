package com.klef.jfsd.OnlineArtGallery.services;

import com.klef.jfsd.OnlineArtGallery.models.*;
import com.klef.jfsd.OnlineArtGallery.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final AdminRepo adminRepo;
    private final CuratorRepo curatorRepo;
    private final ArtistRepo artistRepo;
    private final VisitorRepo visitorRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Check in each repository
        Admin admin = adminRepo.findAdminByUsername(username);
        if (admin != null) {
            return createUserDetails(admin.getUsername(), admin.getPassword(), "ADMIN");
        }

        Curator curator = curatorRepo.findCuratorByName(username);
        if (curator != null) {
            return createUserDetails(curator.getName(), curator.getPassword(), "CURATOR");
        }

        Artist artist = artistRepo.findArtistByUsername(username);
        if (artist != null) {
            return createUserDetails(artist.getUsername(), artist.getPassword(), "ARTIST");
        }

        Visitor visitor = visitorRepo.findVisitorByName(username);
        if (visitor != null) {
            return createUserDetails(visitor.getName(), visitor.getPassword(), "VISITOR");
        }

        throw new UsernameNotFoundException("User not found");
    }

    private UserDetails createUserDetails(String username, String password, String role) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return new User(username, password, authorities);
    }

    public Map<String, Object> getUserDetails(String username) {
        Map<String, Object> response = new HashMap<>();

        // Check in each repository
        Admin admin = adminRepo.findAdminByUsername(username);
        if (admin != null) {
            response.put("role", "ADMIN");
            response.put("user", admin);
            return response;
        }

        Curator curator = curatorRepo.findCuratorByName(username);
        if (curator != null) {
            response.put("role", "CURATOR");
            response.put("user", curator);
            return response;
        }

        Artist artist = artistRepo.findArtistByUsername(username);
        if (artist != null) {
            response.put("role", "ARTIST");
            response.put("user", artist);
            return response;
        }

        Visitor visitor = visitorRepo.findVisitorByName(username);
        if (visitor != null) {
            response.put("role", "VISITOR");
            response.put("user", visitor);
            return response;
        }

        return null;
    }
    public void createAdmin(String username, String password) {
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(new BCryptPasswordEncoder(5).encode(password));

        adminRepo.save(admin);
    }

    public void createVisitor(String username, String password) {
        Visitor visitor = new Visitor();
        visitor.setName(username);
        visitor.setPassword(new BCryptPasswordEncoder(5).encode(password));

        visitorRepo.save(visitor);
    }
}