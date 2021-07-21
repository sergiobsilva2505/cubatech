package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.course.CourseDao;
import br.com.sbs.cubatech.util.JPAUtil;

import javax.persistence.EntityManager;

public class TestDaoCourseDelete {

    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.getEntityManager();
        CourseDao courseDao = new CourseDao(entityManager);

        entityManager.getTransaction().begin();
        Course course = courseDao.findByUrlCode("angular-cli");
        courseDao.delete(course);
        entityManager.getTransaction().commit();

        entityManager.close();

    }

}
