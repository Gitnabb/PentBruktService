package org.ntnu.PentBruktService.Service;

import org.ntnu.PentBruktService.Domain.Listing;
import org.ntnu.PentBruktService.Domain.Purchase;
import org.ntnu.PentBruktService.Domain.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.cdi.Transactional;
import java.util.List;

@Transactional
public class PurchaseService {

    @PersistenceContext
    public EntityManager entityManager;

    public List<Purchase> getAllPurchases(){
        return this.entityManager.createQuery("select p from Purchase p", Purchase.class).getResultList();
    }

    public boolean registerPurchase (Purchase purchase){
        User purchaser = this.entityManager.find(User.class, purchase.getUserId());
        Listing product = this.entityManager.find(Listing.class, purchase.getProductId());

        if(purchaser != null && product != null){
            this.entityManager.persist(purchase);
            return true;
        } else {
            return false;
        }
    }


}
