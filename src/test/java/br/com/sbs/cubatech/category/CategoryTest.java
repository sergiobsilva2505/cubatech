package br.com.sbs.cubatech.category;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;
import br.com.sbs.cubatech.subcategory.SubCategory;
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
        Category category = new Category("Programação", "programacao", 1, "Programe nas principais linguagens e plataformas. Iniciantes são bem vindos nos cursos de lógica e JavaScript.", Status.ACTIVE, "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png", "#00c86f");

        new SubCategory("Java", "java", 1, "Java é uma grande plataforma presente em todo lugar: de corporações à bancos e governo. Desenvolva aplicações robustas com um back-end e construa APIs.", Status.ACTIVE, category);
        new SubCategory("Java e Persistência", "java-e-persistencia", 2, null, Status.ACTIVE, category);
        new SubCategory("PHP", "php", 3, "PHP é uma das linguagens mais utilizadas.", Status.ACTIVE, category);
        new SubCategory("COBOL", "cobol", null, null, Status.INACTIVE, category);
        return category;
    }

}
