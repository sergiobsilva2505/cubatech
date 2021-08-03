package br.com.sbs.cubatech.category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryDto {

    private String name;
    private String urlCode;
    private Integer orderInSystem;
    private String colorCode;
    private String studyGuide;
    private String description;
    private Status status;
    private String iconPath;


    public CategoryDto(Category category) {
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
        return categories.stream().map(CategoryDto::new).collect(Collectors.toList());
    }

    public static Category toEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setUrlCode(categoryDto.getUrlCode());
        category.setDescription(categoryDto.getDescription());
        category.setStudyGuide(categoryDto.getStudyGuide());
        category.setStatus(categoryDto.getStatus());
        category.setOrderInSystem(categoryDto.getOrderInSystem());
        category.setIconPath(categoryDto.getIconPath());
        category.setColorCode(categoryDto.getColorCode());
        return category;
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
