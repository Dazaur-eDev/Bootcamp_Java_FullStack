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

@WebServlet(name = "VerSesionServlet", value = "/verSesion")
public class VerSesionServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Producto producto1 = (Producto) session.getAttribute("Producto");

        req.setAttribute("id", producto1.getId());
        req.setAttribute("concepto", producto1.getConcepto());
        req.setAttribute("importe", producto1.getImporte());

        req.getRequestDispatcher("/productoCreado.jsp").forward(req, resp);
    }

}
