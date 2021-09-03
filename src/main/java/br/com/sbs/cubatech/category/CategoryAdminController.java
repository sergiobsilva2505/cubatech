package br.com.sbs.cubatech.category;

import br.com.sbs.cubatech.course.CourseProjection;
import br.com.sbs.cubatech.course.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@AllArgsConstructor
@Controller
public class CategoryAdminController {

    private CategoryRepository categoryRepository;
    private CourseRepository courseRepository;



    @GetMapping
    public String showDashboard(){
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model){
        List<CategoryProjection> categories = categoryRepository.findCategoriesQuantityOfCourses();
        List<CourseProjection> course = courseRepository.findInstructorWithMoreCourses();
        model.addAttribute("categories", categories);
        model.addAttribute("course", course);
        return "admin/dashboard";
    }
}
