package br.com.sbs.cubatech.category;

import br.com.sbs.cubatech.subcategory.SubCategoryApiDto;

import java.util.List;


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

    public int getTotalCourses() {
        return totalCourses;
    }

    public List<SubCategoryApiDto> getSubCategories() {
        return subCategories;
    }
}
