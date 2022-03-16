package com.mycompany.onelinestore.frontend.controller.somme;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UnexpectedErrorServlet", urlPatterns = "/unexpected-error")
public class UnexpectedErrorServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try {
            PrintWriter out = response.getWriter();
            String message = "<h1>Unexpected error - Operation cancelled (from servlet)</h1>";

            out.println("<html><body>");
            out.println("<h1>" + message + "</h1>");

            out.println("</body></html>");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
