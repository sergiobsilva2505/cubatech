package br.com.sbs.cubatech.test;

import br.com.sbs.cubatech.report.ReportDTO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TestJdbcHtmlWriter {

    public static void main(String[] args) throws SQLException, IOException {
        BufferedWriter bufferedWriter = null;
        String htmlPageCode;

        List<ReportDTO> reportDtoList = ReportDTO.getReport();

        String tableRowResult = "";

        try {
            String outPutFile = "relatorio.html";
            bufferedWriter = new BufferedWriter(new FileWriter(outPutFile));

            for (ReportDTO report :  reportDtoList        ) {
                tableRowResult += String.format("""
                            <tr>
                                <td>%d</td>
                                <td>%s</td>
                                <td>%d</td>
                                <td>%d</td>
                                <td>%s</td>
                            </tr>    
                            """, report.getCourseId(), report.getCourseName(), report.getTimeToFinishCourseInHours(),
                        report.getSubCategoryId(), report.getSubCategoryName());
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
                                      <th>Duration</th>
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

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
        }

    }
}
