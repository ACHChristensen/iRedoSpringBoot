package dk.iredo.marketplace.services;

import dk.iredo.marketplace.model.Listing;
import dk.iredo.marketplace.repository.ListingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingsService {

    @Autowired
    ListingsRepository listingsRepository;

    public List<Listing> getAll(){
        List<Listing> request = listingsRepository.findAll();
        return listingsRepository.findAll();
    }
}
