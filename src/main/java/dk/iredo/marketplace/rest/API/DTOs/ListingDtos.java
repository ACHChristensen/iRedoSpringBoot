package dk.iredo.marketplace.rest.API.DTOs;

import dk.iredo.marketplace.rest.data.domain.Listing;

import java.util.ArrayList;
import java.util.List;

public class ListingDtos {

    public static List<ListingDto> convertListToDTOList(List<Listing> listings) {
        List<ListingDto> dtos = new ArrayList<>();
        listings.forEach(listing -> {
            dtos.add(new ListingDto(listing));
        });
        return dtos;
    }

}