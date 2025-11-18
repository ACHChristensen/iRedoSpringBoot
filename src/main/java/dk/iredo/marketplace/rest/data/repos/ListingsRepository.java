package dk.iredo.marketplace.rest.data.repos;

import dk.iredo.marketplace.rest.data.domain.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingsRepository extends JpaRepository<Listing, Integer> {

}