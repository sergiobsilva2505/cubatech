package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.category.SubCategoryDao;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.course.CourseDao;
import br.com.sbs.cubatech.course.CourseVisibility;
import br.com.sbs.cubatech.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteDaoCourseInsert {

    public static void main(String[] args){

        EntityManager entityManager = JPAUtil.getEntityManager();
        SubCategoryDao subCategoryDao = new SubCategoryDao(entityManager);
        CourseDao courseDao = new CourseDao(entityManager);

        SubCategory subCategory = subCategoryDao.findByUrlCode("java");

        Course course = new Course(
                "Angular CLI",
                "angular-cli",
                20,
                CourseVisibility.PRIVATE,
                "Alunos de Angular que querem conhecer mais sobre a CLI",
                "Alvaro Camilo",
                "Conheça todos os comando da CLI do Angular. <br> - Saiba como funcionam as Workspaces no angular.json. <br> - Saiba como o Schematics pode aumentar sua produtividade <br> -",
                "vira um gênio", subCategory);
        entityManager.getTransaction().begin();
//        courseDao.save(course);
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
