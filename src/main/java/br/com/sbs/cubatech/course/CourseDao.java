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
    public void save(Course course) {

        Integer subCategoryId = null;
        String sqlSelect = "SELECT id FROM subCategory WHERE urlCode =  ? " ;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect)){
            preparedStatement.setString(1, course.getSubCategory().getUrlCode());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                subCategoryId = resultSet.getInt( "id");
            } else {
                throw new RuntimeException("nova mensagem"); // todo DAO execption
            }
        }catch (SQLException e){
            throw new RuntimeException("nova mensagem"); // todo DAO execption
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

            preparedStatement.execute();
            this.connection.commit();


            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                Long courseIdEntered = resultSet.getLong(1);
                System.out.println("The id created was -> " + courseIdEntered);
                course.setId(courseIdEntered);
            }

        }catch (SQLException e ){
            try {
                this.connection.rollback();
                throw new RuntimeException("nova mensagem"); // todo DAO execption
            } catch (SQLException throwables) {
                throw new RuntimeException("nova mensagem"); // todo DAO execption
            }
        }
    }

    @Override
    public void update(Course course) {

        String sqlUpdate = "UPDATE course SET courseVisibility  = 'PUBLIC';";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate)) {

            this.connection.setAutoCommit(false);
            preparedStatement.executeUpdate();
            this.connection.commit();
            Integer modifiedLines = preparedStatement.getUpdateCount();
            System.out.println("Number of lines that have been modified: " + modifiedLines);
        }catch (SQLException e){
            e.printStackTrace();
            // todo a mesma correção do insert e do upodate
        }

    }

    @Override
    public void deleteByUrlCode(String  urlCode){

        String sqlDelete = "DELETE FROM course WHERE urlCode = ? ";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)) {
            preparedStatement.setString(1, urlCode);
            this.connection.setAutoCommit(false);
            preparedStatement.execute();
            this.connection.commit();
            Integer modifiedLines = preparedStatement.getUpdateCount();
            System.out.println("Number of lines that have been modified: " + modifiedLines);
        }catch (SQLException e){
            try {
                this.connection.rollback();
                throw new RuntimeException("nova mensagem"); // todo DAO execption
            } catch (SQLException throwables) {
                throw new RuntimeException("nova mensagem"); // todo DAO execption
            }
        }
    }
}
