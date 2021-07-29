package br.com.sbs.cubatech.servlet.action;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryDao;
import br.com.sbs.cubatech.servlet.EditCategoryForm;
import br.com.sbs.cubatech.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCategory implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");

        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        String paramId = request.getParameter("id");
        Long id = Long.parseLong(paramId);

        String name = request.getParameter("name");
        String urlCode = request.getParameter("urlCode");
        String paramOrderInSystem = request.getParameter("orderInSystem");
        String description = request.getParameter("description");
//        String status = request.getParameter("status");
        String iconPath = request.getParameter("iconPath");
        String colorCode = request.getParameter("colorCode");

        EditCategoryForm editCategoryForm = new EditCategoryForm(name, urlCode, paramOrderInSystem, description, iconPath, colorCode);

        Category category = categoryDao.findById(id);

        category.toUpdate(editCategoryForm);

        entityManager.getTransaction().begin();
        categoryDao.update(category);
        entityManager.getTransaction().commit();

//        response.sendRedirect("entrada?acao=CategoryList");

        return "redirect:entrada?acao=CategoryList";
    }
}
