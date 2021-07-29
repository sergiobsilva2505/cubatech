package br.com.sbs.cubatech.servlet;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryDao;
import br.com.sbs.cubatech.category.Status;
import br.com.sbs.cubatech.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddCategoryServlet", value = "/adicionaCategoria")
public class AddCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/formNovaCategoria.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
