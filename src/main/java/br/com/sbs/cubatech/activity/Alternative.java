package br.com.sbs.cubatech.activity;

import javax.persistence.*;
import java.io.Serializable;

import static br.com.sbs.cubatech.validation.Validator.notEmptyOrNull;
import static br.com.sbs.cubatech.validation.Validator.objectNotNull;

@Entity
@Table(name = "alternative")
public class Alternative implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String explanation;
    @Column(name = "orderInSystem")
    private Integer order;
    private boolean correct;
    private String justification;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Question question;

    @Deprecated
    public Alternative() {
    }

    public Alternative(String explanation, boolean correct, Question question) {
        notEmptyOrNull(explanation, "Alternative: Explanation");
        objectNotNull(question, "Alternative: Question");
        this.explanation = explanation;
        this.correct = correct;
        this.question = question;
    }
}
