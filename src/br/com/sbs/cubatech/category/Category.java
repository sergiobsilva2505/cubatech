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
        notEmptyOrNull(name, "Category: Name");
        notEmptyOrNull(urlCode, "Category: UrlCode" );
        urlCodeValidation(urlCode, "Category: UrlCode");

        this.name = name;
        this.urlCode = urlCode;
    }
}
