package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.connection.ConnectionFactory;
import br.com.sbs.cubatech.course.CourseDao;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDaoCourseUpdate {

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection connection = connectionFactory.recoverConnection()) {
            CourseDao courseDao = new CourseDao(connection);
            courseDao.setPublicVisibilityToAllCourses();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
