package com.mycompany.onlinestore.backend.controller;

import com.mycompany.onlinestore.backend.entity.Artist;
import com.mycompany.onlinestore.backend.entity.Catalogue;
import com.mycompany.onlinestore.backend.entity.Work;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", urlPatterns = "/add-work")
public class AddWorkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        boolean success = true;

        Work newWork = new Work();

        try {
            Integer release = Integer.parseInt(request.getParameter("release"));
            newWork.setRelease(release);
        } catch (NumberFormatException numberFormatException) {
            success = false;
        }

        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        String summary = request.getParameter("summary");
        String mainArtistName = request.getParameter("mainArtistName");

        Artist mainArtist = new Artist(mainArtistName);

        newWork.setTitle(title);
        newWork.setGenre(genre);
        newWork.setSummary(summary);
        newWork.setMainArtist(mainArtist);

        // L'oeuvre existe t'elle déjà ?
        for (Work work : Catalogue.listOfWorks) {
            if (work.getTitle().equals(newWork.getTitle()) &
                    work.getMainArtist().getName().equals(newWork.getMainArtist().getName()) &
                    work.getRelease() == newWork.getRelease()) {
                success = false;
            }
        }

        // redirection
        RequestDispatcher requestDispatcher = null;

        if (success){
            Catalogue.listOfWorks.add(newWork);
            request.setAttribute("identifiantOeuvre", newWork.getId());
            requestDispatcher = request.getRequestDispatcher("/work-added-success");
        }
        else {
            requestDispatcher = request.getRequestDispatcher("/work-added-failure");
        }

        requestDispatcher.forward(request, response);

    }
}
