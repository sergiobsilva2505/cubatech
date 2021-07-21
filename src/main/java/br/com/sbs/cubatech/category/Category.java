package br.com.sbs.cubatech.category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.sbs.cubatech.validation.Validator.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String urlCode;

    @Column(columnDefinition = "LONGTEXT")
    private String description;
    private String studyGuide;

    @Enumerated(EnumType.STRING)
    private Status status;
    private Integer orderInSystem;
    private String iconPath;
    private String colorCode;

    @OneToMany (mappedBy = "category", cascade = CascadeType.ALL)
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

    public Category(String name, String urlCode, Integer orderInSystem, String description, Status status, String iconPath, String colorCode) {
        this(name, urlCode);
        this.description = description;
        this.status = status;
        this.orderInSystem = orderInSystem;
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getOrderInSystem() {
        return orderInSystem;
    }

    public void setOrderInSystem(Integer orderInSystem) {
        this.orderInSystem = orderInSystem;
    }

    public String getStudyGuide() {
        return studyGuide;
    }


    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public List<SubCategory> getActiveSubCategories() {
        return subCategories.stream()
                .filter(subCategory -> Status.ACTIVE.equals(subCategory.getStatus()))
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
        return String.format("%-15s - %-15s - %-150s - %-6s - %6d - %-100s - %-8s", name, urlCode, description, status, orderInSystem, iconPath, colorCode);
    }

}





