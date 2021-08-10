package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;

public class SubCategoryForm {

    private Long id;
    private String name;
    private String urlCode;
    private String description;
    private String studyGuide;
    private Status status;
    private Integer orderInSystem;
    private Long categoryId;

    public SubCategoryForm(Long id, String name, String urlCode, String description, String studyGuide, Status status,
                           Integer orderInSystem, Long categoryId) {
        this.id = id;
        this.name = name;
        this.urlCode = urlCode;
        this.description = description;
        this.studyGuide = studyGuide;
        this.status = status;
        this.orderInSystem = orderInSystem;
        this.categoryId = categoryId;
    }

    public SubCategory toEntity(Category category){
        return new SubCategory(id, name, urlCode, description, studyGuide, status, orderInSystem, category);
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

    public Long getCategoryId() {
        return categoryId;
    }
}
