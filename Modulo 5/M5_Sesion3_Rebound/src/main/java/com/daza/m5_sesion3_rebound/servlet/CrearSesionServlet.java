package com.daza.m5_sesion3_rebound.servlet;


import com.daza.m5_sesion3_rebound.model.Producto;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "CrearSesionServlet", value = "/crearSesion")
public class CrearSesionServlet extends HttpServlet {

    private Producto producto1;

    @Override
    public void init(ServletConfig config) throws ServletException {
        producto1 = new Producto(1, "Café Lavaza Premium", 10990);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println(producto1);
        session.setAttribute("Producto", producto1);
        resp.sendRedirect("/verSesion");
    }
}
