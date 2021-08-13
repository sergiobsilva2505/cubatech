package br.com.sbs.cubatech.category;

import br.com.sbs.cubatech.course.CourseProjection;
import br.com.sbs.cubatech.course.CourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class CategoryAdminController {

    private CategoryRepository categoryRepository;
    private CourseRepository courseRepository;

    public CategoryAdminController(CategoryRepository categoryRepository, CourseRepository courseRepository){
        this.categoryRepository = categoryRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public String showDashboard(){
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        List<CategoryProjection> categories = categoryRepository.findCategoriesQttCourses();
        List<CourseProjection> course = courseRepository.findInstructorWithMoreCourses();
        model.addAttribute("categories", categories);
        model.addAttribute("course", course);
        return "admin/dashboard";
    }
}
