package com.daza.m5_sesion3_evaluation.request;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginServletConRequest", value = "/loginServletConRequest")
public class LoginServletConRequest extends HttpServlet {

    @Override
    public void init() {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String nombre = request.getParameter("nombre");
        String contrasena = request.getParameter("contrasena");

        if (!nombre.isEmpty() && (contrasena.length() > 3)) {
            request.setAttribute("nombre", nombre);
        } else {
            request.setAttribute("nombre", "");
        }
        request.getRequestDispatcher("./SesionIniciadaConRequest.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
    }
}