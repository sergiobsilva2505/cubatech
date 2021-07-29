package br.com.sbs.cubatech.dao;

import br.com.sbs.cubatech.builder.CategoryBuilder;
import br.com.sbs.cubatech.builder.SubCategoryBuilder;
import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.category.SubCategoryDao;
import br.com.sbs.cubatech.util.JPAUtilTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SubCategoryDaoTest {

    private EntityManager entityManager;

    private SubCategoryDao subCategoryDao;
    private Category category;

    @BeforeEach
    void setUp() {
        this.entityManager = JPAUtilTest.getEntityManager();
        this.subCategoryDao = new SubCategoryDao(entityManager);
        entityManager.getTransaction().begin();
        this.category = aCategoryActive("Programação", "programacao");
    }

    @AfterEach
    void tearDown() {
        this.entityManager.getTransaction().rollback();
    }

    @Test
    void shouldReturnListOfActiveSubCategories(){
        aSubCategoryActive("Java", "java", category);
        aSubCategoryActive("Java e  persistencia", "java-e-persistencia", category);
        aSubCategoryActive("PHP", "php", category);
        aSubCategoryActive("Builds", "builds-e-controle-de-versao", category);
        aSubCategoryInactive("JavaScript", "javascript", category);
        List<SubCategory> subCategoryList = subCategoryDao.findAllByStatusActiveOrderByOrderInSystemAsc();
        assertThat(subCategoryList)
                .hasSize(4)
                .extracting(SubCategory::getUrlCode)
                .contains("java", "java-e-persistencia", "php", "builds-e-controle-de-versao");

    }

    @Test
    void shouldReturnListSubCategoryWithDescriptionNullOrEmpty(){
        aSubCategoryActive("Cobol", "cobol", category);
        aSubCategoryWithDescription("Java e persistencia", "java-e-persistencia", category, "");
        aSubCategoryWithDescription("Builds", "builds-e-controle-de-versao", category, "Lorem Ipsulum");
        List<SubCategory> subCategoryList = subCategoryDao.findAllByDescriptionIsNullOrEmpty();
        assertThat(subCategoryList)
                .hasSize(2)
                .extracting(SubCategory::getUrlCode)
                .contains("java-e-persistencia", "cobol");
    }

    private void aSubCategoryActive(String name, String urlCode, Category category){
        SubCategory subCategory = new SubCategoryBuilder(name, urlCode, category).active().build();
        entityManager.persist(subCategory);
    }

    private void aSubCategoryInactive(String name, String urlCode, Category category){
        SubCategory subCategory = new SubCategoryBuilder(name, urlCode, category).inactive().build();
        entityManager.persist(subCategory);
    }

    private void aSubCategoryWithDescription(String name, String urlCode, Category category, String description){
        SubCategory subCategory = new SubCategoryBuilder(name, urlCode, category)
                .active()
                .withDescription(description)
                .build();
        entityManager.persist(subCategory);
    }

    private Category aCategoryActive(String name, String urlCode){
        Category category = new CategoryBuilder(name, urlCode)
                .active()
                .build();
        entityManager.persist(category);
        return category;
    }
}
