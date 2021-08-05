package br.com.sbs.cubatech.category;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

public class CategoryForm {

    @NotNull
    @Size(min = 3, message = "{category.name.invalid.size}")
    private String name;
    @NotNull @Size(min = 5, message = "{blankornull}")
    @Pattern(regexp = "[a-z-]+", message = "{urlcodevalidation}")
    private String urlCode;
    @Positive
    private Integer orderInSystem;
    private String colorCode;
    private String studyGuide;
    private String description;
    private Status status;
    private String iconPath;

    public CategoryForm(String name, String urlCode, Integer orderInSystem, String colorCode, String studyGuide, String description, Status status, String iconPath) {
        this.name = name;
        this.urlCode = urlCode;
        this.orderInSystem = orderInSystem;
        this.colorCode = colorCode;
        this.studyGuide = studyGuide;
        this.description = description;
        this.status = status;
        this.iconPath = iconPath;
    }

    public static Category toEntity(CategoryForm categoryForm){
        Category category = new Category();
        category.setName(categoryForm.getName());
        category.setUrlCode(categoryForm.getUrlCode());
        category.setDescription(categoryForm.getDescription());
        category.setStudyGuide(categoryForm.getStudyGuide());
        category.setStatus(categoryForm.getStatus());
        category.setOrderInSystem(categoryForm.getOrderInSystem());
        category.setIconPath(categoryForm.getIconPath());
        category.setColorCode(categoryForm.getColorCode());
        return category;
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

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public String getIconPath() {
        return iconPath;
    }

}
