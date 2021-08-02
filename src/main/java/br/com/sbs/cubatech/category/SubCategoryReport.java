package br.com.sbs.cubatech.category;

import br.com.sbs.cubatech.course.CourseReport;

import java.util.List;
import java.util.stream.Collectors;

public class SubCategoryReport {

    private final String name;
    private final String urlCode;
    private final String studyGuide;

    private final List<CourseReport> courseReports;

    public SubCategoryReport(SubCategory subCategory) {
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.studyGuide = subCategory.getStudyGuide();
        this.courseReports = CourseReport.convertAll(subCategory.getCourses());
    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public List<CourseReport> getCourseReports() {
        return courseReports;
    }

    public static List<SubCategoryReport> convertAll(List<SubCategory> subCategories){
        return subCategories.stream().map(SubCategoryReport::new).collect(Collectors.toList());
    }
}
