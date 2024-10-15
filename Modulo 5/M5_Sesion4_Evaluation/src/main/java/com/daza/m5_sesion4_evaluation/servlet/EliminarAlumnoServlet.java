package com.daza.m5_sesion4_evaluation.servlet;

import com.daza.m5_sesion4_evaluation.model.Alumno;
import com.daza.m5_sesion4_evaluation.service.AlumnoService;
import com.daza.m5_sesion4_evaluation.service.AlumnoServiceImplement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;


@WebServlet(name = " EliminarAlumnoServlet", value = "/eliminarAlumno")
public class EliminarAlumnoServlet extends HttpServlet {
    private AlumnoService alumnoService;

    @Override
    public void init() {
        alumnoService = new AlumnoServiceImplement();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Obtengo el parametro id para identificar el alumno a eliminar, lo dejo en long porque en la bd esta definido como bigint
        long id = Long.parseLong(request.getParameter("id"));

        //Obtener los datos del alumno eliminado para desplegar en pantalla y enviarlos para ser utilizado en listarAlumnos.jsp mediante sessions
        HttpSession session = request.getSession();
        List<Alumno> alumnos = alumnoService.listarAlumnos();
        for (Alumno a : alumnos) {
            if (a.getId() == id) {
                session.setAttribute("nombreEliminado", a.getNombre());
                session.setAttribute("apellidoEliminado",a.getApellido());
                break;
            }
        }

        //Invoco al metodo de retirarAlumno de Service que invocará posteriormente a eliminarAlumno de Repositorio
        alumnoService.retirarAlumno(id);

        //Indico en el parámetro eliminarSatisfactorio el valor de true para desplegar mensaje en listarAlumnos.jsp mediante una session
        session.setAttribute("eliminarSatisfactorio", true);

        //Se envia la información a servlet listarAlumnosServlet
        response.sendRedirect(request.getContextPath() + "/listarAlumnos");

    }
}