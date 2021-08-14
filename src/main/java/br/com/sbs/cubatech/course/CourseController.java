package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.subcategory.SubCategory;
import br.com.sbs.cubatech.subcategory.SubCategoryRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public String formNewCourse(Model model){
        List<SubCategory> subCategories = subCategoryRepository.findAll();
        model.addAttribute("subCategories", subCategories);
        model.addAttribute("courseVisibilityValues",CourseVisibility.values());
        return "/course/formNewCourse";
    }

    @PostMapping("/admin/courses")
    public String newCourse(@Valid CourseForm courseForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return formNewCourse(model);
        }
        SubCategory subCategory = subCategoryRepository.findById(courseForm.getSubCategoryId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        Course course = courseForm.toEntity(subCategory);
        courseRepository.save(course);
        return "redirect:/admin/courses/{categoryCode}/{subCategoryCode}";
    }

}
