package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.subcategory.SubCategory;
import br.com.sbs.cubatech.subcategory.SubCategoryRepository;
import br.com.sbs.cubatech.subcategory.SubCategorySelectViewDto;
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

@Controller
public class CourseController {

    private final CourseRepository courseRepository;
    private final SubCategoryRepository subCategoryRepository;

    public CourseController(CourseRepository courseRepository, SubCategoryRepository subCategoryRepository) {
        this.courseRepository = courseRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    @GetMapping("/admin/courses/{categoryCode}/{subCategoryCode}")
    public String getAll(@PathVariable String subCategoryCode,
                         @PathVariable String categoryCode,
                         @PageableDefault(size = 5)
                         Pageable pageable, Model model){
        SubCategory subCategory = subCategoryRepository.findByUrlCode(subCategoryCode)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST));
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
        String categoryCode = subCategory.getCategoryUrlCode();
        String subCategoryCode = course.getSubCategory().getUrlCode();
        return String.format("redirect:/admin/courses/%s/%s",categoryCode, subCategoryCode);
    }

    @GetMapping("/admin/courses/{categoryCode}/{subCategoryCode}/{courseCode}")
    public String showCourse(@PathVariable String categoryCode,
                             @PathVariable String subCategoryCode,
                             @PathVariable String courseCode, Model model){
        List<SubCategorySelectViewDto> subCategories = SubCategorySelectViewDto.toEntity(subCategoryRepository.findAll());
        Course course = courseRepository.findByUrlCode(courseCode)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        model.addAttribute("subCategories", subCategories);
        model.addAttribute("courseVisibilityValues", CourseVisibility.values());
        model.addAttribute("categoryCode", categoryCode);
        model.addAttribute("subCategoryCode", subCategoryCode);
        model.addAttribute("course", new CourseDto(course));
        return "/course/formUpdateCourse";
    }

    @PostMapping("/admin/courses/{categoryCode}/{subCategoryCode}/{courseCode}")
    public String editCourse(@PathVariable String categoryCode,
                             @PathVariable String subCategoryCode,
                             @PathVariable String courseCode,
                             @Valid CourseForm courseForm,
                             BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return showCourse(categoryCode, subCategoryCode, courseCode, model);
        }
        SubCategory subCategory = subCategoryRepository.findById(courseForm.getSubCategoryId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        Course course = courseForm.toEntity(subCategory);
        courseRepository.save(course);
        return String.format("redirect:/admin/courses/%s/%s", subCategory.getCategory().getUrlCode(), subCategory.getUrlCode());
    }

}
