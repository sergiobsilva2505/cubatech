package br.com.sbs.cubatech.course;

import java.util.List;
import java.util.stream.Collectors;

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

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public Integer getTimeToFinishInHours() {
        return timeToFinishInHours;
    }

    public String getSkillsDeveloped() {
        return skillsDeveloped;
    }

    public static List<CourseApiDto> convertAll(List<Course> courses){
        return courses.stream().map(CourseApiDto::new).collect(Collectors.toList());
    }
}
