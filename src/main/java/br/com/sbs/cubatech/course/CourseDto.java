package br.com.sbs.cubatech.course;


import br.com.sbs.cubatech.subcategory.SubCategory;

public class CourseDto {

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

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public Integer getTimeToFinishInHours() {
        return timeToFinishInHours;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public CourseVisibility getCourseVisibility() {
        return courseVisibility;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getSummary() {
        return summary;
    }

    public String getSkillsDeveloped() {
        return skillsDeveloped;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }
}
