package br.com.sbs.cubatech.activity;

import br.com.sbs.cubatech.lesson.Lesson;

import javax.persistence.Entity;

import static br.com.sbs.cubatech.validation.Validator.notEmptyOrNull;


public class Explanation extends Activity{

    private String explanation;

    public Explanation() {

    }

    public Explanation(String title, String urlCode, Lesson lesson, String explanation) {
        super(title, urlCode, lesson);
        notEmptyOrNull(explanation, "Activity: Explanation");
        this.explanation = explanation;
    }


}
