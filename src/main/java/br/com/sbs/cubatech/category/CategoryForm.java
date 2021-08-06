package br.com.sbs.cubatech.category;

import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.*;

public class CategoryForm {


    private Long id;
    @NotBlank(message = "{category.name.notempty}")
    @Size(min = 3, message = "{category.name.invalid.size}")
    private String name;
    @NotBlank(message = "{category.urlcode.notempty}")
    @Size(min = 5, message = "{category.urlcode.invalid.size}")
    @Pattern(regexp = "[a-z-]+", message = "{category.urlcode.invalid.pattern}")
    private String urlCode;
    @Positive(message = "{category.orderinsystem.invalid.number}")
    private Integer orderInSystem;
    private String colorCode;
    private String studyGuide;
    private String description;
    private Status status;
    private String iconPath;

    public CategoryForm(Long id, String name, String urlCode, Integer orderInSystem, String colorCode, String studyGuide, String description, Status status, String iconPath) {
        this.id = id;
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
        category.setId(categoryForm.getId());
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

    public Long getId() {
        return id;
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
