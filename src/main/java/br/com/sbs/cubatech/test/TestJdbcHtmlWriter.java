package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.connection.ConnectionFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJdbcHtmlWriter {

    public static void main(String[] args) throws SQLException, IOException {

        Connection connection = null;
        BufferedWriter bufferedWriter = null;
        String htmlPageCode = null;
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connection = connectionFactory.recoverConnection();

            String outPutFile = "relatorio.html";
            bufferedWriter = new BufferedWriter(new FileWriter(outPutFile));

            String querySelect = "SELECT c.id AS CourseId, c.name AS CourseName, s.id AS SubCategoryId, s.name AS SubCategoryName " +
                    "FROM  subCategory AS s, course AS c " +
                    "WHERE c.courseVisibility = 'PUBLIC' AND c.subCategory_id = s.id " +
                    "ORDER BY s.orderInSystem;";

            PreparedStatement preparedStatement = connection.prepareStatement(querySelect);

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            String tableRowResult = "";

            while (resultSet.next()){
                Integer courseId = resultSet.getInt( "CourseId");
                String courseName = resultSet.getString("CourseName");
                Integer subCategoryId = resultSet.getInt("SubCategoryId");
                String subCategoryName = resultSet.getString("SubCategoryName");

                tableRowResult += String.format("""
                        <tr>
                            <td>%d</td>
                            <td>%s</td>
                            <td>%d</td>
                            <td>%s</td>
                        </tr>    
                        """, courseId, courseName, subCategoryId, subCategoryName);
            }

            htmlPageCode = String.format("""
                    <!DOCTYPE html>
                    <html lang="pt">
                    <head>
                        <meta charset="UTF-8">
                        <title>Cubatech DB - Relatório</title>
                        <link rel="stylesheet" href="style.css">
                    </head>
                    <body>
                    <br><br>
                        <table>
                            <tr>
                              <th>Course ID</th>
                              <th>Course Name</th>
                              <th>SubCategory ID</th>
                              <th>SubCategory Name</th>
                            </tr>
                            %s
                          </table>
                    </body>
                    </html>
                    """,
                    tableRowResult);

            bufferedWriter.write(htmlPageCode);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
            connection.close();
        }




    }
}
