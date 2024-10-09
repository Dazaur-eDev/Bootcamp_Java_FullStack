package com.daza.m5_sesion2_jsp_hotel.servlet;

import java.io.*;
import java.util.List;

import com.daza.m5_sesion2_jsp_hotel.modelo.Habitacion;
import com.daza.m5_sesion2_jsp_hotel.servicio.HabitacionServicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "formularioHabitacionServlet", value = "/formHabServlet")
public class FormularioHabitacionServlet extends HttpServlet {

    HabitacionServicio habitacionServicio = new HabitacionServicio();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Habitacion> listaDeHabitaciones = habitacionServicio.getHabitaciones();
        request.setAttribute("listaDeHabitaciones", listaDeHabitaciones);
        request.getRequestDispatcher("formularioReserva.jsp").forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre  = request.getParameter("nombre");
        String email = request.getParameter("email");
        String dias = request.getParameter("dias");

        request.setAttribute("nombre", nombre);
        request.setAttribute("email", email);
        request.setAttribute("dias", dias);

        request.getRequestDispatcher("reserva.jsp").forward(request, response);
    }

    public void destroy() {
    }
}