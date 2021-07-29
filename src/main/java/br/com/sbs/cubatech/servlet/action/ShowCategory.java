package br.com.sbs.cubatech.servlet.action;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryDao;
import br.com.sbs.cubatech.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowCategory implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("Show Category");

        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        String paramId = request.getParameter("id");
        Long id = Long.parseLong(paramId);

        Category category = categoryDao.findById(id);

        request.setAttribute("category", category);

//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/formAlteraCategoria.jsp");
//        requestDispatcher.forward(request, response);
        return "forward:formAlteraCategoria.jsp";
    }
}
