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

    public List<Category> getActiveCategory()  {
        String jpql = "SELECT c FROM Category c WHERE c.status = 'ACTIVE' ORDER BY c.orderInSystem";
        return entityManager.createQuery(jpql, Category.class)
                .getResultList();
    }

    public void setCategoryInactive(){
        List<Category> categories = getActiveCategory();
        for (Category category : categories) {
            String jpql = "UPDATE c FROM Category c WHERE id = :id";
            entityManager.createQuery(jpql, Category.class)
                    .setParameter("id", category.getId());
        }
    }

    public  List<Category> getAllCategories()  {
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
