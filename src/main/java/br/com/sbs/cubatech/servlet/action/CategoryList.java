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
import java.util.List;

public class CategoryList implements Action {

     public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         request.setCharacterEncoding("UTF-8");
         EntityManager entityManager = JPAUtil.getEntityManager();
         CategoryDao categoryDao = new CategoryDao(entityManager);

         List<Category> categoryList = categoryDao.getAllCategories();

         request.setAttribute("categories", categoryList);

         return "forward:listaCategorias2.jsp";
     }

}
