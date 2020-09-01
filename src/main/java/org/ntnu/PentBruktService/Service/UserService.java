package org.ntnu.PentBruktService.Service;

import org.ntnu.PentBruktService.Domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.cdi.Transactional;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class UserService {

    @PersistenceContext
    public EntityManager entityManager;

    public List<User> getAllUsers(){
        return this.entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();

    }

    public boolean registerUser(User user){
        this.entityManager.persist(user);
        User foundUser = this.entityManager.find(User.class, user.getId());
        return foundUser != null;
    }

    public boolean login(String email, String password){
        Query query = this.entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email AND u.password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        if (query.getSingleResult() != null) {
            return true;
        } else{
            return false;
        }
    }

}
