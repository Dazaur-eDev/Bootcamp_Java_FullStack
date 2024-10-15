package com.daza.m5_sesion2_jsp_hotel.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "formularioHabitacionServlet", value = "/formHabServlet")
public class FormularioHabitacionServlet extends HttpServlet {

    public void init(){}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nombre = (String) session.getAttribute("nombre");
        String email = (String) session.getAttribute("email");
        String dias = (String) session.getAttribute("dias");
        String idHbSeleccionado = request.getParameter("idHb");

        request.setAttribute("nombre", nombre);
        request.setAttribute("email", email);
        request.setAttribute("dias", dias);
        request.setAttribute("idHb", idHbSeleccionado);

        request.getRequestDispatcher("reserva.jsp").forward(request, response);
    }

    public void destroy() {}
}