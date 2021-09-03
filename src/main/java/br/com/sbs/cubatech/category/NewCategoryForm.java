package br.com.sbs.cubatech.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
public class NewCategoryForm {

    @NotBlank(message = "{category.name.notempty}")
    @Size(min = 3, message = "{category.name.invalid.size}")
    private String name;
    @NotBlank(message = "{category.urlcode.notempty}")
    @Size(min = 5, message = "{category.urlcode.invalid.size}")
    @Pattern(regexp = "[a-z-]+", message = "{category.urlcode.invalid.pattern}")
    private String urlCode;
    @Positive(message = "{category.orderinsystem.invalid.number}")
    private Integer orderInSystem;
    private String colorCode;
    private String studyGuide;
    private String description;
    private Status status;
    private String iconPath;

    public Category toEntity(){
        return new Category(name, urlCode, description, studyGuide, status, orderInSystem, iconPath, colorCode);
    }

}
