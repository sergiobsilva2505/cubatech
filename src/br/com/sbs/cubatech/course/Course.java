package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.category.SubCategory;

import static br.com.sbs.cubatech.validation.Validator.*;

public class Course {

    private Long id;
    private String name;
    private String urlCode;
    private Integer timeToFinishInHours;
    private CourseVisibility courseVisibility = CourseVisibility.PRIVATE;
    private String instructor;
    private String menu; // todo rever nomenclatura para summary
    private String skillsDeveloped;
    private SubCategory subCategory;

    public Course(Long id, String name, String urlCode, Integer timeToFinishInHours, String instructor, SubCategory category) { // todo somente os obrigatorios
        notEmptyOrNull(name , "Course: Name can't be empty or null");
        notEmptyOrNull(urlCode , "Course: UrlCode can't be empty or null");
        urlCodeValidation(urlCode, "Course: Only lowercase letters, no spaces and bar as separator");
        notEmptyOrNull(instructor , "Course: Instructor can't be empty or null");

        this.id = id;
        this.name = name;
        this.urlCode = urlCode;
        this.timeToFinishInHours = timeToFinishInHours;
        this.instructor = instructor;
        this.subCategory = subCategory;
    }
}
