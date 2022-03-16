package com.mycompany.onlinestore.backend.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WorkAddedSuccessServlet", urlPatterns = "/work-added-success")
public class WorkAddedSuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<meta charset=\"UTF-8\">");
        String message = "<h1>L’œuvre à bien été ajoutée</h1><br/>";


        out.println("<html><body>");
        out.println("<h1>" + message + "</h1><br>");
        out.println("L'id de l'oeuvre ajoutée est " + request.getAttribute("identifiantOeuvre") + " .<br/>");
        out.println(("<a href=\"catalogue\">Catalogue des oeuvres</a>"));

        out.println("</body></html>");
    }
}
