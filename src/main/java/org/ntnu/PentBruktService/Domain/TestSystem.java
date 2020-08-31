package org.ntnu.PentBruktService.Domain;

import javax.persistence.*;
import java.util.List;

public class TestSystem {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY
            = Persistence.createEntityManagerFactory
            ("PentBruktService");

    public static void main(String[] args) {
        addItem(1L, "Iphone X", "Godt brukt", 2500, "31.08.2020");
        addItem(2L, "Fiskestang", "Lite brukt", 500, "01.09.2020");
        addItem(3L, "Samsung TV", "Helt ny", 8000, "02.09.2020");
        addItem(4L, "Macbook Pro", "Godt brukt", 5000, "03.09.2020");

        getItem(1);
        getAllItems();
        changeItemDesc(4L, "Veeeeldig godt brukt");
        deleteItem(2L);

        ENTITY_MANAGER_FACTORY.close();

    }

    public static void getItem(long id) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT item FROM Item item WHERE item.itemId = :itemID";

        TypedQuery<Item> typedQuery = entityManager.createQuery(query, Item.class);
        typedQuery.setParameter("itemID", id);
        Item item = null;
        try {
            item = typedQuery.getSingleResult();
            System.out.println(item.getItemName());
        } catch (NoResultException exception) {
            exception.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    public static void getAllItems() {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT item FROM Item item WHERE item.itemId = :itemID";

        TypedQuery<Item> typedQuery = entityManager.createQuery(query, Item.class);
        List<Item> items;
        try{

            items = typedQuery.getResultList();
            items.forEach(item -> System.out.println(item.getItemName()));
        }catch (NoResultException exception) {
            exception.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    public static void addItem(long id, String itemName, String desc,
                               int price, String published) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Item item = new Item();
            item.setItemId(id);
            item.setItemName(itemName);
            item.setDesc(desc);
            item.setPrice(price);
            item.setPublished(published);

            entityManager.persist(item);
            entityTransaction.commit();

        } catch (Exception exception) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            exception.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static void changeItemDesc(long id, String newDesc) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        Item item = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            item = entityManager.find(Item.class, id);
            item.setDesc(newDesc);


            entityManager.persist(item);
            entityTransaction.commit();

        } catch (Exception exception) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            exception.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static void deleteItem(long id) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        Item item = new Item();
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            item = entityManager.find(Item.class, id);
            entityManager.remove(item);

            entityTransaction.commit();

        } catch (Exception exception) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            exception.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

}

