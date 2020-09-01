package org.ntnu.PentBruktService.Service;

import org.ntnu.PentBruktService.Domain.Listing;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.cdi.Transactional;
import java.util.List;

@Transactional
public class ListingService {

    // Persistence context keep track of the entity state
    // in the transaction with the database.
    @PersistenceContext
    public EntityManager entityManager;

    public void addListing(Listing listing){
        this.entityManager.persist(listing);
    }

    public List<Listing> getAllListings(){

        return this.entityManager.createQuery
                ("SELECT l from Listing l", Listing.class).getResultList();

    }

    public boolean removeListing(long listingId){
        Listing foundListing = this.entityManager.find(Listing.class, listingId);
        if (foundListing != null) {
            this.entityManager.remove(listingId);
            return true;
        } else {
            return false;
        }
    }
}
