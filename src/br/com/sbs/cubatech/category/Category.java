package br.com.sbs.cubatech.category;

import static br.com.sbs.cubatech.validation.Validator.*;

public class Category {

    private Long id;
    private String name;
    private String urlCode;
    private String description;
    private String studyGuide;
    private boolean active;
    private Integer order;
    private String iconPath;
    private String colorCode;

    public Category(String name, String urlCode) {
        notEmptyOrNull(name, "Category: Name can't be null or empty!");
        notEmptyOrNull(urlCode, "Category: UrlCode can't be null or empty!" );
        urlCodeValidation(urlCode, "Category: Only lowercase letters, no spaces and bar as separator");

        this.name = name;
        this.urlCode = urlCode;
    }
}
