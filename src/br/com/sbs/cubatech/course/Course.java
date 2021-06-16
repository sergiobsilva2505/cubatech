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
    private CourseVisibility courseVisibility = CourseVisibility.PRIVATE;
    private String instructor;
    private String summary;
    private String skillsDeveloped;
    private SubCategory subCategory;



    public Course(String name, String urlCode, Integer timeToFinishInHours, String instructor, SubCategory subCategory) {
        notEmptyOrNull(name , "Course: Name can't be empty or null");
        notEmptyOrNull(urlCode , "Course: UrlCode can't be empty or null");
        urlCodeValidation(urlCode, "Course: Only lowercase letters, no spaces and bar as separator");
        notEmptyOrNull(instructor , "Course: Instructor can't be empty or null");
        objectNotNull(subCategory, "Category: subCategory can nott be null");
        intervalValidation(timeToFinishInHours, MININUM_TIME_TO_FINISH, MAXIMUM_TIME_TO_FINISH, "Course: time to finish, needs to be between 1 or 20 hours");


        this.name = name;
        this.urlCode = urlCode;
        this.timeToFinishInHours = timeToFinishInHours;
        this.instructor = instructor;
        this.subCategory = subCategory;
    }
}
