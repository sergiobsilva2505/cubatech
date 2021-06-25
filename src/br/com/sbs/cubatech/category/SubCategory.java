package br.com.sbs.cubatech.category;

import static br.com.sbs.cubatech.validation.Validator.*;

public class SubCategory {

    private Long id;
    private String name;
    private String urlCode;
    private String description;
    private String studyGuide;
    private Integer order;
    private Status status;
    ;
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

    public SubCategory(String name, String urlCode, Integer order, String description, Status status, Category category){
        notEmptyOrNull(name, "SubCategory: Name");
        notEmptyOrNull(urlCode, "SubCategory: UrlCode");
        urlCodeValidation(urlCode, "SubCategory: UrlCode");
        objectNotNull(category, "Subcategory: Category");

        this.name = name;
        this.urlCode = urlCode;
        this.order = order;
        this.description = description;
        this.status = status;
        this.category = category;

    }

    public String getUrlCode() {
        return urlCode;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("%-30s - %-30s - %6d - %-155s - %-8s - %-8s", name, urlCode, order, description, status , category.getName());
    }
}
