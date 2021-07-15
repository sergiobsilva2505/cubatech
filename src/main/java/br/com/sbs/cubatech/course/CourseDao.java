package br.com.sbs.cubatech.course;
import br.com.sbs.cubatech.connection.DaoException;

import java.sql.*;

public class CourseDao {

    private final Connection connection;

    public CourseDao(Connection connection){
        this.connection = connection;
    }


    public void save(Course course) {

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
            preparedStatement.setLong(9, course.getSubCategory().getId());

            preparedStatement.execute();
            this.connection.commit();


            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                Long courseIdEntered = resultSet.getLong(1);
                System.out.println("The id created was -> " + courseIdEntered);
                course.setId(courseIdEntered);
            }

        }catch (SQLException e){
            try {
                this.connection.rollback();
                throw new DaoException("Could not save course", e);
            } catch (SQLException ex) {
                throw new DaoException("Unable to rollback", ex);
            }
        }
    }


    public void setPublicVisibilityToAllCourses() {

        String sqlUpdate = "UPDATE course SET courseVisibility  = 'PUBLIC';";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate)) {

            this.connection.setAutoCommit(false);
            preparedStatement.executeUpdate();
            this.connection.commit();
            Integer modifiedLines = preparedStatement.getUpdateCount();
            System.out.println("Number of lines that have been modified: " + modifiedLines);
        }catch (SQLException e){
            try {
                this.connection.rollback();
                throw new DaoException("Unable to change visibility", e);
            } catch (SQLException ex) {
                throw new DaoException("Unable to rollback", ex);
            }
        }

    }


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
                throw new DaoException("Could not remove course: " + urlCode, e);
            } catch (SQLException ex) {
                throw new DaoException("Unable to rollback", ex);
            }
        }
    }


}
