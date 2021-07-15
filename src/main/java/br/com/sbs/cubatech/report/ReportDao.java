package br.com.sbs.cubatech.report;
import br.com.sbs.cubatech.connection.ConnectionFactory;
import br.com.sbs.cubatech.connection.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDao {

    private Connection connection;

    @Deprecated
    public ReportDao() {
    }

    public ReportDao(Connection connection){
        this.connection = connection;
    }

    public List<ReportDTO> getReportData() throws SQLException {

        String querySelect = "SELECT c.id CourseId, c.name CourseName, c.timeToFinishInHours TimeOfCourse, s.id SubCategoryId, s.name SubCategoryName " +
                "FROM  subCategory s, course c " +
                "WHERE c.courseVisibility = 'PUBLIC' AND c.subCategory_id = s.id " +
                "ORDER BY s.orderInSystem;";

        List<ReportDTO> reportDTOList = new ArrayList<>();

        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            this.connection = connectionFactory.recoverConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(querySelect);

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                long courseId = resultSet.getLong("CourseId");
                String courseName = resultSet.getString("CourseName");
                int duration = resultSet.getInt("TimeOfCourse");
                long subCategoryId = resultSet.getLong("SubCategoryId");
                String subCategoryName = resultSet.getString("SubCategoryName");
                reportDTOList.add(new ReportDTO(courseId, courseName, duration, subCategoryId, subCategoryName));
            }

        }catch (SQLException e){
            throw new DaoException(e.getMessage());
        }finally {
            connection.close();
        }
        return reportDTOList;
    }
}
