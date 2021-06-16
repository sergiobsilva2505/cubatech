package br.com.sbs.cubatech.activity;

import br.com.sbs.cubatech.lesson.Lesson;

import static br.com.sbs.cubatech.validation.Validator.*;

public class Question extends Activity {

    private String description;
    private QuestionType questionType = QuestionType.SINGLE_ANSWER;

    public Question(String title, String urlCode, Lesson lesson, String description) {
        super(title, urlCode, lesson);
        notEmptyOrNull(description, "Question: The question needs an enunciation");
        objectNotNull(questionType, "Question: QuestionType can't be null");
        this.description = description;
    }
}
