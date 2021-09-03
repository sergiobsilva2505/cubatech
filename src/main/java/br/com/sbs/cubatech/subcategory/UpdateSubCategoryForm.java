package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;
import lombok.Getter;

import javax.validation.constraints.*;

@Getter
public class UpdateSubCategoryForm {

    private Long id;
    @NotBlank(message = "{subcategory.name.notempty}")
    @Size(min = 3, message = "{subcategory.name.invalid.size}")
    private String name;
    @NotBlank(message = "{subcategory.urlcode.notempty}")
    @Size(min = 3, message = "{subcategory.urlcode.invalid.size}")
    @Pattern(regexp = "[a-z-]+", message = "{subcategory.urlcode.invalid.pattern}")
    private String urlCode;
    private String description;
    private String studyGuide;
    private Status status;
    @Positive(message = "{subcategory.orderinsystem.invalid.number}")
    private Integer orderInSystem;
    @NotNull(message = "{subcategory.categoryid.notnull}")
    private Long categoryId;

    public UpdateSubCategoryForm(Long id, String name, String urlCode, String description, String studyGuide, Status status,
                                 Integer orderInSystem, Long categoryId) {
        this.id = id;
        this.name = name;
        this.urlCode = urlCode;
        this.description = description;
        this.studyGuide = studyGuide;
        this.status = status;
        this.orderInSystem = orderInSystem;
        this.categoryId = categoryId;
    }

    public SubCategory toEntity(Category category){
        return new SubCategory(id, name, urlCode, description, studyGuide, status, orderInSystem, category);
    }

}
