package br.com.sbs.cubatech.category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDao {

    private final EntityManager entityManager;

    public CategoryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Category> getActiveCategory()  {
        String jpql = "SELECT c FROM Category c WHERE c.status = 'ACTIVE' ORDER BY c.orderInSystem";
        return entityManager.createQuery(jpql, Category.class)
                .getResultList();
    }

    public  List<Category> getAllCategories()  {
        String jpql = "SELECT c FROM Category c ";
        return entityManager.createQuery(jpql, Category.class)
                .getResultList();
    }
}
