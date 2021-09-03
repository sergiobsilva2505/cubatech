package br.com.sbs.cubatech.subcategory;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.*;

@AllArgsConstructor
@Getter
public class NewSubCategoryForm {

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

    public SubCategory toEntity(Category category){
        return new SubCategory(name, urlCode, orderInSystem, description, studyGuide, status, category);
    }


}
