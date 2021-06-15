package br.com.sbs.cubatech.category;

import static br.com.sbs.cubatech.validation.Validator.*;

public class SubCategory {

    private Long id;
    private String name;
    private String urlCode;
    private String description;
    private String studyGuide;
    private Boolean active;
    private Category category; // todo implementar validador

    public SubCategory(Long id, String name, String urlCode, Boolean active, Category category) {
        notEmptyOrNull(name, "SubCategory: Name needs to be");
        notEmptyOrNull(urlCode, "SubCategory: UrlCode can't be null or empty!");
        urlCodeValidation(urlCode, "SubCategory: Only lowercase letters, no spaces and bar as separator");
        notNullBoolean(active, "SubCategory: can't be null");
        objectNotNull(category, "Subcategory: Category can't not be null");
        this.id = id;
        this.name = name;
        this.urlCode = urlCode;
        this.active = active;
        this.category = category;
    }
}
