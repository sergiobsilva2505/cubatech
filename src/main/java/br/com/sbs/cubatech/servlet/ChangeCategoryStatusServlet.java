package br.com.sbs.cubatech.servlet;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryDao;
import br.com.sbs.cubatech.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChangeCategoryStatusServlet", value = "/alteraStatusCategoria")
public class ChangeCategoryStatusServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        String paramId = request.getParameter("id");
        Long id = Long.parseLong(paramId);
        Category category = categoryDao.findById(id);

        category.toggleStatus();

        entityManager.getTransaction().begin();
        categoryDao.update(category);
        entityManager.getTransaction().commit();

        response.sendRedirect("listaCategorias");

    }
}
