package br.com.sbs.cubatech.teste;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.course.Course;

import java.time.LocalTime;

public class Tests {

    public static void main(String[] args) {

        // validando atrinuto nome
        Category programacao = new Category(1L, "Programação", "category-programacao", "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");
//        Category programacao1 = new Category(1L, "", "category-programacao", "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");
//        Category programacao2 = new Category(1L, null, "category-programacao", "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");

        // validando urlcode
//        Category cat1 = new Category(1L, "Programação", "category-programacaO", "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");
//        Category cat2 = new Category(1L, "Programação", "category/programacao", "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");
//        Category cat3 = new Category(1L, "Programação", "categorY-programacao", "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");
//        Category cat4 = new Category(1L, "Programação", "", "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");
//        Category cat5 = new Category(1L, "Programação", null, "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");

        // validando atributo name
        Course curso1 = new Course(1L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", "logica-programacao-javascript-html", LocalTime.of(12, 00, 00), "Flavio Henrique de Souza Almeida", programacao);
//        Course curso2 = new Course(2L, "", "logica-programacao-pratica-com-desenho-animacoes-em-jogo", LocalTime.of(10, 00, 00), "Flavio Henrique de Souza Almeida", programacao);
//        Course curso3 = new Course(3L, null, "logica-programacao-pratica-com-desenho-animacoes-em-jogo", LocalTime.of(10, 00, 00), "Flavio Henrique de Souza Almeida", programacao);

        // validando url
        Course curso4 = new Course(1L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", "logica-programacao-javascript-html", LocalTime.of(12, 00, 00), "Flavio Henrique de Souza Almeida", programacao);
//        Course curso5 = new Course(2L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", "logica-programacao-pratica-com&desenho-animacoes-em-jogo", LocalTime.of(10, 00, 00), "Flavio Henrique de Souza Almeida", programacao);
//        Course curso6 = new Course(3L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", "logicA-programacao-pratica-com-desenho-animacoes-em-jogo", LocalTime.of(10, 00, 00), "Flavio Henrique de Souza Almeida", programacao);
//        Course curso7 = new Course(3L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", "", LocalTime.of(10, 00, 00), "Flavio Henrique de Souza Almeida", programacao);
//        Course curso8 = new Course(3L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", null, LocalTime.of(10, 00, 00), "Flavio Henrique de Souza Almeida", programacao);

        // validando nome do instrutor
//        Course curso9 = new Course(1L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", "logica-programacao-javascript-html", LocalTime.of(12, 00, 00), "", programacao);
        Course curso9 = new Course(1L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", "logica-programacao-javascript-html", LocalTime.of(12, 00, 00), null, programacao);


    }
}
