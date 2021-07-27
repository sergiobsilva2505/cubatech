package br.com.sbs.cubatech.servlet;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryDao;
import br.com.sbs.cubatech.category.Status;
import br.com.sbs.cubatech.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateCategoryServlet", value = "/alteraCategoria")
public class UpdateCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        String paramId = request.getParameter("id");
        Long id = Long.parseLong(paramId);

        Category category = categoryDao.findById(id);

        category.setName(request.getParameter("name"));
        category.setUrlCode(request.getParameter("urlCode"));
        String paramOrderInSystem = request.getParameter("orderInSystem");
        Integer orderInSystem = Integer.parseInt(paramOrderInSystem);
        category.setOrderInSystem(orderInSystem);
        category.setDescription(request.getParameter("description"));
        String status = request.getParameter("status");
        if (status.equals("ACTIVE")){
            category.setStatus(Status.ACTIVE);
        }
        if (status.equals("INACTIVE")){
            category.setStatus(Status.INACTIVE);
        }
        category.setIconPath(request.getParameter("iconPath"));
        category.setColorCode(request.getParameter("colorCode"));

        entityManager.getTransaction().begin();
        categoryDao.update(category);
        entityManager.getTransaction().commit();

        response.sendRedirect("listaCategorias");

    }
}
