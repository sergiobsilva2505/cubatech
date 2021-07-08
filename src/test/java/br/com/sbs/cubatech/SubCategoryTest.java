package br.com.sbs.cubatech;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubCategoryTest {

    private Category category;

    @BeforeEach
    public void init(){
        this.category = new Category( "Programação", "programacao");
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenUrldeCodeOrNameIsBlankTest(){
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("", "java",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("", "",  category));
    }

    @Test
    public void shouldReturnNullPointerExceptionWhenUrldeCodeOrNameAreNullTest(){
        assertThrows(NullPointerException.class, ()-> new SubCategory(null, "java",  category));
        assertThrows(NullPointerException.class, ()-> new SubCategory("Java", null,  category));
        assertThrows(NullPointerException.class, ()-> new SubCategory(null, null,  category));
    }

    @Test
    public void shouldReturnNullPointerExceptionWhenCategoryIsNullTest(){
        assertThrows(NullPointerException.class, ()-> new SubCategory("Java", "java",  null));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenUrlcodeContainsUppercaseLettersTest(){
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "Java",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "javA",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "jAva",  category));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenUrlcodeContainsSpaceTest(){
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "j ava",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "java ",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "jav a",  category));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenUrlCodeContainsAccentsTest(){
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "çjava",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "javá",  category));
        assertThrows(IllegalArgumentException.class, ()-> new SubCategory("Java", "jav%",  category));
    }


}
