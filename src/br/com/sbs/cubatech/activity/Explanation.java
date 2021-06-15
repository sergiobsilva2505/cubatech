package br.com.sbs.cubatech.activity;

import br.com.sbs.cubatech.lesson.Lesson;

public class Explanation extends Activity{

    private String explanation;

    public Explanation(Long id, String title, String urlCode, Boolean active, Integer order, Lesson lesson, String explanation) { // todo somente obrigatorios
        super(id, title, urlCode, active, order, lesson);
        this.explanation = explanation;
    }
}
