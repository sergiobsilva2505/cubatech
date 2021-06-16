package br.com.sbs.cubatech.activity;

import static br.com.sbs.cubatech.validation.Validator.*;

public class Alternative {

    private Long id;
    private String explanation;
    private Integer order;
    private Boolean correct;
    private String justification;

    // todo question here

    public Alternative(Long id, String explanation, Boolean correct, String justification) { // todo somente obrigatorio
        notEmptyOrNull(explanation, "Alternative: Explanation can't be empty or null");
//        notNullBoolean(correct, "Alternative: It should indicate if it is the right answer.");
        this.id = id;
        this.explanation = explanation;
        this.correct = correct;
        this.justification = justification;
    }
}
