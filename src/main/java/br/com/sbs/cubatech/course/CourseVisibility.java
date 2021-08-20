package br.com.sbs.cubatech.course;

import java.util.Arrays;

public enum CourseVisibility {

    PRIVATE("Privado"),
    PUBLIC("Público");

    private final String description;

    CourseVisibility(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static CourseVisibility get(String courseVisibility){
        return Arrays.stream(CourseVisibility.values())
                .filter(v -> v.name().equals(courseVisibility))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Visibilidade não suportada"));
    }
}
