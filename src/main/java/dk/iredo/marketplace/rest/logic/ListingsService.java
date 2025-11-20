package dk.iredo.marketplace.rest.logic;

import dk.iredo.marketplace.rest.data.domain.Listing;
import dk.iredo.marketplace.rest.data.repos.ListingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingsService {

    @Autowired
    ListingsRepository listingsRepository;

    public List<Listing> getListings(){
            return listingsRepository.findAll();
    }
}
