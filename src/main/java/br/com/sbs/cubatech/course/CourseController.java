package br.com.sbs.cubatech.course;

import br.com.sbs.cubatech.category.UpdateCategoryFormValidator;
import br.com.sbs.cubatech.subcategory.SubCategory;
import br.com.sbs.cubatech.subcategory.SubCategoryRepository;
import br.com.sbs.cubatech.subcategory.SubCategorySelectViewDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
public class CourseController {

    private final CourseRepository courseRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final NewCourseFormValidator newCourseFormValidator;
    private final UpdateCourseFormValidator updateCourseFormValidator;

    @InitBinder("newCourseForm")
    void initBinderNewCourseForm(WebDataBinder webDataBinder){
        webDataBinder.addValidators(newCourseFormValidator);
    }

    @InitBinder("updateCourseForm")
    void initBinderUpdateCourseForm(WebDataBinder webDataBinder){
        webDataBinder.addValidators(updateCourseFormValidator);
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
    public String newCourse(@Valid NewCourseForm newCourseForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return formNewCourse(model);
        }
        SubCategory subCategory = subCategoryRepository.findById(newCourseForm.getSubCategoryId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        Course course = newCourseForm.toEntity(subCategory);
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
                             @Valid UpdateCourseForm updateCourseForm,
                             BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return showCourse(categoryCode, subCategoryCode, courseCode, model);
        }
        SubCategory subCategory = subCategoryRepository.findById(updateCourseForm.getSubCategoryId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        Course course = updateCourseForm.toEntity(subCategory);
        courseRepository.save(course);
        return String.format("redirect:/admin/courses/%s/%s", subCategory.getCategory().getUrlCode(), subCategory.getUrlCode());
    }

}
