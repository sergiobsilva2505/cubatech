package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.course.CourseDetailsDto;
import br.com.sbs.cubatech.subcategory.SubCategory;

import java.util.List;

public class SubCategoryDetailsDto {

    private final String name;
    private final String urlCode;
    private final List<CourseDetailsDto> coursesDetails;

    public SubCategoryDetailsDto(SubCategory subCategory) {
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.coursesDetails = subCategory.getCourses().stream().map(CourseDetailsDto::new).toList();
    }

    public String getName() {
        return name;
    }

    public List<CourseDetailsDto> getCoursesDetails() {
        return coursesDetails;
    }

    public String getUrlCode() {
        return urlCode;
    }
}
