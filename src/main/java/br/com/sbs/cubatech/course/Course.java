package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.category.SubCategory;

import static br.com.sbs.cubatech.validation.Validator.*;

public class Course {

    public static final int MININUM_TIME_TO_FINISH = 1;
    public static final int MAXIMUM_TIME_TO_FINISH = 20;

    private Long id;
    private String name;
    private String urlCode;
    private Integer timeToFinishInHours;
    private String targetAudience;
    private CourseVisibility courseVisibility = CourseVisibility.PRIVATE;
    private String instructor;
    private String summary;
    private String skillsDeveloped;

    private SubCategory subCategory;

    public Course(String name, String urlCode, Integer timeToFinishInHours, String instructor, SubCategory subCategory) {
        notEmptyOrNull(name , "Course: Name");
        notEmptyOrNull(urlCode , "Course: UrlCode");
        urlCodeValidation(urlCode, "Course: UrlCode");
        notEmptyOrNull(instructor , "Course: Instructor");
        objectNotNull(subCategory, "Course: SubCategory");
        intervalValidation(timeToFinishInHours, MININUM_TIME_TO_FINISH, MAXIMUM_TIME_TO_FINISH);

        this.name = name;
        this.urlCode = urlCode;
        this.timeToFinishInHours = timeToFinishInHours;
        this.instructor = instructor;
        this.subCategory = subCategory;
        this.subCategory.addCourse(this);
    }

    public Course(String name, String urlCode, Integer timeToFinishInHours, CourseVisibility courseVisibility, String targetAudience, String instructor, String summary, String skillsDeveloped, SubCategory subCategory) {
        this(name, urlCode,timeToFinishInHours, instructor, subCategory);
        this.targetAudience = targetAudience;
        this.courseVisibility = courseVisibility;
        this.summary = summary;
        this.skillsDeveloped = skillsDeveloped;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public String getName() {
        return name;
    }

    public Integer getTimeToFinishInHours() {
        return timeToFinishInHours;
    }

    @Override
    public String toString() {
//
        return String.format("%-85s - %-60s - %2d - %-8s - %-20s - %-2380s - %-375s - %-30s" , name, urlCode, timeToFinishInHours, courseVisibility, instructor, summary, skillsDeveloped, subCategory.getName());
    }
}