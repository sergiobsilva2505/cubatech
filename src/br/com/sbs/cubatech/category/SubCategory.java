package br.com.sbs.cubatech.category;

import static br.com.sbs.cubatech.validation.Validator.*;

public class SubCategory {

    private Long id;
    private String name;
    private String urlCode;
    private String description;
    private String studyGuide;
    private Integer order;
    private boolean active;
    private Category category;

    public SubCategory(String name, String urlCode, Category category) {
        notEmptyOrNull(name, "SubCategory: Name");
        notEmptyOrNull(urlCode, "SubCategory: UrlCode");
        urlCodeValidation(urlCode, "SubCategory: UrlCode");
        objectNotNull(category, "Subcategory: Category");

        this.name = name;
        this.urlCode = urlCode;
        this.category = category;
    }

    public SubCategory(String name, String urlCode, Integer order, String description, boolean active, Category category){
        notEmptyOrNull(name, "SubCategory: Name");
        notEmptyOrNull(urlCode, "SubCategory: UrlCode");
        urlCodeValidation(urlCode, "SubCategory: UrlCode");
        objectNotNull(category, "Subcategory: Category");

        this.name = name;
        this.urlCode = urlCode;
        this.order = order;
        this.description = description;
        this.active = active;
        this.category = category;

    }

    @Override
    public String toString() {
        return String.format("%-30s - %-30s - %6d - %-155s - %s - %-8s", name, urlCode, order, description, active, category.getName());
    }
}
