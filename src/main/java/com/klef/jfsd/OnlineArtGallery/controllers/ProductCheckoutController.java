package com.klef.jfsd.OnlineArtGallery.controllers;

import com.klef.jfsd.OnlineArtGallery.models.ProductRequest;
import com.klef.jfsd.OnlineArtGallery.models.StripeResponse;
import com.klef.jfsd.OnlineArtGallery.services.StripeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/v1")

@CrossOrigin(origins = {"http://localhost:5173","https://imaginariumtheatre.vercel.app/"})
public class ProductCheckoutController {


    private StripeService stripeService;

    public ProductCheckoutController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<StripeResponse> checkoutProducts(@RequestBody ProductRequest productRequest) {
        StripeResponse stripeResponse = stripeService.checkoutProducts(productRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(stripeResponse);
    }
}