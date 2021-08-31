package br.com.sbs.cubatech.category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class UpdateCategoryForm {


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

    public UpdateCategoryForm(Long id, String name, String urlCode, Integer orderInSystem, String colorCode, String studyGuide,
                              String description, Status status, String iconPath) {
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

    public Category toEntity(){
        return new Category(id, name, urlCode, description, studyGuide, status, orderInSystem, iconPath, colorCode);
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
