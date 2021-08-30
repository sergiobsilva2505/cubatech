package br.com.sbs.cubatech.category;

import br.com.sbs.cubatech.subcategory.SubCategory;
import br.com.sbs.cubatech.util.builder.CategoryBuilder;
import br.com.sbs.cubatech.util.builder.SubCategoryBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CategoryTest {

    @Test
    void shouldReturnIllegalArgumentExceptionWhenNameIsBlank(){
        assertThrows(IllegalArgumentException.class, ()-> new Category("", "programacao"));
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", ""));
    }

    @Test
    void shouldReturnNullPointerExceptionWhenNameOrUrlCodeIsNull(){
        assertThrows(NullPointerException.class, ()-> new Category(null, "programacao"));
        assertThrows(NullPointerException.class, ()-> new Category("Programação", null));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenUrlCodeContainsUppercaseCharacters (){
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "prograMacao"));
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "Programacao"));
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "programacaO"));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenUrlCodeContainsAccentsOrSpecialCharacters(){
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "programaçao"));
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "programacão"));
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "programação"));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenUrlCodeContainsSpaces(){
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "progr amacao"));
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "pr ogramacao"));
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "programaca o"));
    }
    
    @Test
    void shouldReturnAllSubCategories() {
        Category category = programmingCategory();

        List<SubCategory> subCategories = category.getSubCategories();

        assertThat(subCategories)
                .hasSize(4)
                .extracting(SubCategory::getUrlCode)
                .containsExactlyInAnyOrder("java", "java-e-persistencia", "php", "cobol");
    }

    @Test
    void shouldReturnOnlyActiveSubCategories(){
        Category category = programmingCategory();

        List<SubCategory> activeSubCategories = category.getActiveSubCategories();

        assertThat(activeSubCategories)
                .hasSize(3)
                .extracting(SubCategory::getUrlCode)
                .containsExactlyInAnyOrder("java", "java-e-persistencia", "php");
    }

    private Category programmingCategory() {
        Category category = CategoryBuilder.category1();

        SubCategoryBuilder.subCategory1(category);
        SubCategoryBuilder.subCategory2(category);
        SubCategoryBuilder.subCategory3(category);
        SubCategoryBuilder.subCategory4(category);

        return category;
    }

}
