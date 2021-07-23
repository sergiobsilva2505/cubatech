package br.com.sbs.cubatech.builder;

import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.course.CourseVisibility;

public class CourseBuilder {

    private final Course course;

    public CourseBuilder(String name, String urlCode, Integer timeToFinishInHours, String instructor, SubCategory subCategory){
        this.course = new Course(name, urlCode, timeToFinishInHours, instructor, subCategory );
    }

    public CourseBuilder isPrivate(){
        this.course.setCourseVisibility(CourseVisibility.PRIVATE);
        return this;
    }

    public CourseBuilder isPublic(){
        this.course.setCourseVisibility(CourseVisibility.PUBLIC);
        return this;
    }

    public Course build(){
        return this.course;
    }

}
