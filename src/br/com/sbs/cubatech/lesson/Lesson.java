package br.com.sbs.cubatech.lesson;

import br.com.sbs.cubatech.course.Course;
import static br.com.sbs.cubatech.validation.Validator.*;

public class Lesson {

    private Long id;
    private String name;
    private String urlCode;
    private Integer index;
    private Boolean active = false;
    private Boolean exam = false;

    private Course course;

    public Lesson(Long id, String name, String urlCode, Course course) {
        notEmptyOrNull(name, "Lesson: Name can't be null or empty!");
        notEmptyOrNull(urlCode, "Lesson: UrlCode can't be null or empty!");
        urlCodeValidation(urlCode, "Lesson: Only lowercase letters, no spaces and bar as separator");


        this.id = id;
        this.name = name;
        this.urlCode = urlCode;
        this.course = course;
    }
}
