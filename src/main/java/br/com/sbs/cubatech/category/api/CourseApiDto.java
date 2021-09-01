package br.com.sbs.cubatech.category.api;

import br.com.sbs.cubatech.course.Course;
import lombok.Getter;

import java.util.List;

@Getter
public class CourseApiDto {

    private final String name;
    private final String urlCode;
    private final Integer timeToFinishInHours;
    private final String skillsDeveloped;

    public CourseApiDto(Course course) {
        this.name = course.getName();
        this.urlCode = course.getUrlCode();
        this.timeToFinishInHours = course.getTimeToFinishInHours();
        this.skillsDeveloped = course.getSkillsDeveloped();
    }

    public static List<CourseApiDto> convertAll(List<Course> courses){
        return courses.stream().map(CourseApiDto::new).toList();
    }
}
