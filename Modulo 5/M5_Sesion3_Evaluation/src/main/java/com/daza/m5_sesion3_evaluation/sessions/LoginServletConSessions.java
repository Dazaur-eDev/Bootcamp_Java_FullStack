package com.daza.m5_sesion3_evaluation.sessions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServletConSessions", value = "/loginServletConSessions")
public class LoginServletConSessions extends HttpServlet {

    @Override
    public void init() {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        String nombre = request.getParameter("nombre2");
        String contrasena = request.getParameter("contrasena2");

        if (!nombre.isEmpty() && (contrasena.length() > 3)) {
            session.setAttribute("nombre2", nombre);
        } else {
            session.setAttribute("nombre2", "");
        }
        request.getRequestDispatcher("SesionIniciadaConSessions.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
    }
}
