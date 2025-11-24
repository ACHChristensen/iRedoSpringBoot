package dk.iredo.marketplace.controller;

import dk.iredo.marketplace.dto.ListingDto;
import dk.iredo.marketplace.model.Listing;
import dk.iredo.marketplace.services.ListingsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = ListingsController.listings)
@CrossOrigin // TODO - security
public class ListingsController {

    public static final String listings = "listings";

    @Autowired
    ListingsService service;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/all")
    public ResponseEntity<String> getAllListings(){
        String hello  = "Hello World";
        return ResponseEntity.ok().body(hello);

    }


}
