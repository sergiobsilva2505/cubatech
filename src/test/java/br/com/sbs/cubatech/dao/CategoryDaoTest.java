package br.com.sbs.cubatech.dao;

import br.com.sbs.cubatech.builder.CategoryBuilder;
import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryDao;
import br.com.sbs.cubatech.util.JPAUtilTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryDaoTest {

    private EntityManager entityManager;

    private CategoryDao categoryDao;

    @BeforeEach
    void setUp() {
        this.entityManager = JPAUtilTest.getEntityManager();
        this.categoryDao = new CategoryDao(entityManager);
        entityManager.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        this.entityManager.getTransaction().rollback();
    }

    @Test
    void shouldReturnListActiveCategory(){
        aCategoryActive("Programação", "programacao");
        aCategoryActive("Devops", "devops");
        aCategoryInactive("Mobile", "mobile");
        List<Category> categoryList = categoryDao.getActiveCategory();
        assertThat(categoryList)
                .hasSize(2)
                .extracting(Category::getUrlCode)
                .contains("programacao", "devops");
    }

    private void aCategoryInactive(String name, String urlCode){
        Category category = new CategoryBuilder(name, urlCode)
                .inactive()
                .build();
        entityManager.persist(category);
    }

    private void aCategoryActive(String name, String urlCode){
        Category category = new CategoryBuilder(name, urlCode)
                .active()
                .build();
        entityManager.persist(category);
    }
}
