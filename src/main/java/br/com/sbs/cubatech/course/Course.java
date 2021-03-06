package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.subcategory.SubCategory;
import lombok.Getter;

import javax.persistence.*;

import static br.com.sbs.cubatech.validation.Validator.*;

@Getter
@Entity
@Table(name = "course")
public class Course {

    public static final int MININUM_TIME_TO_FINISH = 1;
    public static final int MAXIMUM_TIME_TO_FINISH = 20;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String urlCode;
    private Integer timeToFinishInHours;
    private String targetAudience;

    @Enumerated(EnumType.STRING)
    private CourseVisibility courseVisibility = CourseVisibility.PRIVATE;
    private String instructor;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @Column(columnDefinition = "TEXT")
    private String skillsDeveloped;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subCategory_id")
    private SubCategory subCategory;

    @Deprecated
    public Course(){

    }

    public Course(String name, String urlCode, Integer timeToFinishInHours, String instructor, SubCategory subCategory) {
        notEmptyOrNull(name , "Course: Name");
        notEmptyOrNull(urlCode , "Course: UrlCode");
        urlCodeValidation(urlCode, "Course: UrlCode");
        notEmptyOrNull(instructor , "Course: Instructor");
        objectNotNull(subCategory, "Course: SubCategory");
        intervalValidation(timeToFinishInHours, MININUM_TIME_TO_FINISH, MAXIMUM_TIME_TO_FINISH);

        this.name = name;
        this.urlCode = urlCode;
        this.timeToFinishInHours = timeToFinishInHours;
        this.instructor = instructor;
        this.subCategory = subCategory;
        this.subCategory.addCourse(this);
    }

    public Course(String name, String urlCode, Integer timeToFinishInHours, CourseVisibility courseVisibility, String targetAudience, String instructor, String summary, String skillsDeveloped, SubCategory subCategory) {
        this(name, urlCode,timeToFinishInHours, instructor, subCategory);
        this.courseVisibility = courseVisibility;
        this.targetAudience = targetAudience;
        this.summary = summary;
        this.skillsDeveloped = skillsDeveloped;
    }

    public Course(Long id, String name, String urlCode, Integer timeToFinishInHours, CourseVisibility courseVisibility, String targetAudience, String instructor, String summary, String skillsDeveloped, SubCategory subCategory){
        this(name, urlCode, timeToFinishInHours, courseVisibility,  targetAudience, instructor, summary, skillsDeveloped, subCategory);
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%-85s - %-60s - %2d - %-8s - %-20s - %-2380s - %-375s - %-30s" , name, urlCode, timeToFinishInHours, courseVisibility, instructor, summary, skillsDeveloped, subCategory.getName());
    }


}
