package com.mycompany.onlinestore.backend.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();

        if (login.equals("michel") & password.equals("123456") | (login.equals("caroline") & password.equals("abcde"))){
            String message = "Authentification OK";

            // Création de la session (ou récupération si déjà crée)
            HttpSession session = request.getSession();
            session.setAttribute("login", login);

            out.println("<html><body>");
            out.println("<h1>" + message + "</h1>");

            out.println(("<a href=\"index.jsp\">Accueil</a>"));
            out.println("</body></html>");
        }
        else {
            String message = "Echec de l'authentification";

            out.println("<html><body>");
            out.println("<h1>" + message + "</h1>");

            out.println(("<a href=\"login.html\">Login</a>"));
            out.println("</body></html>");
        }

        // michel, 123456 ou caroline avec le mot de passe abcdef




    }
}
