package com.daza.m5_sesion3_evaluation.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logoutServletConRequest")
public class LogoutServletConRequest extends HttpServlet {

    @Override
    public void init() {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.removeAttribute("nombre");
        request.removeAttribute("contrasena");

        response.sendRedirect("index.jsp?mensaje=Parametros de Request removidos");
    }

    @Override
    public void destroy() {
    }
}
