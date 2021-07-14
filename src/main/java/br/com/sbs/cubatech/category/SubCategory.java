package br.com.sbs.cubatech.category;

import br.com.sbs.cubatech.course.Course;

import java.util.ArrayList;
import java.util.List;

import static br.com.sbs.cubatech.validation.Validator.*;

public class SubCategory {

    private Long id;
    private String name;
    private String urlCode;
    private String description;
    private String studyGuide;
    private Integer order;
    private Status status;

    private Category category;

    private List<Course> courses = new ArrayList<>();

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

    public SubCategory(String name, String urlCode, Integer order, String description, Status status, Category category){
        this(name, urlCode, category);
        this.order = order;
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

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public Integer getTotalCourses(){
        return this.courses.size();
    }

    public String getDescription() {
        return description;
    }

    public Integer getOrder() {
        return order;
    }

    public Category getCategory() {
        return category;
    }

    public  Integer totalityToFinishInHours(){
        return this.courses.stream().mapToInt(Course::getTimeToFinishInHours).sum();
    }

    @Override
    public String toString() {
        return String.format("%-30s - %-30s - %6d - %-155s - %-8s - %-8s", name, urlCode, order, description, status , category.getName());
    }




}
