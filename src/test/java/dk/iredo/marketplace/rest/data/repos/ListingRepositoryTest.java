package dk.iredo.marketplace.rest.data.repos;

import dk.iredo.marketplace.rest.data.domain.Listing;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(
        locations = "classpath:testApplication.properties")
class ListingRepositoryTest{

    @Autowired
    private ListingsRepository listingsRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        listingsRepository.deleteAll();
    }

    //Negative tests
    @Test
    @Transactional
    void addListingToNoneUser() {
        Listing listing = new Listing(12.00, 2,0,2,null,1,"Disse er til salg");
        assertThrows(Exception.class,
                () -> listingsRepository.save(listing)
        );
    } // TODO - Makes no exception - functionality needed to make this not possible

}