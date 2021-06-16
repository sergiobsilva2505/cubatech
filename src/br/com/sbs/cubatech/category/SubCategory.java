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
        notEmptyOrNull(name, "SubCategory: Name can't null or empty.");
        notEmptyOrNull(urlCode, "SubCategory: UrlCode can't be null or empty!");
        urlCodeValidation(urlCode, "SubCategory: Only lowercase letters, no spaces and bar as separator");
        objectNotNull(category, "Subcategory: Category can't not be null");

        this.name = name;
        this.urlCode = urlCode;
        this.category = category;
    }
}
