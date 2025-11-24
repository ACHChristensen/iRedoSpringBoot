package dk.iredo.marketplace.repository;

import dk.iredo.marketplace.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingsRepository extends JpaRepository<Listing, Integer> {

}