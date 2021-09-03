package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.course.CourseDetailsDto;
import br.com.sbs.cubatech.subcategory.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class SubCategoryDetailsDto {

    private final String name;
    private final String urlCode;
    private final List<CourseDetailsDto> coursesDetails;

    public SubCategoryDetailsDto(SubCategory subCategory) {
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.coursesDetails = subCategory.getCourses().stream().map(CourseDetailsDto::new).toList();
    }


}
