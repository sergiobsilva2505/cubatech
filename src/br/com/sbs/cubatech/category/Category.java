package br.com.sbs.cubatech.category;

import java.util.Locale;

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

    public Category(String name, String urlCode, Integer order, String description, boolean active,  String iconPath, String colorCode) {
        notEmptyOrNull(name, "Category: Name");
        notEmptyOrNull(urlCode, "Category: UrlCode" );
        urlCodeValidation(urlCode, "Category: UrlCode");

        this.name = name;
        this.urlCode = urlCode;
        this.description = description;
        this.active = active;
        this.order = order;
        this.iconPath = iconPath;
        this.colorCode = colorCode;
    }

    public Category(String name) {
        notEmptyOrNull(name, "Category: Name");
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    @Override
    public String toString() {
        return String.format("%-15s - %-15s - %-150s - %-6s - %6d - %-100s - %-8s", name, urlCode, description, active, order, iconPath, colorCode);
    }
}





