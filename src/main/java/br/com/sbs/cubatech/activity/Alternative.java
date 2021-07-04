package br.com.sbs.cubatech.activity;

import java.io.Serializable;

import static br.com.sbs.cubatech.validation.Validator.*;

public class Alternative implements Serializable {


    private Long id;
    private String explanation;
    private Integer order;
    private boolean correct;
    private String justification;

    private Question question;



    public Alternative(String explanation, boolean correct, Question question) {
        notEmptyOrNull(explanation, "Alternative: Explanation");
        objectNotNull(question, "Alternative: Question");
        this.explanation = explanation;
        this.correct = correct;
        this.question = question;
    }
}
