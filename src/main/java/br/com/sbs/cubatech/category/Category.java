package br.com.sbs.cubatech.category;

import br.com.sbs.cubatech.subcategory.SubCategory;
import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{category.name.notempty}")
    @Size(min = 3, message = "{category.name.invalid.size}")
    private String name;
    @NotBlank(message = "{category.urlcode.notempty}")
    @Size(min = 5, message = "{category.urlcode.invalid.size}")
    @Pattern(regexp = "[a-z-]+", message = "{category.urlcode.invalid.pattern}")
    @Column(unique = true)
    private String urlCode;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String studyGuide;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Positive(message = "{category.orderinsystem.invalid.number}")
    private Integer orderInSystem;
    private String iconPath;
    private String colorCode;

    @OneToMany (mappedBy = "category", cascade = CascadeType.ALL)
    private List<SubCategory> subCategories = new ArrayList<>();

    @Deprecated
    public Category(){

    }

    public Category(String name, String urlCode) {
        Validate.notBlank(name);
        Validate.notBlank(urlCode);
        Validate.matchesPattern(urlCode,"[a-z-]+");
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

    public Category(Long id, String name, String urlCode, String description, String studyGuide, Status status, Integer orderInSystem, String iconPath, String colorCode) {
        this(name, urlCode, orderInSystem, description, status, iconPath, colorCode);
        this.id = id;
        this.studyGuide = studyGuide;
    }

    public Category(String name, String urlCode, String description, String studyGuide, Status status, Integer orderInSystem, String iconPath, String colorCode){
        this(name, urlCode, orderInSystem, description, status, iconPath, colorCode);
        this.studyGuide = studyGuide;
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

    public String getStudyGuide() {
        return studyGuide;
    }

    public Integer getOrderInSystem() {
        return orderInSystem;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrlCode(String urlCode) {
        this.urlCode = urlCode;
    }

    public void setOrderInSystem(Integer orderInSystem) {
        this.orderInSystem = orderInSystem;
    }
    public List<SubCategory> getActiveSubCategories() {
        return subCategories.stream()
                .filter(SubCategory::isActive)
                .toList();
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

    public void toggleStatus() {
        if(Status.ACTIVE.equals(status)){
            this.status = Status.INACTIVE;
            return;
        }
        this.status = Status.ACTIVE;
    }

    @Override
    public String toString() {
        return String.format("%-15s - %-15s - %-150s - %-6s - %6d - %-100s - %-8s", name, urlCode, description, status,
                orderInSystem, iconPath, colorCode);
    }

}