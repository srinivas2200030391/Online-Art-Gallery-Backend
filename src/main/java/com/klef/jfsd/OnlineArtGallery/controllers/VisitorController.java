package com.klef.jfsd.OnlineArtGallery.controllers;

import com.klef.jfsd.OnlineArtGallery.models.ArtWork;
import com.klef.jfsd.OnlineArtGallery.models.EmailRequest;
import com.klef.jfsd.OnlineArtGallery.services.VisitorService;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/visitors")
@CrossOrigin(origins = {"http://localhost:5173","https://imaginariumtheatre.vercel.app/"})
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    // Endpoint to view all artworks
    @GetMapping("/artworks")
    public List<ArtWork> viewAllArtworks() {
        return visitorService.viewAllArtworks();
    }

    // Endpoint to view a specific artwork by ID
    @GetMapping("/artworks/{id}")
    public ArtWork viewArtworkById(@PathVariable Integer id) {
        return visitorService.viewArtworkById(id);
    }

    // Endpoint to view all exhibitions
    @GetMapping("/exhibitions")
    public List<String> viewAllExhibitions() {
        return visitorService.viewAllExhibitions();
    }

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/sendemail")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            System.out.println("Name: " + emailRequest.getName());
            System.out.println("To Email: " + emailRequest.getEmail());
            System.out.println("Subject: " + emailRequest.getSubject());
            System.out.println("Message: " + emailRequest.getMessage());

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            int otp = (int) (Math.random() * 99999); // Random OTP generation
            helper.setTo(emailRequest.getEmail());
            helper.setSubject(emailRequest.getSubject());
            helper.setFrom("vasus4990@gmail.com");

            String htmlContent =
                    "<h3>Contact Form Details</h3>" +
                            "<p><strong>Name:</strong> " + emailRequest.getName() + "</p>" +
                            "<p><strong>Email:</strong> " + emailRequest.getEmail() + "</p>" +
                            "<p><strong>Subject:</strong> " + emailRequest.getSubject() + "</p>" +
                            "<p><strong>Message:</strong> " + emailRequest.getMessage() + "</p>" +
                            "<p><strong>OTP:</strong> " + otp + "</p>";
            helper.setText(htmlContent, true);

            mailSender.send(mimeMessage);

            return "Mail Sent Success!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error while sending mail.";
        }
    }

}
