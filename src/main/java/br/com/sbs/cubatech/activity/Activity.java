package br.com.sbs.cubatech.activity;

import br.com.sbs.cubatech.lesson.Lesson;

import javax.persistence.*;

import static br.com.sbs.cubatech.validation.Validator.*;

@Entity
@Table(name = "activity")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String urlCode;
    private boolean active;
    @Column(name = "orderInSystem")
    private Integer order;

    @ManyToOne
    private Lesson lesson;

    public Activity(){

    }

    public Activity(String title, String urlCode,  Lesson lesson) {
        notEmptyOrNull(title, "Activity: Title");
        notEmptyOrNull(urlCode, "Activity: UrlCode");
        urlCodeValidation(urlCode, "Activity: UrlCode");
        objectNotNull(lesson, "Activity: Lesson");

        this.title = title;
        this.urlCode = urlCode;
        this.lesson = lesson;
    }


}
