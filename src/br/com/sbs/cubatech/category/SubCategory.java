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

    public SubCategory(String name, String urlCode, Category category) {
        notEmptyOrNull(name, "SubCategory: Name");
        notEmptyOrNull(urlCode, "SubCategory: UrlCode");
        urlCodeValidation(urlCode, "SubCategory: UrlCode");
        objectNotNull(category, "Subcategory: Category");

        this.name = name;
        this.urlCode = urlCode;
        this.category = category;
        this.category.addSubCategories(this);
    }

    public SubCategory(String name, String urlCode, Integer order, String description, Status status, Category category){
        this(name, urlCode, category);
        this.order = order;
        this.description = description;
        this.status = status;

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

    public Integer getOrder() {
        return order;
    }

    public String getDescription() {
        return description;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public Integer getTotalCourses(){
        return this.courses.size();
    }

    public  Integer totalityToFinishInHours(){
        return this.courses.stream().mapToInt(Course::getTimeToFinishInHours).sum();
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %d - %s - %s - %s - %d", name, urlCode, order, description, status , category.getName(), totalityToFinishInHours());
//        return String.format("%-30s - %-30s - %6d - %-155s - %-8s - %-8s", name, urlCode, order, description, status , category.getName());
    }

    public String toString2() {
        String coursesName = "";
        for (Course course: this.courses) {
            coursesName += String.format("%s, ", course.getName());
        }
        return String.format("%s<br>%s<br>%s<br>%d<br>", name, description, coursesName, getTotalCourses());
    }


}
