package br.com.sbs.cubatech.course;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    @GetMapping("/admin/courses/cursos")
    public String getAll(String subCategoryCode){

        return "/course/viewCourseList";
    }
}
