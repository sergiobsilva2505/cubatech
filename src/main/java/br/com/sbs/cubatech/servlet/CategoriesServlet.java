package br.com.sbs.cubatech.servlet;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.CategoryDao;
import br.com.sbs.cubatech.category.CategoryDto;
import br.com.sbs.cubatech.util.JPAUtil;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CategoriesServlet", value = "/api/categorias")
public class CategoriesServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        List<Category> categories = categoryDao.getAllCategories();
        List<CategoryDto> categoriesDto = new ArrayList<>();
        for (Category category : categories) {
            categoriesDto.add(new CategoryDto(category));
        }

        String valor = request.getHeader("Accept");

        if (valor.contains("xml")){
            XStream xStream = new XStream();
            xStream.alias("Category", CategoryDto.class);
            String xml = xStream.toXML(categoriesDto);
            response.setContentType("application/xml");
            response.getWriter().print(xml);
        } else if(valor.contains("json")){
            Gson gson = new Gson();
            String json = gson.toJson(categoriesDto);
            response.setContentType("application/json");
            response.getWriter().print(json);
        } else {
            response.setContentType("application/json");
            response.getWriter().print("{'message':'no content'}");
        }
    }
}
