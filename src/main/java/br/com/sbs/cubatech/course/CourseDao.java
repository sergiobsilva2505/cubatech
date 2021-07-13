package br.com.sbs.cubatech.course;
import br.com.sbs.cubatech.connection.Dao;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class CourseDao implements Dao<Course> {

    private Connection connection;

    public CourseDao(Connection connection){
        this.connection = connection;
    }

    @Override
    public void save(Course course) throws SQLException {
        Integer courseIdEntered;
        Integer subCategoryId = null;
        String sqlSelect = String.format("SELECT id FROM subCategory WHERE urlCode =  '%s' " , course.getSubCategory().getUrlCode());

        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect)){
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                subCategoryId = resultSet.getInt( "id");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        String sqlInsert = "INSERT INTO course (name, urlCode, timeToFinishInHours, targetAudience, courseVisibility, instructor, summary, skillsDeveloped, subCategory_id ) " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)){

            this.connection.setAutoCommit(false);
            preparedStatement.setString(1, course.getName());
            preparedStatement.setString(2, course.getUrlCode());
            preparedStatement.setInt(3, course.getTimeToFinishInHours());
            preparedStatement.setString(4, course.getTargetAudience());
            preparedStatement.setString(5, String.valueOf(course.getCourseVisibility()));
            preparedStatement.setString(6, course.getInstructor());
            preparedStatement.setString(7, course.getSummary());
            preparedStatement.setString(8, course.getSkillsDeveloped());
            preparedStatement.setInt(9, subCategoryId);

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                courseIdEntered = resultSet.getInt(1);
                System.out.println("The id created was -> " + courseIdEntered);
            }

            preparedStatement.execute();
            this.connection.commit();


        }catch (SQLException e){
            e.printStackTrace();
            this.connection.rollback();
        }

    }

    @Override
    public void update(Course course) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
