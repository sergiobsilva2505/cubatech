package br.com.sbs.cubatech.category;

import java.util.List;

public class SubCategoryDto {

    private final Long id;
    private final String name;
    private final String urlCode;
    private final String description;
    private final String studyGuide;
    private final Integer orderInSystem;
    private final Status status;

    public SubCategoryDto(SubCategory subCategory) {
        this.id = subCategory.getId();
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.description = subCategory.getDescription();
        this.studyGuide = subCategory.getStudyGuide();
        this.orderInSystem = subCategory.getOrderInsystem();
        this.status = subCategory.getStatus();
    }

    public static List<SubCategoryDto> convertAll(List<SubCategory> subCategories){
        return subCategories.stream().map(SubCategoryDto::new).toList();
    }
}
