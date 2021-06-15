package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.enums.Visibility;
import static br.com.sbs.cubatech.validation.Validator.*;

import java.time.LocalTime;

public class Course {

    private Long id;
    private String name;
    private String urlCode;
    private LocalTime time;
    private Visibility visibility = Visibility.PRIVATE;
    private String instructor;
    private String menu; // ementa
    private String skillsDeveloped;
    private Category category;

    public Course(Long id, String name, String urlCode, LocalTime time, String instructor, Category category) {
        notEmptyOrNull(name , "Course: Name can't be empty or null");
        urlCodeValidation(urlCode, "Course: UrlCode can't be null or empty!");
        notEmptyOrNull(category.getName(), "Course: Must have a category");
        notEmptyOrNull(instructor , "Course: Instructor can't be empty or null");


        this.id = id;
        this.name = name;
        this.urlCode = urlCode;
        this.time = time;
        this.instructor = instructor;
        this.category = category;
    }
}
