package br.com.sbs.cubatech.category;

import javax.persistence.EntityManager;

public class SubCategoryDao  {

    private final EntityManager entityManager;

    public SubCategoryDao(EntityManager entityManager) {
        this.entityManager = entityManager;

    }
    public SubCategory findByUrlCode(String urlCode){
        String jpql = "SELECT s FROM SubCategory s WHERE urlCode = :urlCode";
        return entityManager.createQuery(jpql, SubCategory.class)
                .setParameter("urlCode", urlCode)
                .getSingleResult();

    }
}
