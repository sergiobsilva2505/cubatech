package br.com.sbs.cubatech.activity;

import br.com.sbs.cubatech.lesson.Lesson;

import static br.com.sbs.cubatech.validation.Validator.*;

public class Question extends Activity {

    private String description;
    private QuestionType questionType;

    public Question(String title, String urlCode, Lesson lesson, String description) {
        super(title, urlCode, lesson);
        notEmptyOrNull(description, "Question: Description");
        objectNotNull(questionType, "Question: QuestionType");
        this.description = description;
    }
}
