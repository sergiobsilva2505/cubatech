package br.com.sbs.cubatech.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryApiController {

    private CategoryRepository categoryRepository;

    public CategoryApiController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping(value = "/api/categories", produces ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE } )
    public ResponseEntity<List<CategoryApiDto>> findActiveCategories(){
        List<Category> categoryList = categoryRepository.findByStatusActive();
        return ResponseEntity.ok().body(CategoryApiDto.convertAll(categoryList));
    }
}
