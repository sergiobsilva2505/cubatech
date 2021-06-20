package br.com.sbs.cubatech.teste;
import br.com.sbs.cubatech.activity.Alternative;
import br.com.sbs.cubatech.activity.Question;
import br.com.sbs.cubatech.activity.QuestionType;
import br.com.sbs.cubatech.activity.Video;
import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.SubCategory;
import br.com.sbs.cubatech.course.Course;
import br.com.sbs.cubatech.lesson.Lesson;

public class Tests {

    public static void main(String[] args) {

        // validando atrinuto nome
        Category programacao = new Category( "Programação", "category-programacao");

        // validando urlcode
//        Category cat1 = new Category(1L, "Programação", "category-programacaO", "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");
//        Category cat2 = new Category(1L, "Programação", "category/programacao", "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");
//        Category cat3 = new Category(1L, "Programação", "categorY-programacao", "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");
//        Category cat4 = new Category(1L, "Programação", "", "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");
//        Category cat5 = new Category(1L, "Programação", null, "uma descrição bem sucinta", "um guia de estudo, um texto grande e explicativo sobre a categoria", (byte) 0, "c:xyz", "2ECC71");

        SubCategory sub1 = new SubCategory("Nome da sub categoria", "urlcode",  programacao);
//        SubCategory sub2 = new SubCategory(1L, null, "urlcode", false, programacao);
//        SubCategory sub3 = new SubCategory(1L, "Nome da sub categoria", "null", false, programacao);
//        SubCategory sub4 = new SubCategory(1L, "Nome da sub categoria", "urlcode", false, null);

        // validando atributo name
        Course curso1 = new Course("Lógica de programação I: Os primeiros programas com Javascript e HTML", "logica-programacao-javascript-html", 8, "Flavio Henrique de Souza Almeida", sub1);
//        Course curso2 = new Course(2L, "", "logica-programacao-pratica-com-desenho-animacoes-em-jogo", LocalTime.of(10, 00, 00), "Flavio Henrique de Souza Almeida", programacao);
//        Course curso3 = new Course(3L, null, "logica-programacao-pratica-com-desenho-animacoes-em-jogo", LocalTime.of(10, 00, 00), "Flavio Henrique de Souza Almeida", programacao);

        // validando url
//        Course curso4 = new Course(1L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", "logica-programacao-javascript-html", 12, "Flavio Henrique de Souza Almeida", sub1);
//        Course curso5 = new Course(2L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", "logica-programacao-pratica-com&desenho-animacoes-em-jogo", LocalTime.of(10, 00, 00), "Flavio Henrique de Souza Almeida", programacao);
//        Course curso6 = new Course(3L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", "logicA-programacao-pratica-com-desenho-animacoes-em-jogo", LocalTime.of(10, 00, 00), "Flavio Henrique de Souza Almeida", programacao);
//        Course curso7 = new Course(3L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", "", LocalTime.of(10, 00, 00), "Flavio Henrique de Souza Almeida", programacao);
//        Course curso8 = new Course(3L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", null, LocalTime.of(10, 00, 00), "Flavio Henrique de Souza Almeida", programacao);

        // validando nome do instrutor
//        Course curso9 = new Course(1L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", "logica-programacao-javascript-html", 12, "Flavio Henrique de Souza Almeida", sub1);
//        Course curso9 = new Course(1L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", "logica-programacao-javascript-html", LocalTime.of(12, 00, 00), null, programacao);
//        Course curso10 = new Course(1L, "Lógica de programação I: Os primeiros programas com Javascript e HTML", "logica-programacao-javascript-html", LocalTime.of(12, 00, 00), "", programacao);

        // validando name
//        Lesson lesson = new Lesson(2L, "Comece a programar hoje","logica-programacao-javascript-html", null);
//        Lesson lesson1 = new Lesson(1L,"", "logica-programacao-javascript-html",curso4);
//        Lesson lesson2 = new Lesson(1L, null, "logica-programacao-javascript-html",curso4);

        // validando urlcode
        Lesson lesson3 = new Lesson("Comece a programar hoje","logica-programacao-javascrip-html", curso1);
//        Lesson lesson6 = new Lesson(2L, "Comece a programar hoje","logica-prOgramacao-javascriPt-html", curso1);
//        Lesson lesson7 = new Lesson(2L, "Comece a programar hoje","logica-programacao-javAscript-html", curso1);
//        Lesson lesson4 = new Lesson(2L, "Comece a programar hoje","", curso1);
//        Lesson lesson5 = new Lesson(2L, "Comece a programar hoje",null, curso1);

        Question q1 = new Question("um titulo generico", "urlcode", lesson3, "uma descrição");

        Video v1 = new Video("um titulo", "urlcode do video",lesson3, "url");



        Alternative alt1 = new Alternative("um texto explicativo, obrigatório e não vazio", false, q1);


    }
}
