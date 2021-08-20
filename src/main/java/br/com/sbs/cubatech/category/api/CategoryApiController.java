package br.com.sbs.cubatech.category.api;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryRepository;
import br.com.sbs.cubatech.category.Status;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryApiController {

    private final CategoryRepository categoryRepository;

    public CategoryApiController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping(value = "/api/categories", produces ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE } )
    @Cacheable(value = "categories")
    public ResponseEntity<List<CategoryApiDto>> findActiveCategories(){
        List<Category> categoryList = categoryRepository.findByStatus(Status.ACTIVE);
        return ResponseEntity.ok().body(CategoryApiDto.convertAll(categoryList));
    }

    @GetMapping(value = "/bGltcGEtby1jYWNoZS1kYS1hcGktYWU")
    @CacheEvict(value = "categories", allEntries = true)
    public String clearCache(){
        return "category cache cleared";
    }
}
