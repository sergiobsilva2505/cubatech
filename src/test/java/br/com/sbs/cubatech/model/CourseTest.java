package br.com.sbs.cubatech.model;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.subcategory.SubCategory;
import br.com.sbs.cubatech.course.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CourseTest {

    private Category programacao;
    private SubCategory subCategory;

    @BeforeEach
    void init(){
        this.programacao = new Category( "Programação", "programacao");
        this.subCategory = new SubCategory("Programacao", "java",  programacao);
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenNameOrUrlCodeIsBlank(){
        assertThrows(IllegalArgumentException.class, ()-> new Course("", "git-e-github-para-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("", "", 6, "Mario Souto", subCategory));
    }

    @Test
    void shouldReturnNullPointerExceptionWhenNameOrUrlCodeIsNull(){
        assertThrows(NullPointerException.class, ()-> new Course(null, "git-e-github-para-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(NullPointerException.class, ()-> new Course("Git e Github para Sobrevivência", null, 6, "Mario Souto", subCategory));
        assertThrows(NullPointerException.class, ()-> new Course(null, null, 6, "Mario Souto", subCategory));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenUrlCodeIsUppercase(){
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "Git-e-github-para-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-E-github-para-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-githUb-para-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobreviVencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivencIa", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-Para-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-Para-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "Git-e-github-Para-sobrevivEncia", 6, "Mario Souto", subCategory));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenUrlcodeHasAccentsOrSpecialCharacters(){
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "@it-e-github-para-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-é-github-para-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-gith&b-para-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevi?encia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivenc/a", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-\\ara-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-õara-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "+it-e-github-<ara-sobreviv>ncia", 6, "Mario Souto", subCategory));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenUrlcodeHasBlankSpaces(){
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", " it-e-github-para-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git- -github-para-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-gith b-para-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevi encia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivenc a", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github- ara-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github- ara-sobrevivencia", 6, "Mario Souto", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", " it-e-github- ara-sobrevivncia", 6, "Mario Souto", subCategory));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenInstructorNameIsEmpty(){
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivencia", 6, "", subCategory));
    }

    @Test
    void shouldReturnNullPointerExceptionWhenInstructorNameIsNull(){
        assertThrows(NullPointerException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivencia", 6, null, subCategory));
    }

    @Test
    void shouldReturnNullPointerExceptionWhenSubCategoryIsNull(){
        assertThrows(NullPointerException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivencia", 6, "Nico Steppat", null));
    }

    @Test
    void shouldReturnIllegalArgumentExceptionWhenTotalCourseHoursIsLessThanLowerLimitOrGreaterThanUpperLimit(){
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivencia", 0, "Nico Steppat", subCategory));
        assertThrows(IllegalArgumentException.class, ()-> new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivencia", 21, "Nico Steppat", subCategory));
    }

}
