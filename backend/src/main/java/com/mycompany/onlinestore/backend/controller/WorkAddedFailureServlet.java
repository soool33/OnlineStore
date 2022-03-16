package com.mycompany.onlinestore.backend.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WorkAddedFailureServlet", urlPatterns = "/work-added-failure")
public class WorkAddedFailureServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("<meta charset=\"UTF-8\">");

        String message = "<h1>Une erreur est survenue, l’œuvre n’a pas été ajoutée</h1>";

        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println(("<a href=\"catalogue\">Catalogue des oeuvres</a>"));

        out.println("</body></html>");


    }
}
