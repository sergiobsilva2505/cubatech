package br.com.sbs.cubatech;


import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryRepository;
import br.com.sbs.cubatech.category.Status;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.course.CourseRepository;
import br.com.sbs.cubatech.course.CourseVisibility;
import br.com.sbs.cubatech.subcategory.SubCategory;
import br.com.sbs.cubatech.subcategory.SubCategoryRepository;

import java.util.Arrays;

public class ProgramingDatabaseMotherTest {


    private CategoryRepository categoryRepository;
    private SubCategoryRepository subCategoryRepository;
    private CourseRepository courseRepository;

    public ProgramingDatabaseMotherTest(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository, CourseRepository courseRepository) {
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.courseRepository = courseRepository;
    }

    public void create() {
        Category category1 = new Category("Programação", "programacao", 1, "Programe nas principais linguagens e plataformas. Iniciantes são bem vindos nos cursos de lógica e JavaScript.", Status.ACTIVE, "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png", "#00c86f");
        Category category2 = new Category("DevOps", "devops", 2, "Aprenda Git. Entenda a entrega contínua. Estude Linux. Gerencie servidores na nuvem. Explore o mundo de Internet das coisas e da robótica.", Status.ACTIVE, "https://www.alura.com.br/assets/api/formacoes/categorias/512/devops-transparent.png", "#f16165");
        Category category3 = new Category("Business", "business", 2, "Agilidade. Práticas de gestão. Vendas. Liderança.", Status.INACTIVE, "https://www.alura.com.br/assets/api/formacoes/categorias/512/inovacao-gestao-transparent.png", "#ff8c2a");

        SubCategory subCategory1 = new SubCategory("Java", "java", 1, "Java é uma grande plataforma presente em todo lugar: de corporações à bancos e governo. Desenvolva aplicações robustas com um back-end e construa APIs.", Status.ACTIVE, category1);
        SubCategory subCategory2 = new SubCategory("Java e Persistência", "java-e-persistencia", 2, null, Status.ACTIVE, category1);
        SubCategory subCategory3 = new SubCategory("PHP", "php", 3, "PHP é uma das linguagens mais utilizadas.", Status.ACTIVE, category1);
        SubCategory subCategory4 = new SubCategory("COBOL", "cobol", null, null, Status.INACTIVE, category1);
        SubCategory subCategory5 = new SubCategory("Builds e Controle de versão", "builds-e-controle-de-versao", 1, "As ferramentas mais utilizadas para desenvolvimento: controle de versão com Git e Github além de build da aplicação através de Maven.", Status.ACTIVE, category2);


        Course course1 = new Course("Git e Github para Sobrevivência", "git-e-github-para-sobrevivencia", 6, CourseVisibility.PUBLIC,"Publico alvo", "Mario souto",  "Emmenta respectiva do curso","descreve as habilidades que serão desenvolvidas durante o curso", subCategory5);
        Course course2 = new Course("Java e JPA: Consultas avançadas performance e modelos complexos", "java-jpa-consultas-avancadas-performance-modelos-complexos", 10, CourseVisibility.PUBLIC,"Publico alvo", "Rodrigo Ferreira",  "Emmenta respectiva do curso","descreve as habilidades que serão desenvolvidas durante o curso", subCategory2);
        Course course3 = new Course("Java OO: Introdução à Orientação a Objetos", "java-introducao-orientacao-objetos", 8, CourseVisibility.PUBLIC,"Publico alvo", "Paulo Silvaira",  "Emmenta respectiva do curso","descreve as habilidades que serão desenvolvidas durante o curso", subCategory1);
        Course course4 = new Course("Java JRE e JDK: Escreva o seu primeiro código com Eclipse", "java-primeiros-passos", 8, CourseVisibility.PUBLIC,"Publico alvo", "Paulo Silvaira",  "Emmenta respectiva do curso","descreve as habilidades que serão desenvolvidas durante o curso", subCategory1);
        Course course5 = new Course("Angular CLI", "angular-cli", 20, CourseVisibility.PRIVATE,"Publico alvo", "Paulo Silvaira",  "Emmenta respectiva do curso","descreve as habilidades que serão desenvolvidas durante o curso", subCategory1);

        category1.addSubCategory(subCategory1);
        category1.addSubCategory(subCategory2);
        category1.addSubCategory(subCategory3);
        category1.addSubCategory(subCategory4);
        category2.addSubCategory(subCategory5);

        subCategory5.addCourse(course1);
        subCategory1.addCourse(course2);
        subCategory1.addCourse(course3);
        subCategory1.addCourse(course4);
        subCategory1.addCourse(course5);

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        subCategoryRepository.saveAll(Arrays.asList(subCategory1, subCategory2, subCategory3, subCategory4, subCategory5));
        courseRepository.saveAll(Arrays.asList(course1, course2, course3, course4, course5));
    }
}
