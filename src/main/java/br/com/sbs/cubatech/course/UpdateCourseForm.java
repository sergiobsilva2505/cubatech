package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.subcategory.SubCategory;

import javax.validation.constraints.*;

public class UpdateCourseForm {

    private Long id;
    @NotBlank(message = "{course.name.notempty}")
    @Size(min = 3, message = "{course.name.invalid.size}")
    private String name;
    @NotBlank(message = "{course.urlcode.notempty}")
    @Size(min = 3, message = "{course.urlcode.invalid.size}")
    @Pattern(regexp = "[a-z-]+", message = "{course.urlcode.invalid.pattern}")
    private String urlCode;
    @NotNull(message = "{course.timetofinishinhours.notnull}")
    @Positive
    @Min(value = 1, message = "{course.timetofinishinhours.min}")
    @Max(value = 20, message = "{course.timetofinishinhours.max}")
    private Integer timeToFinishInHours;
    private String targetAudience;
    private CourseVisibility courseVisibility;
    @NotBlank(message = "{course.instructor.notempty}")
    @Size(min = 3, max = 30, message = "{course.instructor.invalid.size}")
    private String instructor;
    private String summary;
    private String skillsDeveloped;
    @NotNull(message = "{course.subcategoryid.notempty}")
    private Long subCategoryId;

    public UpdateCourseForm(Long id, String name, String urlCode, Integer timeToFinishInHours, String targetAudience,
                      CourseVisibility courseVisibility, String instructor, String summary, String skillsDeveloped, Long subCategoryId) {
        this.id = id;
        this.name = name;
        this.urlCode = urlCode;
        this.timeToFinishInHours = timeToFinishInHours;
        this.targetAudience = targetAudience;
        this.courseVisibility = courseVisibility;
        this.instructor = instructor;
        this.summary = summary;
        this.skillsDeveloped = skillsDeveloped;
        this.subCategoryId = subCategoryId;
    }

    public Course toEntity(SubCategory subCategory){
        return new Course(id, name, urlCode, timeToFinishInHours, courseVisibility, targetAudience, instructor, summary, skillsDeveloped, subCategory);
    }

    public Long getId() {
        return id;
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

    public Long getSubCategoryId() {
        return subCategoryId;
    }
}
