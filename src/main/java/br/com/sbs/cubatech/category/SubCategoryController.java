package br.com.sbs.cubatech.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SubCategoryController {

    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryController(SubCategoryRepository subCategoryRepository){
        this.subCategoryRepository = subCategoryRepository;
    }


    @GetMapping("/admin/subcategories/{categoryCode}")
    public String getAll(@PathVariable String categoryCode, Model model) {
        List<SubCategory> subCategories = subCategoryRepository.findByCategoryUrlCode(categoryCode);
        List<SubCategoryDto> subCategoryDtos = SubCategoryDto.convertAll(subCategories);
        model.addAttribute("subCategories", subCategoryDtos);
        return "subCategory/viewSubCategoryList";
    }
}
