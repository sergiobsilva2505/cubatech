package br.com.sbs.cubatech.servlet;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryDao;
import br.com.sbs.cubatech.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CategoryListScripletServlet", value = "/listaCategoriasScriptlet")
public class CategoryListScripletServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        List<Category> categoryList = categoryDao.getAllCategories();

        request.setAttribute("categories", categoryList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/listaCategoriasScriptlet.jsp");
        requestDispatcher.forward(request, response);

        entityManager.close();
    }
}
