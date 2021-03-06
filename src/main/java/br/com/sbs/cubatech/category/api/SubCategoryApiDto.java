package br.com.sbs.cubatech.category.api;

import br.com.sbs.cubatech.subcategory.SubCategory;
import lombok.Getter;

import java.util.List;

@Getter
public class SubCategoryApiDto {

    private final String name;
    private final String urlCode;
    private final String studyGuide;

    private final List<CourseApiDto> courses;

    public SubCategoryApiDto(SubCategory subCategory) {
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.studyGuide = subCategory.getStudyGuide();
        this.courses = CourseApiDto.convertAll(subCategory.getCourses());
    }

    public static List<SubCategoryApiDto> convertAll(List<SubCategory> subCategories){
        return subCategories.stream().map(SubCategoryApiDto::new).toList();
    }
}
