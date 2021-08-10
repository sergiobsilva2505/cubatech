package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.category.Status;

import java.util.List;

public class SubCategoryDto {

    private final Long id;
    private final String name;
    private final String urlCode;
    private final Integer orderInSystem;
    private final String studyGuide;
    private final String description;
    private final Status status;

    public SubCategoryDto(SubCategory subCategory) {
        this.id = subCategory.getId();
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.orderInSystem = subCategory.getOrderInSystem();
        this.studyGuide = subCategory.getStudyGuide();
        this.description = subCategory.getDescription();
        this.status = subCategory.getStatus();
    }

    public static List<SubCategoryDto> convertAll(List<SubCategory> subCategories) {
        return subCategories.stream().map(SubCategoryDto::new).toList();
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

    public String getStudyGuide() {
        return studyGuide;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }
}
