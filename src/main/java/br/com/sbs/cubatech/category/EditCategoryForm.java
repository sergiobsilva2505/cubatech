package br.com.sbs.cubatech.category;

public class EditCategoryForm {

    private String name;
    private String urlCode;
    private String paramOrderInSystem;
    private String description;
    private String status;
    private String iconPath;
    private String colorCode;

    public EditCategoryForm(String name, String urlCode, String paramOrderInSystem, String description, String status, String iconPath, String colorCode) {

        this.name = name;
        this.urlCode = urlCode;
        this.paramOrderInSystem = paramOrderInSystem;
        this.description = description;
        this.status = status;
        this.iconPath = iconPath;
        this.colorCode = colorCode;
    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public Integer getOrderInSystem() {
        return Integer.parseInt(paramOrderInSystem);
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return Status.get(status);
    }

    public String getIconPath() {
        return iconPath;
    }

    public String getColorCode() {
        return colorCode;
    }
}
