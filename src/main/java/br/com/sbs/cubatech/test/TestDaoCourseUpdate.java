package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.course.CourseDao;
import br.com.sbs.cubatech.util.JPAUtil;

import javax.persistence.EntityManager;

public class TestDaoCourseUpdate {

    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        CourseDao courseDao = new CourseDao(entityManager);

        entityManager.getTransaction().begin();
        courseDao.setPublicVisibilityToAllCourses();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
