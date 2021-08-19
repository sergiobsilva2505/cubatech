package br.com.sbs.cubatech.category;

import java.util.List;

public class CategoryDetailsDto {

    private final String name;
    private final String iconPath;
    private final List<SubCategoryDetailsDto> subCategoryDetailsDtos;

    public CategoryDetailsDto(Category category) {
        this.name = category.getName();
        this.iconPath = category.getIconPath();
        this.subCategoryDetailsDtos = category.getSubCategories().stream()
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
