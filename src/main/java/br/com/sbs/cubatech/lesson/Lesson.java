package br.com.sbs.cubatech.lesson;

import br.com.sbs.cubatech.course.Course;

import static br.com.sbs.cubatech.validation.Validator.*;

public class Lesson {

    private Long id;
    private String name;
    private String urlCode;
    private Integer order;
    private boolean active;
    private boolean exam;

    private Course course;

    public Lesson(String name, String urlCode, Course course) {
        notEmptyOrNull(name, "Lesson: Name");
        notEmptyOrNull(urlCode, "Lesson: UrlCode");
        urlCodeValidation(urlCode, "Lesson: UrlCode");
        objectNotNull(course, "Lesson: Course");

        this.name = name;
        this.urlCode = urlCode;
        this.course = course;
    }
}
