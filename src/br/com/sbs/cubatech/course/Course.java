package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;
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
    private SubCategory subCategory;

    public Course(Long id, String name, String urlCode, LocalTime time, String instructor, SubCategory category) {
        notEmptyOrNull(name , "Course: Name can't be empty or null");
        notEmptyOrNull(urlCode , "Course: UrlCode can't be empty or null");
        urlCodeValidation(urlCode, "Course: Only lowercase letters, no spaces and bar as separator");
        //notEmptyOrNull(Scategory.getName(), "Course: Must have a category");
        notEmptyOrNull(instructor , "Course: Instructor can't be empty or null");


        this.id = id;
        this.name = name;
        this.urlCode = urlCode;
        this.time = time;
        this.instructor = instructor;
        this.subCategory = subCategory;
    }
}
