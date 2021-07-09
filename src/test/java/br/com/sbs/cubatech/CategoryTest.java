package br.com.sbs.cubatech;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;
import br.com.sbs.cubatech.category.SubCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

        assertEquals(4, subCategories.size());
        assertEquals("java", subCategories.get(0).getUrlCode());
        assertEquals("java-e-persistencia", subCategories.get(1).getUrlCode());
        assertEquals("php", subCategories.get(2).getUrlCode());
        assertEquals("cobol", subCategories.get(3).getUrlCode());
    }

    @Test
    void shouldReturnOnlyActiveSubCategories(){
        Category category = programmingCategory();

        List<SubCategory> activeSubCategories = category.getActiveSubCategories();

        assertEquals(3, activeSubCategories.size());
        assertEquals("java", activeSubCategories.get(0).getUrlCode());
        assertEquals("java-e-persistencia", activeSubCategories.get(1).getUrlCode());
        assertEquals("php", activeSubCategories.get(2).getUrlCode());
    }

    private Category programmingCategory() {
        Category category = new Category("Programação", "programacao", 1, "Programe nas principais linguagens e plataformas. Iniciantes são bem vindos nos cursos de lógica e JavaScript.", Status.ATIVA, "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png", "#00c86f");

        category.addSubCategory(new SubCategory("Java", "java", 1, "Java é uma grande plataforma presente em todo lugar: de corporações à bancos e governo. Desenvolva aplicações robustas com um back-end e construa APIs.", Status.ATIVA, category));
        category.addSubCategory(new SubCategory("Java e Persistência", "java-e-persistencia", 2, null, Status.ATIVA, category));
        category.addSubCategory(new SubCategory("PHP", "php", 3, "PHP é uma das linguagens mais utilizadas.", Status.ATIVA, category));
        category.addSubCategory(new SubCategory("COBOL", "cobol", null, null, Status.INATIVA, category));
        return category;
    }

}
