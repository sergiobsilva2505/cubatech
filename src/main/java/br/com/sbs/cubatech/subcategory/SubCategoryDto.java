package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.category.Status;
import lombok.Getter;

import java.util.List;

@Getter
public class SubCategoryDto {

    private final Long id;
    private final String name;
    private final String urlCode;
    private final Integer orderInSystem;
    private final String studyGuide;
    private final String description;
    private final Status status;
    private final Long categoryId;

    public SubCategoryDto(SubCategory subCategory) {
        this.id = subCategory.getId();
        this.name = subCategory.getName();
        this.urlCode = subCategory.getUrlCode();
        this.orderInSystem = subCategory.getOrderInSystem();
        this.studyGuide = subCategory.getStudyGuide();
        this.description = subCategory.getDescription();
        this.status = subCategory.getStatus();
        this.categoryId = subCategory.getCategoryId();
    }

    public static List<SubCategoryDto> convertAll(List<SubCategory> subCategories) {
        return subCategories.stream().map(SubCategoryDto::new).toList();
    }

}
