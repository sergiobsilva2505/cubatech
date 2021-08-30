package br.com.sbs.cubatech.util.builder;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;
import br.com.sbs.cubatech.subcategory.SubCategory;

public class SubCategoryBuilder {

    private String name;
    private String urlCode;
    private String description;
    private String studyGuide;
    private Integer orderInSystem;
    private Status status;
    private Category category;

    public SubCategoryBuilder(String name, String urlCode, Category category){
        this.name = name;
        this.urlCode = urlCode;
        this.category = category;
    }

    public SubCategoryBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public SubCategoryBuilder withStudyGuide(String studyGuide){
        this.studyGuide = studyGuide;
        return this;
    }

    public SubCategoryBuilder withOrderInSystem(Integer orderInSystem){
        this.orderInSystem = orderInSystem;
        return this;
    }

    public SubCategoryBuilder withStatus(Status status){
        this.status = status;
        return this;
    }

    private SubCategory create() {
        return new SubCategory(name, urlCode,  orderInSystem, description, studyGuide, status, category);
    }

    public static SubCategory subCategory1(Category category){
        SubCategory java = new SubCategoryBuilder("Java",
                "java",
                category)
                .withOrderInSystem(1)
                .withDescription("Java é uma grande plataforma presente em todo lugar: de corporações à bancos e governo. Desenvolva aplicações robustas com um back-end e construa APIs.")
                .withStatus(Status.ACTIVE)
                .create();
        return java;
    }

    public static SubCategory subCategory2(Category category){
        SubCategory javaEPersistencia = new SubCategoryBuilder("Java e Persistência", "java-e-persistencia", category)
                .withOrderInSystem(1)
                .withStatus(Status.ACTIVE)
                .create();
        return javaEPersistencia;
    }

    public static SubCategory subCategory3(Category category){
        SubCategory php = new SubCategoryBuilder("PHP", "php", category)
                .withOrderInSystem(3)
                .withDescription("PHP é uma das linguagens mais utilizadas.")
                .withStatus(Status.ACTIVE)
                .create();
        return php;
    }

    public static SubCategory subCategory4(Category category){
        SubCategory cobol = new SubCategoryBuilder("COBOL", "cobol", category)
                .withStatus(Status.INACTIVE)
                .create();
        return cobol;
    }

    public static SubCategory subCategory5(Category category){
        SubCategory buildsEControleDeVersao = new SubCategoryBuilder("Builds e Controle de versão", "builds-e-controle-de-versao",category)
                .withOrderInSystem(1)
                .withDescription("Builds e Controle de versão")
                .withStatus(Status.ACTIVE)
                .create();
        return buildsEControleDeVersao;
    }


}

