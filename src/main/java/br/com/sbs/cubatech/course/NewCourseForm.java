package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.subcategory.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.*;

@AllArgsConstructor
@Getter
public class NewCourseForm {

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

    public Course toEntity(SubCategory subCategory){
        return new Course(name, urlCode, timeToFinishInHours, courseVisibility, targetAudience, instructor, summary, skillsDeveloped, subCategory);
    }

}
