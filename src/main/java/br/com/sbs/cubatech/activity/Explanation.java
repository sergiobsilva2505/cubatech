package br.com.sbs.cubatech.activity;

import br.com.sbs.cubatech.lesson.Lesson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import static br.com.sbs.cubatech.validation.Validator.notEmptyOrNull;

@Entity
@Table(name = "explanation")
@PrimaryKeyJoinColumn(name = "activity_id")
public class Explanation extends Activity{

    @Column(columnDefinition = "TEXT")
    private String explanation;

    @Deprecated
    public Explanation() {

    }

    public Explanation(String title, String urlCode, Lesson lesson, String explanation) {
        super(title, urlCode, lesson);
        notEmptyOrNull(explanation, "Activity: Explanation");
        this.explanation = explanation;
    }


}
