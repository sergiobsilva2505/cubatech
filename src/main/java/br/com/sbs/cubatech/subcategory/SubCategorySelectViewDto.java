package br.com.sbs.cubatech.subcategory;

import lombok.Getter;

import java.util.List;

@Getter
public class SubCategorySelectViewDto {

    private final Long id;
    private final String name;

    public SubCategorySelectViewDto(SubCategory subCategory) {
        this.id = subCategory.getId();
        this.name = subCategory.getName();
    }

    public static List<SubCategorySelectViewDto> toEntity(List<SubCategory> subCategoriesList) {
        return subCategoriesList.stream().map(SubCategorySelectViewDto::new).toList();
    }
}
