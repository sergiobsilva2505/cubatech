package br.com.sbs.cubatech.report;

import java.sql.SQLException;
import java.util.List;

public class ReportDTO {

    private Long courseId;
    private String courseName;
    private Integer timeToFinishCourseInHours;
    private Long subCategoryId;
    private String subCategoryName;

    public ReportDTO(Long courseId, String courseName, Integer timeToFinishCourseInHours, Long subCategoryId, String subCategoryName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.timeToFinishCourseInHours = timeToFinishCourseInHours;
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getTimeToFinishCourseInHours() {
        return timeToFinishCourseInHours;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public static List<ReportDTO> getReport() throws SQLException {
        ReportDao reportDao = new ReportDao();
        List<ReportDTO> reportDtoList = reportDao.getReportData();
        return reportDtoList;
    }
}
