package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.connection.ConnectionFactory;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.course.CourseDao;
import br.com.sbs.cubatech.course.CourseVisibility;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDaoCourseUpdate {

    public static void main(String[] args) {
        Category category = new Category("Programação", "programacao", 1, "Programe nas principais linguagens e plataformas. Iniciantes são bem vindos nos cursos de lógica e JavaScript.", Status.ACTIVE, "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png", "#00c86f");
        SubCategory subCategory = new SubCategory("Java", "java", 1, "Java é uma grande plataforma presente em todo lugar: de corporações à bancos e governo. Desenvolva aplicações robustas com um back-end e construa APIs.", Status.ACTIVE, category);
        Course course = new Course("Angular CLI", "angular-cli", 20, CourseVisibility.PRIVATE, "Alunos de Angular que querem conhecer mais sobre a CLI", "Alvaro Camilo", "Conheça todos os comando da CLI do Angular. <br> - Saiba como funcionam as Workspaces no angular.json. <br> - Saiba como o Schematics pode aumentar sua produtividade <br> -", "vira um gênio", subCategory);

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection connection = connectionFactory.recoverConnection()) {
            CourseDao courseDao = new CourseDao(connection);
            courseDao.update(course);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
