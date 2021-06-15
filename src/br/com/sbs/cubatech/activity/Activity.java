package br.com.sbs.cubatech.activity;

import br.com.sbs.cubatech.lesson.Lesson;

import static br.com.sbs.cubatech.validation.Validator.*;

public abstract class Activity {

    private Long id;
    private String title;
    private String urlCode;
    private Boolean active = false;
    private Integer order;
    private Lesson lesson; // todo implementar validador

    public Activity(Long id, String title, String urlCode, Boolean active, Integer order, Lesson lesson) {
        notEmptyOrNull(title, "Activity: Title can't be empty or null");
        notEmptyOrNull(urlCode, "Activity: urlCode can't be empty or null");
        urlCodeValidation(urlCode, "Activity: Only lowercase letters, no spaces or bar as separator");
        notNullBoolean(active, "Activity: can't be null");
        this.id = id;
        this.title = title;
        this.urlCode = urlCode;
        this.active = active;
        this.order = order;
        this.lesson = lesson;
    }


}
