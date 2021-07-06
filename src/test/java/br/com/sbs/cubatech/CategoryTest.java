package br.com.sbs.cubatech;

import br.com.sbs.cubatech.category.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenNameIsBlankTest(){
        assertThrows(IllegalArgumentException.class, ()-> new Category("", "programacao"));
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", ""));
    }

    @Test
    public void shouldReturnNullPointerExceptionWhenNameOrUrlCodeIsNullTest(){
        assertThrows(NullPointerException.class, ()-> new Category(null, "programacao"));
        assertThrows(NullPointerException.class, ()-> new Category("Programação", null));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenUrlCodeContainsUppercaseCharactersTest (){
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "prograMacao"));
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "Programacao"));
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "programacaO"));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenUrlCodeContainsAccentsOrSpecialCharactersTest(){
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "programaçao"));
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "programacão"));
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "programação"));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenUrlCodeContainsSpacesTest(){
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "progr amacao"));
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "pr ogramacao"));
        assertThrows(IllegalArgumentException.class, ()-> new Category("Programação", "programaca o"));
    }

}
