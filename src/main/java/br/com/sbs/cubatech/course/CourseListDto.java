package br.com.sbs.cubatech.course;


// todo classe ainda não utilizada. Será implementada um DTO para listar os cursos com Pageable.
// aguardando instrução do Gesley.
public class CourseListDto {

    private String name;
    private String urlCode;
    private CourseVisibility courseVisibility;
    private String subCategoryName;

    public CourseListDto(String name, String urlCode, CourseVisibility courseVisibility, String subCategoryName) {
        this.name = name;
        this.urlCode = urlCode;
        this.courseVisibility = courseVisibility;
        this.subCategoryName = subCategoryName;
    }

    public String getName() {
        return name;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public CourseVisibility getCourseVisibility() {
        return courseVisibility;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }
}
