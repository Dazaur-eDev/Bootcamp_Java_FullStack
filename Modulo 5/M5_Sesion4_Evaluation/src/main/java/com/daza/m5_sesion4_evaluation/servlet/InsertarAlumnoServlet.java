package com.daza.m5_sesion4_evaluation.servlet;

import com.daza.m5_sesion4_evaluation.model.Alumno;
import com.daza.m5_sesion4_evaluation.service.AlumnoService;
import com.daza.m5_sesion4_evaluation.service.AlumnoServiceImplement;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = " InsertarAlumnoServlet", value = "/insertarAlumno")
public class InsertarAlumnoServlet extends HttpServlet {
    private AlumnoService alumnoService;

    @Override
    public void init(){
        alumnoService = new AlumnoServiceImplement();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //me redirije a l pagina donde ingresare los datos del nuevo alumno a insertar
        request.getRequestDispatcher("insertarAlumno.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Obtengo los parametros ingresados en insertarAlumno.jsp y los almaceno en variables de acuerdo a su parametro indicado
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int edad = Integer.parseInt(request.getParameter("edad"));

        //Creo una nueva instancia de alumno con los valores obtenidos
        Alumno alumno = new Alumno(nombre, apellido, edad);

        //Registro alumno en bd datos llamando al metodo registrarAlumno de Service que invocara al metodo insertar de Repository
        alumnoService.registrarAlumno(alumno);

        //Indico en el parámetro insertarSatisfactorio el valor de true para desplegar mensaje en listarAlumnos.jsp mediante una session
        HttpSession session = request.getSession();
        session.setAttribute("insertarSatisfactorio", true);

        //Se envia la información a servlet listarAlumnosServlet
        response.sendRedirect(request.getContextPath() + "/listarAlumnos");

    }
}
