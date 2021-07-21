package br.com.sbs.cubatech.activity;

import br.com.sbs.cubatech.lesson.Lesson;

import javax.persistence.*;

import static br.com.sbs.cubatech.validation.Validator.*;

@Entity
@Table(name = "question")
@PrimaryKeyJoinColumn(name = "activity_id")
public class Question extends Activity {

    @Column(columnDefinition = "LONGTEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    private QuestionType questionType = QuestionType.SINGLE_ANSWER;

    public Question(){

    }

    public Question(String title, String urlCode, Lesson lesson, String description) {
        super(title, urlCode, lesson);
        notEmptyOrNull(description, "Question: Description");
        this.description = description;
    }
}
