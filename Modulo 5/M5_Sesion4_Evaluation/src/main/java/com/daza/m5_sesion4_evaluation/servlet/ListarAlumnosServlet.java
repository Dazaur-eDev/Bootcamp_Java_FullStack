package com.daza.m5_sesion4_evaluation.servlet;

import com.daza.m5_sesion4_evaluation.model.Alumno;
import com.daza.m5_sesion4_evaluation.service.AlumnoService;
import com.daza.m5_sesion4_evaluation.service.AlumnoServiceImplement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "ListarAlumnoServlet", value = "/listarAlumnos")
public class ListarAlumnosServlet extends HttpServlet {

    private AlumnoService alumnoService;

    @Override
    public void init() throws ServletException {
        alumnoService = new AlumnoServiceImplement();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Alumno> alumnos = alumnoService.listarAlumnos();
        request.setAttribute("alumno", alumnos);
        request.getAttribute("insertarSatisfactorio");
        request.getAttribute("eliminarSatisfactorio");

        request.getRequestDispatcher("listarAlumnos.jsp").forward(request, response);
    }
}
