package br.com.sbs.cubatech.category;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;


public class CategoryReport {

    private final String name;
    private final String urlCode;
    private final Integer orderInSystem;
    private final String colorCode;
    private final String studyGuide;
    private final int totalCoursesInCategory;

    @JsonProperty("subCategories")
    private final List<SubCategoryReport> subCategoryReports;


    public CategoryReport(Category category) {
        this.name = category.getName();
        this.urlCode = category.getUrlCode();
        this.orderInSystem = category.getOrderInSystem();
        this.colorCode = category.getColorCode();
        this.studyGuide = category.getStudyGuide();
        this.totalCoursesInCategory = category.getTotalCourses();
        this.subCategoryReports = SubCategoryReport.convertAll(category.getSubCategories());

    }

    public static List<CategoryReport> convertAll(List<Category> categoryList) {
        return categoryList.stream().map(CategoryReport::new).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public Integer getOrderInSystem() {
        return orderInSystem;
    }

    public String getColorCode() {
        return colorCode;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public int getTotalCoursesInCategory() {
        return totalCoursesInCategory;
    }

    public List<SubCategoryReport> getSubCategoryReports() {
        return subCategoryReports;
    }
}
