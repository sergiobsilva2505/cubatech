package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.course.Course;
import lombok.Getter;

@Getter
public class CourseDetailsDto {

    private final String name;
    private final Integer timeToFinishInHours;

    public CourseDetailsDto(Course course) {
        this.name = course.getName();
        this.timeToFinishInHours = course.getTimeToFinishInHours();
    }

}
