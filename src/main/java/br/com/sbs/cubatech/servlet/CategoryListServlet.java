package br.com.sbs.cubatech.servlet;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryDao;
import br.com.sbs.cubatech.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/listaCategorias")
public class CategoryListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        List<Category> categoryList = categoryDao.getAllCategories();

        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html><body>");
        printWriter.println("<h1>Lista de Categorias</h1>");
        printWriter.println("<ul>");
        for (Category category : categoryList ) {
            printWriter.println("<li> " + category + "</li>");
        }
        printWriter.println("</ul>");
        printWriter.println("<a href=\"index.jsp\">Index</a>");
        printWriter.println("</body></html>");

        printWriter.close();
        entityManager.close();
    }
}
