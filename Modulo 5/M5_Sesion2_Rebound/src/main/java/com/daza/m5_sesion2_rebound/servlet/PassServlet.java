package com.daza.m5_sesion2_rebound.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "PassServlet", value = "/passServlet")
public class PassServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pass = String.valueOf(request.getParameter("contrasena"));
        System.out.println(pass);
        int contadorMayusculas = 0;
        int contadorMinisculas = 0;
        int contadorNumeros = 0;
        if (!pass.isEmpty()) {
            for (int i = 0; i < pass.length(); i++) {
                char caracterPass = pass.charAt(i);
                if (Character.isUpperCase(caracterPass)) {
                    contadorMayusculas++;
                } else if (Character.isLowerCase(caracterPass)) {
                    contadorMinisculas++;
                } else if (Character.isDigit(caracterPass)) {
                    contadorNumeros++;
                }
            }
            if (contadorMayusculas > 3 && contadorMinisculas > 2 && contadorNumeros > 2 ) {
                request.setAttribute("tokenPass", true);
                request.setAttribute("contadorMayusculas", contadorMayusculas);
                request.setAttribute("contadorMinisculas", contadorMinisculas);
                request.setAttribute("contadorNumeros", contadorNumeros);giot add .
            } else {
                request.setAttribute("contadorMayusculas", contadorMayusculas);
                request.setAttribute("contadorMinisculas", contadorMinisculas);
                request.setAttribute("contadorNumeros", contadorNumeros);
                request.setAttribute("tokenPass", false);
            }
        } else {
            request.setAttribute("tokenPass", false);
            request.setAttribute("contadorMayusculas", contadorMayusculas);
            request.setAttribute("contadorMinisculas", contadorMinisculas);
            request.setAttribute("contadorNumeros", contadorNumeros);
        }
        request.getRequestDispatcher("respuestaIngreso.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
