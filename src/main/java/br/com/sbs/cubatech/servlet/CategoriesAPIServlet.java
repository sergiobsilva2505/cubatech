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
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "CategoriesAPIServlet", value = "/api/categorias")
public class CategoriesAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDao categoryDao = new CategoryDao(entityManager);

        List<Category> categories = categoryDao.findAll();

        List<CategoryDto> categoriesDto = categories.stream().map(CategoryDto::new).collect(Collectors.toList());

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
            response.setStatus(406);
        }
    }
}
