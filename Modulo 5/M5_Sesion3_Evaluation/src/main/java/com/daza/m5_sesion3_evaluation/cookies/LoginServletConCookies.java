package com.daza.m5_sesion3_evaluation.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServletConCookies", value = "/loginServletConCookies")
public class LoginServletConCookies extends HttpServlet {

    @Override
    public void init() {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nombre = request.getParameter("nombre3");
        String contrasena = request.getParameter("contrasena3");

        if (!nombre.isEmpty() && (contrasena.length() > 3)) {
            Cookie cookieNombre = new Cookie("nombre3", nombre);
            cookieNombre.setMaxAge(60 * 30); // 1800 segundos = 30 min
            cookieNombre.setPath("/"); // Path es importante para asegurar la correcta aplicación
            System.out.println("Cumple pass Cookie name : " + cookieNombre.getName());
            System.out.println("Cumple pass Cookie value: " + cookieNombre.getValue());
            response.addCookie(cookieNombre);
        } else {
            Cookie cookieNombre = new Cookie("nombre3", "");
            cookieNombre.setMaxAge(60 * 30); // 1800 segundos = 30 min
            cookieNombre.setPath("/"); // Path es importante para asegurar la correcta aplicación
            response.addCookie(cookieNombre);

        }
        response.sendRedirect("./SessionIniciadaConCookies.jsp");
    }

    @Override
    public void destroy() {
    }
}
