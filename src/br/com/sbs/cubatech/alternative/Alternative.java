package br.com.sbs.cubatech.alternative;

import static br.com.sbs.cubatech.validation.Validator.*;

public class Alternative {

    private Long id;
    private String explanationText;
    private Integer order;
    private Boolean correct;
    private String justification;

    public Alternative(Long id, String explanationText, Boolean correct, String justification) {
        notEmptyOrNull(explanationText, "Alternative: Explanation can't be empty or null");
        notNullBoolean(correct, "Alternative: It should indicate if it is the right answer.");
        this.id = id;
        this.explanationText = explanationText;
        this.correct = correct;
        this.justification = justification;
    }
}
