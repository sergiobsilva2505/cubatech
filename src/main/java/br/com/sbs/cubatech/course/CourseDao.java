package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.category.SubCategory;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseDao {

    private EntityManager entityManager;

    public CourseDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(Course course){
        this.entityManager.persist(course);
    }

    public void setPublicVisibilityToAllCourses(CourseVisibility courseVisibility) {
        String jpql = "UPDATE Course c SET c.courseVisibility = :courseVisibility";
        List<Course> courses = entityManager.createQuery(jpql, Course.class)
                .setParameter("courseVisibility", courseVisibility)
                .getResultList();
    }

    public void deleteByUrlCode(String urlCode){
        String jpql = "SELECT c FROM Course c WHERE urlCode = :urlCode";
        Course course = entityManager.createQuery(jpql, Course.class)
                .setParameter("urlCode", urlCode)
                .getSingleResult();
        entityManager.remove(course);
    }


}
