package br.com.sbs.cubatech.category;

public class CategoryDto {

    private String name;
    private String urlCode;
    private String description;
    private String studyGuide;
    private Status status;
    private Integer orderInSystem;
    private String iconPath;
    private String colorCode;

    public CategoryDto(Category category) {
        this.name = category.getName();
        this.urlCode = category.getUrlCode();
        this.description = category.getDescription();
        this.studyGuide = category.getStudyGuide();
        this.status = category.getStatus();
        this.orderInSystem = category.getOrderInSystem();
        this.iconPath = category.getIconPath();
        this.colorCode = category.getColorCode();
    }
}
