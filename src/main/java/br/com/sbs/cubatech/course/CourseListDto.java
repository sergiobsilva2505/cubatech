package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryDto;
import br.com.sbs.cubatech.subcategory.SubCategory;

import java.util.List;

public class CourseListDto {

    private String name;
    private String urlCode;
    private CourseVisibility courseVisibility;
    private String subCategoryName;

    public CourseListDto(String name, String urlCode, CourseVisibility courseVisibility, String subCategoryName) {
        this.name = name;
        this.urlCode = urlCode;
        this.courseVisibility = courseVisibility;
        this.subCategoryName = subCategoryName;
    }

//    public static List<CourseListDto> getDto(Course course, SubCategory subCategory){
//        return
//    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public CourseVisibility getCourseVisibility() {
        return courseVisibility;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }
}
