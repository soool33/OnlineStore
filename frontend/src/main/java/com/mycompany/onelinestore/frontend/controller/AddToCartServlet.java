package com.mycompany.onelinestore.frontend.controller;

import com.mycompany.onlinestore.backend.entity.Catalogue;
import com.mycompany.onlinestore.backend.entity.ShoppingCart;
import com.mycompany.onlinestore.backend.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddToCartServlet", urlPatterns = "/addToCart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Long id = Long.parseLong(request.getParameter("identifiant"));

        // On récupère le panier en session
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");

        // Si le panier n'existe pas déjà, on le crée
        if (cart == null) {
            cart = new ShoppingCart();
            request.getSession().setAttribute("cart", cart);
        }

        // On recherche l'oeuvre selectionnée dans la catalogue
        for (Work work : Catalogue.listOfWorks) {
            if (id == work.getId()) {
                // Et on l'ajoute au panier
                cart.getItems().add(work);
            }
        }

        PrintWriter out = response.getWriter();
        String message = "Oeuvre ajoutée au caddie (" + cart.getItems().size() + ")";

        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println(("<a href=\"catalogue\">Catalogue des oeuvres</a>"));
        out.println("</body></html>");
    }
}
