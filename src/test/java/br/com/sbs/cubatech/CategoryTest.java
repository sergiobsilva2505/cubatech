package br.com.sbs.cubatech;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;
import br.com.sbs.cubatech.category.SubCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    private Category cat1;
    private List<SubCategory> subCategories;

    @BeforeEach
    public void init(){
        this.cat1 = new Category("Programação", "programacao", 1, "Programe nas principais linguagens e plataformas. Iniciantes são bem vindos nos cursos de lógica e JavaScript.", Status.ATIVA, "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png", "#00c86f");
        this.subCategories = Arrays.asList(
                new SubCategory("Java","java",1,"Java é uma grande plataforma presente em todo lugar: de corporações à bancos e governo. Desenvolva aplicações robustas com um back-end e construa APIs.", Status.ATIVA, this.cat1),
                new SubCategory("Java e Persistência","java-e-persistencia",2,null,Status.ATIVA,this.cat1),
                new SubCategory("PHP","php",3,"PHP é uma das linguagens mais utilizadas.",Status.ATIVA,this.cat1),
                new SubCategory("COBOL","cobol",null,null,Status.INATIVA,this.cat1)
        );
        this.cat1.setSubCategories(this.subCategories);
    }

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

    @Test
    public void shouldReturnOnlyTestActiveSubCategoriesTest(){
        assertEquals(4, cat1.getSubCategories().size());
        assertEquals(3, cat1.getActiveSubCategories().size());
    }

}
