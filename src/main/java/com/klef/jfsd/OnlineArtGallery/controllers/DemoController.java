package com.klef.jfsd.OnlineArtGallery.controllers;

import com.klef.jfsd.OnlineArtGallery.security.JwtService;
import com.klef.jfsd.OnlineArtGallery.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:5173","https://imaginariumtheatre.vercel.app/"})
public class DemoController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/")
    public String home() {
        return "Welcome to the Online Art Gallery";
    }
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String password = payload.get("password");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        try {
            // First authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            System.out.println("YES");
            // If authentication successful, get user details
            Map<String, Object> userDetails = userService.getUserDetails(username);

            if (userDetails != null) {
                UserDetails user = (UserDetails) authentication.getPrincipal();
                String role = (String) userDetails.get("role");
                String jwt = jwtService.generateToken(user, role);

                Map<String, Object> response = new HashMap<>();
                response.put("token", jwt);
                response.put("user", userDetails);

                return ResponseEntity.ok(response);
            }

            return ResponseEntity.badRequest().body("User details not found");

        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String password = payload.get("password");

        try {
            userService.createVisitor(username, password);
            return ResponseEntity.ok("Visitor created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating admin: " + e.getMessage());
        }
    }
    @PostMapping("/signup-admin")
    public ResponseEntity<?> signUpAdmin(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String password = payload.get("password");

        try {
            userService.createAdmin(username, password);
            return ResponseEntity.ok("Visitor created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating admin: " + e.getMessage());
        }
    }
}