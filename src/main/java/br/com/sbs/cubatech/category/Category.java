package br.com.sbs.cubatech.category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.sbs.cubatech.validation.Validator.*;

public class Category {

    private Long id;
    private String name;
    private String urlCode;
    private String description;
    private String studyGuide;
    private Status status;
    private Integer order;
    private String iconPath;
    private String colorCode;

    private List<SubCategory> subCategories = new ArrayList<>();

    public Category(){

    }

    public Category(String name, String urlCode) {
        notEmptyOrNull(name, "Category: Name");
        notEmptyOrNull(urlCode, "Category: UrlCode" );
        urlCodeValidation(urlCode, "Category: UrlCode");
        this.name = name;
        this.urlCode = urlCode;
    }

    public Category(String name, String urlCode, Integer order, String description, Status status,  String iconPath, String colorCode) {
        this(name, urlCode);
        this.description = description;
        this.status = status;
        this.order = order;
        this.iconPath = iconPath;
        this.colorCode = colorCode;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public String getDescription() {
        return description;
    }

    public String getIconPath() {
        return iconPath;
    }

    public String getColorCode() {
        return colorCode;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getOrder() {
        return order;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public List<SubCategory> getActiveSubCategories() {
        return subCategories.stream()
                .filter(subCategory -> Status.ATIVA.equals(subCategory.getStatus()))
                .collect(Collectors.toList());
    }

    public  Integer totalTimeToFinishPerCategory(){
        return this.subCategories.stream().mapToInt(SubCategory::totalityToFinishInHours).sum();
    }

    public void addSubCategory(SubCategory subCategory) {
        this.subCategories.add(subCategory);
    }

    public Integer getTotalCourses(){

        return subCategories.stream().mapToInt(SubCategory::getTotalCourses).sum();
    }

    @Override
    public String toString() {
        return String.format("%-15s - %-15s - %-150s - %-6s - %6d - %-100s - %-8s", name, urlCode, description, status, order, iconPath, colorCode);
    }

}





