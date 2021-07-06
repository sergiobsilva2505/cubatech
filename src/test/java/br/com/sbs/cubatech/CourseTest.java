package br.com.sbs.cubatech;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    private Category programacao;
    private SubCategory sub1;

    @BeforeEach
    public void init(){
        this.programacao = new Category( "Programação", "programacao");
        this.sub1 = new SubCategory("Programacao", "java",  programacao);
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenNameOrUrlCodeIsBlankTest(){
        assertThrows(IllegalArgumentException.class, ()-> new Course("", "git-e-github-para-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("", "", 6, "Mario Souto", sub1));
    }

    @Test
    public void shouldReturnNullPointerExceptionWhenNameOrUrlCodeIsNullTest(){
        assertThrows(NullPointerException.class, ()-> new Course(null, "git-e-github-para-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(NullPointerException.class, ()-> new Course("Git e Github para Sobrevivência", null, 6, "Mario Souto", sub1));
        assertThrows(NullPointerException.class, ()-> new Course(null, null, 6, "Mario Souto", sub1));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenUrlCodeIsUppercaseTest(){
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "Git-e-github-para-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-E-github-para-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-githUb-para-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobreviVencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivencIa", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-Para-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-Para-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "Git-e-github-Para-sobrevivEncia", 6, "Mario Souto", sub1));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenUrlcodeHasAccentsOrSpecialCharactersTest(){
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "@it-e-github-para-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-é-github-para-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-gith&b-para-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevi?encia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivenc/a", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-\\ara-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-õara-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "+it-e-github-<ara-sobreviv>ncia", 6, "Mario Souto", sub1));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenUrlcodeHasBlankSpacesTest(){
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", " it-e-github-para-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git- -github-para-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-gith b-para-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevi encia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivenc a", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github- ara-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github- ara-sobrevivencia", 6, "Mario Souto", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", " it-e-github- ara-sobrevivncia", 6, "Mario Souto", sub1));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenInstructorNameIsEmptyTest(){
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivencia", 6, "", sub1));
    }

    @Test
    public void shouldReturnNullPointerExceptionWhenInstructorNameIsNullTest(){
        assertThrows(NullPointerException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivencia", 6, null, sub1));
    }

    @Test
    public void shouldReturnNullPointerExceptionWhenSubCategoryIsNullTest(){ // todo perguntar se deveria ser mesmo Null poiter
        assertThrows(NullPointerException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivencia", 6, "Nico Steppat", null));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenTotalCourseHoursIsLessThanOneOrGreaterThanTwentyTest(){
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivencia", 0, "Nico Steppat", sub1));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivencia", 21, "Nico Steppat", sub1));
    }

}
