package br.com.sbs.cubatech.activity;

import br.com.sbs.cubatech.lesson.Lesson;

import static br.com.sbs.cubatech.validation.Validator.*;

public abstract class Activity {

    private Long id;
    private String title;
    private String urlCode;
    private boolean active;
    private Integer order;
    private Lesson lesson;

    public Activity(String title, String urlCode,  Lesson lesson) {
        notEmptyOrNull(title, "Activity: Title can't be empty or null");
        notEmptyOrNull(urlCode, "Activity: urlCode can't be empty or null");
        urlCodeValidation(urlCode, "Activity: Only lowercase letters, no spaces or bar as separator");
        objectNotNull(lesson, "Activity: Lesson can't be null");

        this.title = title;
        this.urlCode = urlCode;
        this.lesson = lesson;
    }


}
