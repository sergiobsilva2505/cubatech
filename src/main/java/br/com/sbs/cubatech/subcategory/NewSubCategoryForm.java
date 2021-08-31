package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;

import javax.validation.constraints.*;

public class NewSubCategoryForm {

    @NotBlank(message = "{subcategory.name.notempty}")
    @Size(min = 3, message = "{subcategory.name.invalid.size}")
    private String name;
    @NotBlank(message = "{subcategory.urlcode.notempty}")
    @Size(min = 3, message = "{subcategory.urlcode.invalid.size}")
    @Pattern(regexp = "[a-z-]+", message = "{subcategory.urlcode.invalid.pattern}")
    private String urlCode;
    private String description;
    private String studyGuide;
    private Status status;
    @Positive(message = "{subcategory.orderinsystem.invalid.number}")
    private Integer orderInSystem;
    @NotNull(message = "{subcategory.categoryid.notnull}")
    private Long categoryId;

    public NewSubCategoryForm(String name, String urlCode, String description, String studyGuide, Status status,
                              Integer orderInSystem, Long categoryId) {
        this.name = name;
        this.urlCode = urlCode;
        this.description = description;
        this.studyGuide = studyGuide;
        this.status = status;
        this.orderInSystem = orderInSystem;
        this.categoryId = categoryId;
    }

    public SubCategory toEntity(Category category){
        return new SubCategory(name, urlCode, orderInSystem, description, studyGuide, status, category);
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

    public Long getCategoryId() {
        return categoryId;
    }
}
