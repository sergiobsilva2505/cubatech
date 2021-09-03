package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.course.CourseDetailsDto;
import br.com.sbs.cubatech.subcategory.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class SubCategoryDetailsDto {

    private final String name;
    private final String urlCode;
    private final List<CourseDetailsDto> coursesDetails;


}
