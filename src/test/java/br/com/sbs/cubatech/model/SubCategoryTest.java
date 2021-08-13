package br.com.sbs.cubatech.model;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.subcategory.SubCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SubCategoryTest {

    private Category category;

    @BeforeEach
    void init(){
        this.category = new Category( "Programação", "programacao");
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenUrldeCodeOrNameIsBlankTest(){
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("", "java",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("", "",  category));
    }

    @Test
    void shouldReturnNullPointerExceptionWhenUrldeCodeOrNameAreNullTest(){
        assertThrows(NullPointerException.class, ()-> new SubCategory(null, "java",  category));
        assertThrows(NullPointerException.class, ()-> new SubCategory("Java", null,  category));
        assertThrows(NullPointerException.class, ()-> new SubCategory(null, null,  category));
    }

    @Test
    void shouldReturnNullPointerExceptionWhenCategoryIsNullTest(){
        assertThrows(NullPointerException.class, ()-> new SubCategory("Java", "java",  null));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenUrlcodeContainsUppercaseLettersTest(){
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "Java",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "javA",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "jAva",  category));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenUrlcodeContainsSpaceTest(){
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "j ava",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "java ",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "jav a",  category));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenUrlCodeContainsAccentsTest(){
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "çjava",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "javá",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "jav%",  category));
    }

}
