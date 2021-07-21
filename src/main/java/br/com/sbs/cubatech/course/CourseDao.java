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

    public void setPublicVisibilityToAllCourses() {
        String jpql = "UPDATE Course c SET c.courseVisibility = :courseVisibility";
        entityManager.createQuery(jpql)
                .setParameter("courseVisibility", CourseVisibility.PUBLIC)
                .executeUpdate();
    }

    public void delete(Course course){
        entityManager.remove(course);
    }

    public Course findByUrlCode(String urlCode){
        String jpql = "SELECT c FROM Course c WHERE urlCode = :urlCode";
        Course course = entityManager.createQuery(jpql, Course.class)
                .setParameter("urlCode", urlCode)
                .getSingleResult();
        return  course;
    }

    public List<Course> getPublicCourse() {
        String jpql = "SELECT c FROM Course c WHERE courseVisibility = 'PUBLIC'";
        return entityManager.createQuery(jpql, Course.class)
                .getResultList();
    }




}
