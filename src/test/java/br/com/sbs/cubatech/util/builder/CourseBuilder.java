package br.com.sbs.cubatech.util.builder;

import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.course.CourseVisibility;
import br.com.sbs.cubatech.subcategory.SubCategory;

public class CourseBuilder {

    private String name;
    private String urlCode;
    private Integer timeToFinishInHours;
    private String targetAudience;
    private CourseVisibility courseVisibility;
    private String instructor;
    private String summary;
    private String skillsDeveloped;
    private SubCategory subCategory;

    public CourseBuilder(String name, String urlCode, Integer timeToFinishInHours, String instructor, SubCategory subCategory) {
        this.name = name;
        this.urlCode = urlCode;
        this.timeToFinishInHours = timeToFinishInHours;
        this.instructor = instructor;
        this.subCategory = subCategory;
    }

    public CourseBuilder withTargetAudience(String targetAudience){
        this.targetAudience = targetAudience;
        return this;
    }

    public CourseBuilder withCourseVisibility(CourseVisibility courseVisibility){
        this.courseVisibility = courseVisibility;
        return this;
    }

    public CourseBuilder withSummary(String summary){
        this.summary = summary;
        return this;
    }

    public CourseBuilder withSkillsDeveloped(String skillsDeveloped){
        this.skillsDeveloped = skillsDeveloped;
        return this;
    }

    public Course create(){
        return new Course(name, urlCode, timeToFinishInHours, courseVisibility, targetAudience, instructor, summary, skillsDeveloped, subCategory);
    }

    public static Course course1(SubCategory subCategory){
        Course course = new CourseBuilder("Git e Github para Sobrevivência", "git-e-github-para-sobrevivencia", 6, "Mario souto", subCategory)
                .withCourseVisibility(CourseVisibility.PUBLIC)
                .withTargetAudience("Publico alvo")
                .withSummary("Emmenta respectiva do curso")
                .withSkillsDeveloped("descreve as habilidades que serão desenvolvidas durante o curso")
                .create();
        return course;
    }

    public static Course course2(SubCategory subCategory){
        Course course = new CourseBuilder("Java e JPA: Consultas avançadas performance e modelos complexos",
                "java-jpa-consultas-avancadas-performance-modelos-complexos",
                10,
                "Rodrigo Ferreira", subCategory)
                .withCourseVisibility(CourseVisibility.PUBLIC)
                .withTargetAudience("Publico alvo")
                .withSummary("Emmenta respectiva do curso")
                .withSkillsDeveloped("descreve as habilidades que serão desenvolvidas durante o curso")
                .create();
        return course;
    }

    public static Course course3(SubCategory subCategory){
        Course course = new CourseBuilder("Java OO: Introdução à Orientação a Objetos",
                "java-introducao-orientacao-objetos",
                8,
                "Paulo Silvaira", subCategory)
                .withCourseVisibility(CourseVisibility.PUBLIC)
                .withTargetAudience("Publico alvo")
                .withSummary("Emmenta respectiva do curso")
                .withSkillsDeveloped("descreve as habilidades que serão desenvolvidas durante o curso")
                .create();
        return course;
    }

    public static Course course4(SubCategory subCategory){
        Course course = new CourseBuilder("Java JRE e JDK: Escreva o seu primeiro código com Eclipse",
                "java-primeiros-passos",
                8,
                "Paulo Silvaira", subCategory)
                .withCourseVisibility(CourseVisibility.PUBLIC)
                .withTargetAudience("Publico alvo")
                .withSummary("Emmenta respectiva do curso")
                .withSkillsDeveloped("descreve as habilidades que serão desenvolvidas durante o curso")
                .create();
        return course;
    }

    public static Course course5(SubCategory subCategory){
        Course course = new CourseBuilder("Angular CLI",
                "angular-cli",
                20,
                "Paulo Silvaira", subCategory)
                .withCourseVisibility(CourseVisibility.PRIVATE)
                .withTargetAudience("Publico alvo")
                .withSummary("Emmenta respectiva do curso")
                .withSkillsDeveloped("descreve as habilidades que serão desenvolvidas durante o curso")
                .create();
        return course;
    }

}




