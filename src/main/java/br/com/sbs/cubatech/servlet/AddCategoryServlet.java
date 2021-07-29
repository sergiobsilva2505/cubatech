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

@WebServlet(name = "AddCategoryServlet", value = "/adicionarCategoria")
public class AddCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/formNovaCategoria.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.setCharacterEncoding("UTF-8");

        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        String name = request.getParameter("name");
        String urlCode = request.getParameter("urlCode");
        String paramOrderInSystem = request.getParameter("orderInSystem");
        Integer orderInSystem = Integer.parseInt(paramOrderInSystem);
        String description = request.getParameter("description");
        Status status = request.getParameter("status").equals("ACITVE") ? Status.ACTIVE : Status.INACTIVE ;
        String iconPath = request.getParameter("iconPath");
        String colorCode = request.getParameter("colorCode");

        Category category = new Category(name, urlCode, orderInSystem, description, status, iconPath, colorCode);

        entityManager.getTransaction().begin();
        categoryDao.save(category);
        entityManager.getTransaction().commit();
        entityManager.close();

        response.sendRedirect("/listaCategorias");
    }
}
