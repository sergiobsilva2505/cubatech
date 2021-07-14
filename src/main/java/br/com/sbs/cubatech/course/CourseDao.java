package br.com.sbs.cubatech.course;
import br.com.sbs.cubatech.connection.DaoException;
import br.com.sbs.cubatech.connection.UnitOfWork;

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

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                Long courseIdEntered = resultSet.getLong(1);
                System.out.println("The id created was -> " + courseIdEntered);
                course.setId(courseIdEntered);
            }

            this.connection.commit();

        }catch (SQLException e){
            try {
                this.connection.rollback();
                throw new DaoException("Could not save course", e);
            } catch (SQLException ex) {
                throw new RuntimeException("Unable to rollback", ex);
            }
        }
    }


    public void setPublicVisibilityToAllCourses() {

        String sqlUpdate = "UPDATE course SET courseVisibility  = 'PUBLIC';";
        SetaCursoParaPublico setaCursoParaPublico = new SetaCursoParaPublico();
        String errorMessage = "Unable to change visibility";

        UnitOfWork.doInTransaction(this.connection, sqlUpdate, setaCursoParaPublico, errorMessage);

//        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate)) {
//
//            this.connection.setAutoCommit(false);
//
//            preparedStatement.executeUpdate();
//            Integer modifiedLines = preparedStatement.getUpdateCount();
//            System.out.println("Number of lines that have been modified: " + modifiedLines);
//
//            this.connection.commit();
//        }catch (SQLException e){
//            try {
//                this.connection.rollback();
//                throw new DaoException("Unable to change visibility", e);
//            } catch (SQLException ex) {
//                throw new RuntimeException("Unable to rollback", ex);
//            }
//        }

    }


    public void deleteByUrlCode(String urlCode){

//        String sqlDelete = "DELETE FROM course WHERE urlCode = ? ";

        //DeletaCurso deletaCurso = new DeletaCurso(urlCode);

//        UnitOfWork deletaCurso = new UnitOfWork() {
//            @Override
//            public void doWithPreparedStatement(PreparedStatement preparedStatement) throws SQLException {
//                preparedStatement.setString(1, urlCode);
//
//                preparedStatement.execute();
//                Integer modifiedLines = preparedStatement.getUpdateCount();
//                System.out.println("Number of lines that have been modified: " + modifiedLines);
//            }
//        };

//        UnitOfWork deletaCurso = preparedStatement -> {
//            preparedStatement.setString(1, urlCode);
//
//            preparedStatement.execute();
//            Integer modifiedLines = preparedStatement.getUpdateCount();
//            System.out.println("Number of lines that have been modified: " + modifiedLines);
//        };


//        String errorMessage = "Could not remove course: " + urlCode;

        UnitOfWork.doInTransaction(this.connection,
                "DELETE FROM course WHERE urlCode = ? ",
                preparedStatement -> {
                    preparedStatement.setString(1, urlCode);

                    preparedStatement.execute();
                    Integer modifiedLines = preparedStatement.getUpdateCount();
                    System.out.println("Number of lines that have been modified: " + modifiedLines);
                },
                "Could not remove course: " + urlCode);

//        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)) {
//            this.connection.setAutoCommit(false);

//            preparedStatement.setString(1, urlCode);
//
//            preparedStatement.execute();
//            Integer modifiedLines = preparedStatement.getUpdateCount();
//            System.out.println("Number of lines that have been modified: " + modifiedLines);

//            this.connection.commit();
//        }catch (SQLException e){
//            try {
//                this.connection.rollback();
//                throw new RuntimeException("Could not remove course: " + urlCode, e);
//            } catch (SQLException ex) {
//                throw new RuntimeException("Unable to rollback", ex);
//            }
//        }
    }
}
