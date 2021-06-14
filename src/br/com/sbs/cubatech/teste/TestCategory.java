package br.com.sbs.cubatech.teste;

import br.com.sbs.cubatech.model.Category;

public class TestCategory {

    public static void main(String[] args) {

        Category programacao = new Category(1L, "Programação", "category/programacao", "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");
//        Category programacao = new Category(1L, "", "category/programacao", "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");
//        Category programacao = new Category(1L, null, "category/programacao", "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");
        Category frontEnd = new Category(2L, "Front-end");
        Category dataScience = new Category(3L, "Data Science");
        Category devOps = new Category(4L, "DevOps");
        Category uxDesign = new Category(5L, "Ux & Design");
        Category mobile = new Category(6L, "Mobile");



    }
}
