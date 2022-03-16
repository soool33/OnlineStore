package com.mycompany.onelinestore.frontend.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServletTest", urlPatterns = "/test2")
public class ModeleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String nombre1 = request.getParameter("nombre1");
        Integer nombre2 = Integer.parseInt(request.getParameter("nombre2"));

        PrintWriter out = response.getWriter();
        String message = "Online Store, votre boutique en ligne (Frontend)";

        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        out.println(("<a href=\"catalogue\">Catalogue des oeuvres</a>"));
        out.println("</body></html>");
    }
}
