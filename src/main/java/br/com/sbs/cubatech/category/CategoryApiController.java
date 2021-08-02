package br.com.sbs.cubatech.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryApiController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(value = "/api/categories", produces ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE } )
    public ResponseEntity<List<CategoryReport>> findActiveCategories(){
        List<Category> categoryList = categoryRepository.findByStatusActive();
        return ResponseEntity.ok().body(CategoryReport.convertAll(categoryList));
    }
}
