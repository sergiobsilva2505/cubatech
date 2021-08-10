package br.com.sbs.cubatech.category;

import java.util.List;

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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public String getDescription() {
        return description;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getOrderInSystem() {
        return orderInSystem;
    }

    public String getIconPath() {
        return iconPath;
    }

    public String getColorCode() {
        return colorCode;
    }
}
