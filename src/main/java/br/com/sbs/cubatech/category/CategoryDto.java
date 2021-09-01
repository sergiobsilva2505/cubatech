package br.com.sbs.cubatech.category;

import lombok.Getter;

import java.util.List;

@Getter
public class CategoryDto {

    private final Long id;
    private final String name;
    private final String urlCode;
    private final Integer orderInSystem;
    private final String colorCode;
    private final String studyGuide;
    private final String description;
    private final Status status;
    private final String iconPath;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.urlCode = category.getUrlCode();
        this.description = category.getDescription();
        this.studyGuide = category.getStudyGuide();
        this.status = category.getStatus();
        this.orderInSystem = category.getOrderInSystem();
        this.iconPath = category.getIconPath();
        this.colorCode = category.getColorCode();
    }

    public static List<CategoryDto> convertAll(List<Category> categories){
        return categories.stream().map(CategoryDto::new).toList();
    }

}
