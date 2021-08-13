package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.subcategory.SubCategory;
import br.com.sbs.cubatech.subcategory.SubCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CourseController {

    private CourseRepository courseRepository;
    private SubCategoryRepository subCategoryRepository;

    public CourseController(CourseRepository courseRepository, SubCategoryRepository subCategoryRepository) {
        this.courseRepository = courseRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    @GetMapping("/admin/courses/{categoryCode}/{subCategoryCode}")
    public String getAll(@PathVariable String subCategoryCode,
                         @PathVariable String categoryCode,
                         @PageableDefault(size = 5)
                         Pageable pageable, Model model){
        SubCategory subCategory = subCategoryRepository.findByUrlCode(subCategoryCode);
        Page<Course> coursesPageable = courseRepository.findAllBySubCategory(subCategory, pageable);
        List<CourseDto> courses = coursesPageable.getContent().stream().map(CourseDto::new).toList();
        model.addAttribute("subCategory", subCategory);
        model.addAttribute("category", categoryCode);
        model.addAttribute("courses", courses);
        model.addAttribute("totalPages", coursesPageable.getTotalPages());
        return "/course/viewCourseList";
    }

    @GetMapping("/admin/courses/new")
    public String formNewCourse(){
        return "/course/formNewCourse";
    }


}
