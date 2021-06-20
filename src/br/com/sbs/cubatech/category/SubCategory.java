package br.com.sbs.cubatech.category;

import static br.com.sbs.cubatech.validation.Validator.*;

public class SubCategory {

    private Long id;
    private String name;
    private String urlCode;
    private String description;
    private String studyGuide;
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
}
