package br.com.sbs.cubatech.category.api;

import br.com.sbs.cubatech.category.Category;
import lombok.Getter;

import java.util.List;

@Getter
public class CategoryApiDto {

    private final String name;
    private final String urlCode;
    private final Integer orderInSystem;
    private final String colorCode;
    private final String studyGuide;
    private final int totalCourses;

    private final List<SubCategoryApiDto> subCategories;

    public CategoryApiDto(Category category) {
        this.name = category.getName();
        this.urlCode = category.getUrlCode();
        this.orderInSystem = category.getOrderInSystem();
        this.colorCode = category.getColorCode();
        this.studyGuide = category.getStudyGuide();
        this.totalCourses = category.getTotalCourses();
        this.subCategories = SubCategoryApiDto.convertAll(category.getSubCategories());
    }

    public static List<CategoryApiDto> convertAll(List<Category> categoryList) {
        return categoryList.stream().map(CategoryApiDto::new).toList();
    }
}
