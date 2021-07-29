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

@WebServlet(name = "ShowCategoryServlet", value = "/editaCategoria")
public class ShowCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");

        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        String paramId = request.getParameter("id");
        Long id = Long.parseLong(paramId);

        Category category = categoryDao.findById(id);

        request.setAttribute("category", category);
        request.setAttribute("statusValues", Status.values());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/formAlteraCategoria.jsp");
        requestDispatcher.forward(request, response);

    }


}
