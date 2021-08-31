package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;
import br.com.sbs.cubatech.course.Course;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static br.com.sbs.cubatech.validation.Validator.*;

@Entity
@Table(name = "subCategory")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String urlCode;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String studyGuide;
    private Integer orderInSystem;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "subCategory")
    private List<Course> courses = new ArrayList<>();

    @Deprecated
    public SubCategory(){

    }

    @Deprecated
    public SubCategory(long id){
        this.id = id;
    }

    public SubCategory(String name, String urlCode, Category category) {
        notEmptyOrNull(name, "SubCategory: Name");
        notEmptyOrNull(urlCode, "SubCategory: UrlCode");
        urlCodeValidation(urlCode, "SubCategory: UrlCode");
        objectNotNull(category, "Subcategory: Category");
        this.name = name;
        this.urlCode = urlCode;
        this.category = category;
        this.category.addSubCategory(this);
    }

    public SubCategory(String name, String urlCode, Integer orderInSystem, String description, Status status, Category category){
        this(name, urlCode, category);
        this.orderInSystem = orderInSystem;
        this.description = description;
        this.status = status;

    }

    public SubCategory(Long id, String name, String urlCode, String description, String studyGuide, Status status, Integer orderInSystem, Category category){
        this(name, urlCode,  orderInSystem, description, status, category);
        this.id = id;
        this.studyGuide = studyGuide;
    }

    public SubCategory(String name, String urlCode, Integer orderInSystem, String description, String studyGuide, Status status, Category category) {
        this(name, urlCode, orderInSystem, description, status, category);
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public Integer getTotalCourses(){
        return this.courses.size();
    }

    public String getDescription() {
        return description;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrderInSystem() {
        return orderInSystem;
    }

    public Category getCategory() {
        return category;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public Long getCategoryId(){
        return this.category.getId();
    }

    public String getCategoryUrlCode() {
        return this.category.getUrlCode();
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public  Integer totalityToFinishInHours(){
        return this.courses.stream().mapToInt(Course::getTimeToFinishInHours).sum();
    }

    public boolean isActive(){
        return Status.ACTIVE.equals(status);
    }

    @Override
    public String toString() {
        return String.format("%-30s - %-30s - %6d - %-155s - %-8s - %-8s", name, urlCode, orderInSystem, description, status , category.getName());
    }

    public void update(UpdateSubCategoryForm updateSubCategoryForm, Category category) {
        this.name = updateSubCategoryForm.getName();
        this.urlCode = updateSubCategoryForm.getUrlCode();
        this.description = updateSubCategoryForm.getDescription();
        this.studyGuide = updateSubCategoryForm.getStudyGuide();
        this.status = updateSubCategoryForm.getStatus();
        this.orderInSystem = updateSubCategoryForm.getOrderInSystem();
        this.category = category;
    }
}