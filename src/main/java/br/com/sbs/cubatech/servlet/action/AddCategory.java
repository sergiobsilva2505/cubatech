package br.com.sbs.cubatech.servlet.action;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryDao;
import br.com.sbs.cubatech.category.Status;
import br.com.sbs.cubatech.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCategory implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");

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

//        response.sendRedirect("entrada?acao=CategoryList");

        return "redirect:entrada?acao=CategoryList";
    }
}
