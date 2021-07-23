package br.com.sbs.cubatech.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OlaMundoServlet", value = "/olaMundo")
public class OlaMundoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h3>Yes it works!</h3>");
        out.println("</body>");
        out.println("</html>");

    }


}
