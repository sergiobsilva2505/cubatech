package br.com.sbs.cubatech.activity;

import br.com.sbs.cubatech.enums.QuestionType;
import br.com.sbs.cubatech.lesson.Lesson;

import static br.com.sbs.cubatech.validation.Validator.*;

public class Question extends Activity {

    private String enunciation;
    private QuestionType questionType; // todo implementar validação

    public Question(Long id, String title, String urlCode, Boolean active, Integer order, Lesson lesson, String enunciation, QuestionType questionType) {
        super(id, title, urlCode, active, order, lesson);
        notEmptyOrNull(enunciation, "Question: The question needs an enunciation");
        this.enunciation = enunciation;
        this.questionType = questionType;
    }
}
