package br.com.sbs.cubatech.servlet;

import br.com.sbs.cubatech.servlet.action.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SingleEntranceServlet", value = "/entrada")
public class SingleEntranceServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramAction = request.getParameter("acao");

        String className = "br.com.sbs.cubatech.servlet.action." + paramAction;

        String name = null;

        try {
            Class classe = Class.forName(className);
            Action action = (Action) classe.newInstance();
            name = action.execute(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }

        String[] typeAndAddress = name.split(":");
        if (typeAndAddress[0].equals("forward")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/" +typeAndAddress[1]);
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect(typeAndAddress[1]);
        }







    }
}
