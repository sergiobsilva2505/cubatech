package br.com.sbs.cubatech.category.api;

import br.com.sbs.cubatech.category.CategoryRepository;
import br.com.sbs.cubatech.course.CourseRepository;
import br.com.sbs.cubatech.subcategory.SubCategoryRepository;
import br.com.sbs.cubatech.util.ProgramingDatabaseMotherTest;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;

import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CategoryApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    @Test
    public void shouldReturnStatus200ForRequestGetApiCategoriesReturnJson() throws Exception {

        ProgramingDatabaseMotherTest programingDatabaseMotherTest = new ProgramingDatabaseMotherTest(categoryRepository, subCategoryRepository, courseRepository);
        programingDatabaseMotherTest.create();

        URI uri = new URI("/api/categories");
        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].urlCode").value("programacao"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].urlCode").value("devops"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subCategories", hasSize(4)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subCategories[0].urlCode").value("java"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subCategories[3].urlCode").value("cobol"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subCategories[1].courses", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subCategories[1].courses[0].urlCode").value("java-jpa-consultas-avancadas-performance-modelos-complexos"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].subCategories[1].courses[0].name")
                        .value("Java e JPA: Consultas avançadas performance e modelos complexos"));

    }

    @Test
    public void shouldReturnStatus200ForRequestGetApiCategoriesReturnXml() throws Exception {
        URI uri = new URI("/api/categories");
        mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void clearCache() throws Exception {
        URI uri = new URI("/bGltcGEtby1jYWNoZS1kYS1hcGktYWU");
       mockMvc.perform(MockMvcRequestBuilders
                       .get(uri)
                       .accept(MediaType.APPLICATION_JSON)
                       .accept(MediaType.APPLICATION_JSON))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }
}