package com.daza.demo1;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "RespForm", value = "/respFormulario")
public class Servlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Recuperar los valores del formulario
        String nombre = request.getParameter("nombre");
        String direccion =  request.getParameter("direccion");
        String especialidad = request.getParameter("esp_medica");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String correo = request.getParameter("correo");

        //Asigno la variable en un atributo para enviar por una dirección
        request.setAttribute("NombreInsertado", nombre);
        request.setAttribute("DireccionInsertada", direccion);
        request.setAttribute("EspecialidadInsertada", especialidad);
        request.setAttribute("FechaInsertada", fecha);
        request.setAttribute("HoraInsertada", hora);
        request.setAttribute("CorreoInsertado", correo);

        //Envío los atributos a mensajes.jsp
        request.getRequestDispatcher("mensaje.jsp").forward(request, response);
    }

    public void destroy() {
    }
}