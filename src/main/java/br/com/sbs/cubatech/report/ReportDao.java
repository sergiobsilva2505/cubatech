package br.com.sbs.cubatech.report;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ReportDao {

    private EntityManager entityManager = JPAUtil.getEntityManager();

    @Deprecated
    public ReportDao() {
    }

    public List<Category> getActiveCategory()  {
        String jpql = "SELECT c FROM Category c WHERE c.status = 'ACTIVE' ORDER BY c.orderInSystem";
        return entityManager.createQuery(jpql, Category.class)
                .getResultList();
    }

    public List<SubCategory> getActiveSubCategory() {
        String jpql = "SELECT s FROM SubCategory s WHERE status = 'ACTIVE' ORDER BY orderInSystem";
        return entityManager.createQuery(jpql, SubCategory.class)
                .getResultList();
    }

    public List<Course> getPublicCourse() {
        String jpql = "SELECT c FROM Course c WHERE courseVisibility = 'PUBLIC'";
        return entityManager.createQuery(jpql, Course.class)
                .getResultList();
    }

    public List<SubCategory> getSubCategoryDescriptionNull() {
        String jpql = "SELECT c FROM SubCategory c WHERE description = null or description = ''";
        return entityManager.createQuery(jpql, SubCategory.class)
                .getResultList();
    }
}
