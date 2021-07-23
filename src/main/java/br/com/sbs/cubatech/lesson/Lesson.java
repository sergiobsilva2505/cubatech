package br.com.sbs.cubatech.lesson;

import br.com.sbs.cubatech.course.Course;

import javax.persistence.*;

import static br.com.sbs.cubatech.validation.Validator.*;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String urlCode;

    @Column(name = "orderInSystem")
    private Integer order;
    private boolean active;
    private boolean exam;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Deprecated
    public Lesson(){

    }

    public Lesson(String name, String urlCode, Course course) {
        notEmptyOrNull(name, "Lesson: Name");
        notEmptyOrNull(urlCode, "Lesson: UrlCode");
        urlCodeValidation(urlCode, "Lesson: UrlCode");
        objectNotNull(course, "Lesson: Course");

        this.name = name;
        this.urlCode = urlCode;
        this.course = course;
    }
}
