package com.mycompany.onlinestore.backend.controller;

import com.mycompany.onlinestore.backend.entity.Catalogue;
import com.mycompany.onlinestore.backend.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WorkDetailServlet", urlPatterns = "/work-details")
public class WorkDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Long id = Long.parseLong(request.getParameter("id"));

        Work work = null;

        for (Work work1 : Catalogue.listOfWorks){
            if (id == work1.getId()){
                work = work1;
                break;
            }
        }

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1 style = 'color:red;' >Descriptif de l'oeuvre </h1>");
        out.println("Titre : " + work.getTitle() + "</BR></BR>");
        out.println("Année de parution : " + work.getRelease() + "</BR></BR>");
        out.println("Genre : " + work.getGenre() + "<BR/></BR>");
        out.println("Artiste principal : " + work.getMainArtist().getName() + "</BR></BR>");
        out.println("Résumé : " + work.getSummary() + "<BR/></BR>");

        out.println("</body></html>");


    }
}
