package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.category.SubCategoryDao;
import br.com.sbs.cubatech.connection.ConnectionFactory;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.course.CourseDao;
import br.com.sbs.cubatech.course.CourseVisibility;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteDaoCourseInsert {

    public static void main(String[] args){

        ConnectionFactory connectionFactory = new ConnectionFactory();

        try(Connection connection = connectionFactory.recoverConnection()) {

            SubCategoryDao subCategoryDao = new SubCategoryDao(connection);
            CourseDao courseDao = new CourseDao(connection);

            SubCategory subCategory = subCategoryDao.findByUrlCode("java");

            Course course = new Course("Angular CLI", "angular-cli", 20,
                    CourseVisibility.PRIVATE, "Alunos de Angular que querem conhecer mais sobre a CLI",
                    "Alvaro Camilo", "Conheça todos os comando da CLI do Angular. <br> - Saiba como funcionam as Workspaces no angular.json. <br> - Saiba como o Schematics pode aumentar sua produtividade <br> -",
                    "vira um gênio", subCategory);

            courseDao.save(course);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
