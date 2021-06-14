package br.com.sbs.cubatech.model;

import static br.com.sbs.cubatech.validation.Validator.*;

public class Category {

    private Long id;
    private String name;
    private String urlCode;
    private String description;
    private String studyGuide;
    private Boolean active = true;
    private Byte index;
    private String iconPath;
    private String colorCode;

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(Long id, String name, String urlCode, String description, String studyGuide,
                    Byte index, String iconPath, String colorCode) {
        notEmptyOrNull(name, "Name can't be null or empty!");
        notEmptyOrNull(urlCode, "UrlCode can't be null or empty!" );
        urlCodeValidation(urlCode, "Only lowercase letters, no spaces and bar as separator");

        this.id = id;
        this.name = name;
        this.urlCode = urlCode;
        this.description = description;
        this.studyGuide = studyGuide;
        this.index = index;
        this.iconPath = iconPath;
        this.colorCode = colorCode;
    }


}
