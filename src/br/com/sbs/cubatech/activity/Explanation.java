package br.com.sbs.cubatech.activity;

import br.com.sbs.cubatech.lesson.Lesson;

public class Explanation extends Activity{

    String explanation;

    public Explanation(Long id, String title, String urlCode, Boolean active, Integer order, Lesson lesson, String explanation) {
        super(id, title, urlCode, active, order, lesson);
        this.explanation = explanation;
    }
}
