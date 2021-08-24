package br.com.sbs.cubatech.category;

import br.com.sbs.cubatech.subcategory.SubCategory;

import java.util.List;

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

    public String getName() {
        return name;
    }

    public List<SubCategoryDetailsDto> getSubCategoryDetailsDtos() {
        return subCategoryDetailsDtos;
    }

    public String getIconPath() {
        return iconPath;
    }
}
