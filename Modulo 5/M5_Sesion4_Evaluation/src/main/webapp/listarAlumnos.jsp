<%@ page import="com.daza.m5_sesion4_evaluation.model.Alumno" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos de Alumnos</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5 justify-content-center text-center">
    <h1 class="text-center mb-4">Datos de Alumnos</h1>

    <div class="d-flex justify-content-center mb-3">
        <a href="./insertarAlumno" class="btn btn-primary">Insertar nuevo alumno</a>
    </div>

    <div class="d-flex justify-content-center m-1">
        <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Buscar alumno" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Buscar</button>
        </form>
    </div>
</div>

<div id="tablaAlumnos" class="container mt-2 justify-content-center text-center">
    <%
        Boolean insertarSatisfactorio = (Boolean) session.getAttribute("insertarSatisfactorio");
        Boolean eliminarSatisfactorio = (Boolean) session.getAttribute("eliminarSatisfactorio");
        List<Alumno> alumnos = (List<Alumno>) request.getAttribute("alumno");
        if (insertarSatisfactorio != null && insertarSatisfactorio) {
    %>
    <div class="alert alert-success text-center" id="mensajeCrud" role="alert">
        <%
            if (alumnos != null && !alumnos.isEmpty()) {
                Alumno alumnoAgregado = alumnos.get(alumnos.size() - 1);
                String nombreCompleto = alumnoAgregado.getNombre() + " " + alumnoAgregado.getApellido();
        %>
        <%= "Alumno '" + nombreCompleto + "' " + "insertado con éxito."%>
    </div>
    <%
            }
            session.removeAttribute("insertarSatisfactorio");
        }
        if (eliminarSatisfactorio != null && eliminarSatisfactorio) {
    %>
    <div class="alert alert-warning text-center" id="mensajeCrud" role="alert">
        <%
            if (alumnos != null && !alumnos.isEmpty()) {
                String nombreEliminado = String.valueOf(session.getAttribute("nombreEliminado"));
                String apellidoEliminado = String.valueOf(session.getAttribute("apellidoEliminado"));
        %>
        <%= "Alumno '" + nombreEliminado + " " + apellidoEliminado + "' eliminado con éxito."%>
    </div>
    <%
            }
            session.removeAttribute("eliminarSatisfactorio");
        }
    %>
    <div>
    </div>
    <table class="table">
        <thead>
        <tr class="table-info">
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Edad</th>
            <th>Actualizar</th>
            <th>Eliminar</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (alumnos != null) {
                for (Alumno a : alumnos) {
        %>
        <tr>
            <td><%= a.getId() %>
            </td>
            <td><%= a.getNombre() %>
            </td>
            <td><%= a.getApellido() %>
            </td>
            <td><%= a.getEdad() %>
            </td>
            <td>
                <form action="./actualizarAlumno" method="post">
                    <input type="hidden" name="id" value="<%= a.getId() %>">
                    <button type="submit" class="btn btn-primary">Actualizar</button>
                </form>
            </td>
            <td>
                <form action="./eliminarAlumno" method="post">
                    <input type="hidden" name="id" value="<%= a.getId() %>">
                    <button type="submit" class="btn btn-danger">Eliminar</button>
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>

<div class="text-center mt-4">
    <a href="index.jsp" class="btn btn-secondary">Volver a la página principal</a>
</div>
</div>

<!-- Bootstrap JS y Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
