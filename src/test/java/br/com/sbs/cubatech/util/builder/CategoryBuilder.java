package br.com.sbs.cubatech.util.builder;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;

public class CategoryBuilder {

    private String name;
    private String urlCode;
    private String description;
    private String studyGuide;
    private Status status;
    private Integer orderInSystem;
    private String iconPath;
    private String colorCode;

    public CategoryBuilder(String name, String urlCode){
        this.name = name;
        this.urlCode = urlCode;
    }

    public CategoryBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public CategoryBuilder withStudyGuide(String studyGuide){
        this.studyGuide = studyGuide;
        return this;
    }

    public CategoryBuilder withStatus(Status status){
        this.status = status;
        return this;
    }

    public CategoryBuilder withOrderInSystem(Integer orderInSystem){
        this.orderInSystem = orderInSystem;
        return this;
    }

    public CategoryBuilder withIconPath(String iconPath){
        this.iconPath = iconPath;
        return this;
    }

    public CategoryBuilder withColorCode(String colorCode){
        this.colorCode = colorCode;
        return this;
    }

    public Category create(){
        return new Category(name, urlCode, description, studyGuide, status, orderInSystem, iconPath, colorCode) ;
    }

    public static Category category1(){
        Category programacao = new CategoryBuilder("Programação", "programacao")
                .withOrderInSystem(1)
                .withDescription("Programe nas principais linguagens e plataformas. Iniciantes são bem vindos nos cursos de lógica e JavaScript.")
                .withStatus(Status.ACTIVE)
                .withIconPath("https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png")
                .withColorCode("#00c86f")
                .create();
        return programacao;
    }

    public static Category category2(){
        Category devops = new CategoryBuilder("DevOps", "devops")
                .withOrderInSystem(2)
                .withDescription("Aprenda Git. Entenda a entrega contínua. Estude Linux. Gerencie servidores na nuvem. Explore o mundo de Internet das coisas e da robótica.")
                .withStatus(Status.ACTIVE)
                .withIconPath("https://www.alura.com.br/assets/api/formacoes/categorias/512/devops-transparent.png")
                .withIconPath("#f16165")
                .create();
        return devops;
    }

    public static Category category3(){
        Category business = new CategoryBuilder("Business", "business")
                .withOrderInSystem(2)
                .withDescription("Agilidade. Práticas de gestão. Vendas. Liderança.")
                .withStatus(Status.INACTIVE)
                .withIconPath("https://www.alura.com.br/assets/api/formacoes/categorias/512/inovacao-gestao-transparent.png")
                .withIconPath("#ff8c2a")
                .create();
        return business;
    }



}
