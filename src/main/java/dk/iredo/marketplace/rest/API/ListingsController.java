package dk.iredo.marketplace.rest.API;

import dk.iredo.marketplace.rest.API.DTOs.ListingDto;
import dk.iredo.marketplace.rest.logic.ListingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dk.iredo.marketplace.rest.API.DTOs.ListingDtos.convertListToDTOList;

@RestController
@RequestMapping(path = ListingsController.listings)
@CrossOrigin // TODO - security
public class ListingsController {

    public static final String listings = "listings";

    @Autowired
    ListingsService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getWelcome(){
        return ResponseEntity.ok().body("Welcome to Listings API");
    }

    @GetMapping(path = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ListingDto>> getFromAllListings(){
        try {
            List<ListingDto> dtos = convertListToDTOList(service.getListings());
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
            //TODO write to loggs ??
        }
    }

}
