package br.com.sbs.cubatech.servlet;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryDao;
import br.com.sbs.cubatech.category.EditCategoryForm;
import br.com.sbs.cubatech.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateCategoryServlet", value = "/atualizaCategoria")
public class UpdateCategoryServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.setCharacterEncoding("UTF-8");

        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        String paramId = request.getParameter("id");
        Long id = Long.parseLong(paramId);

        String name = request.getParameter("name");
        String urlCode = request.getParameter("urlCode");
        String paramOrderInSystem = request.getParameter("orderInSystem");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        String iconPath = request.getParameter("iconPath");
        String colorCode = request.getParameter("colorCode");

        EditCategoryForm editCategoryForm = new EditCategoryForm(name, urlCode, paramOrderInSystem, description, status, iconPath, colorCode);

        Category category = categoryDao.findById(id);

        category.toUpdate(editCategoryForm);

        entityManager.getTransaction().begin();
        categoryDao.update(category);
        entityManager.getTransaction().commit();

        response.sendRedirect("/listaCategorias");

    }
}
