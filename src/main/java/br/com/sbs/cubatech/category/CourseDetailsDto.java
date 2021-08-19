package br.com.sbs.cubatech.category;

import br.com.sbs.cubatech.course.Course;

public class CourseDetailsDto {

    private final String name;
    private final Integer timeToFinishInHoours;

    public CourseDetailsDto(Course course) {
        this.name = course.getName();
        this.timeToFinishInHoours = course.getTimeToFinishInHours();
    }

    public String getName() {
        return name;
    }

    public Integer getTimeToFinishInHoours() {
        return timeToFinishInHoours;
    }
}
