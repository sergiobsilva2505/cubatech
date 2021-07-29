package br.com.sbs.cubatech.category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDao {

    private final EntityManager entityManager;

    public CategoryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Category category){
        this.entityManager.persist(category);
    }

    public List<Category> findAllByStatusActiveOrderByOrderInSystemAsc()  {
        String jpql = "SELECT c FROM Category c WHERE c.status = 'ACTIVE' ORDER BY c.orderInSystem";
        return entityManager.createQuery(jpql, Category.class)
                .getResultList();
    }

    public  List<Category> findAll()  {
        String jpql = "SELECT c FROM Category c ";
        return entityManager.createQuery(jpql, Category.class)
                .getResultList();
    }

    public void update(Category transientCategory) {
        entityManager.merge(transientCategory);
    }

    public Category findById(Long id){
        return entityManager.find(Category.class, id);
    }


}
