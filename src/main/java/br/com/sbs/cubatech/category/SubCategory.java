package br.com.sbs.cubatech.category;

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

    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
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
    }

    public SubCategory(String name, String urlCode, Integer orderInSystem, String description, Status status, Category category){
        this(name, urlCode, category);
        this.orderInSystem = orderInSystem;
        this.description = description;
        this.status = status;

    }

    public long getId() {
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

    public Integer getOrder() {
        return orderInSystem;
    }

    public Category getCategory() {
        return category;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public  Integer totalityToFinishInHours(){
        return this.courses.stream().mapToInt(Course::getTimeToFinishInHours).sum();
    }

    @Override
    public String toString() {
        return String.format("%-30s - %-30s - %6d - %-155s - %-8s - %-8s", name, urlCode, orderInSystem, description, status , category.getName());
    }




}
