package com.daza.m5_sesion2_jsp_hotel.servlet;

import com.daza.m5_sesion2_jsp_hotel.modelo.Habitacion;
import com.daza.m5_sesion2_jsp_hotel.servicio.HabitacionServicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "datoUsuarioServlet", value = "/datoUsuarioServlet")
public class datoUsuarioServlet extends HttpServlet {

    HabitacionServicio habitacionServicio = new HabitacionServicio();

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Habitacion> listaDeHabitaciones = habitacionServicio.getHabitaciones();
        request.setAttribute("listaDeHabitaciones", listaDeHabitaciones);
        request.getRequestDispatcher("formularioReserva.jsp").forward(request, response);
        String nombre  = request.getParameter("nombre");
        String email = request.getParameter("email");
        String dias = request.getParameter("dias");

        HttpSession session = request.getSession();
        session.setAttribute("nombre", nombre);
        session.setAttribute("email", email);
        session.setAttribute("dias", dias);

        response.sendRedirect("formularioReserva.jsp");

    }
    public void destroy() {}
}
