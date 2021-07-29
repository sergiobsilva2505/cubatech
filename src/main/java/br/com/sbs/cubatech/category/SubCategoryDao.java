package br.com.sbs.cubatech.category;

import javax.persistence.EntityManager;
import java.util.List;

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

    public List<SubCategory> findAllByStatusActiveOrderByOrderInSystemAsc() {
        String jpql = "SELECT s FROM SubCategory s WHERE status = 'ACTIVE' ORDER BY orderInSystem";
        return entityManager.createQuery(jpql, SubCategory.class)
                .getResultList();
    }

    public List<SubCategory> findAllByDescriptionIsNullOrEmpty() {
        String jpql = "SELECT c FROM SubCategory c WHERE description = null or description = ''";
        return entityManager.createQuery(jpql, SubCategory.class)
                .getResultList();
    }
}
