package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.subcategory.SubCategory;
import lombok.Getter;

@Getter
public class CourseDto {

    private Long id;
    private String name;
    private String urlCode;
    private Integer timeToFinishInHours;
    private String targetAudience;
    private CourseVisibility courseVisibility;
    private String instructor;
    private String summary;
    private String skillsDeveloped;
    private SubCategory subCategory;

    public CourseDto(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.urlCode = course.getUrlCode();
        this.timeToFinishInHours = course.getTimeToFinishInHours();
        this.targetAudience = course.getTargetAudience();
        this.courseVisibility = course.getCourseVisibility();
        this.instructor = course.getInstructor();
        this.summary = course.getSummary();
        this.skillsDeveloped = course.getSkillsDeveloped();
        this.subCategory = course.getSubCategory();
    }

}
