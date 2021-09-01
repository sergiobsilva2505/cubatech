package br.com.sbs.cubatech.category;

import br.com.sbs.cubatech.subcategory.SubCategory;
import br.com.sbs.cubatech.subcategory.SubCategoryDetailsDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CategoryDetailsDto {

    private final String name;
    private final String iconPath;
    private final List<SubCategoryDetailsDto> subCategoryDetailsDtos;

    public CategoryDetailsDto(Category category, List<SubCategory> subCategories) {
        this.name = category.getName();
        this.iconPath = category.getIconPath();
        this.subCategoryDetailsDtos = subCategories.stream()
                .map(SubCategoryDetailsDto::new).toList();
    }
}
