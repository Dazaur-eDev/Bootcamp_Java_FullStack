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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/styles/styles.css">
</head>

<body class="d-flex flex-column min-vh-100">

<header>
    <!-- Navbar -->
    <nav class="navbar navbar-dark bg-dark card-glow">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Modulo 5 - Sesión 4 - Rebound - Evaluation - Listado de ALumnos
                datos</a>
        </div>
    </nav>
</header>

<div class="container mt-5 justify-content-center text-center">
    <h1 class="text-center mb-4">LISTADO DE ALUMNOS</h1>

    <div class="d-flex justify-content-center mb-3">
        <form action="./insertarAlumno.jsp" method="post">
            <button type="submit" class="btn btn-dark mt-2 p-2">Insertar nuevo Alumno</button>
        </form>
    </div>

    <div class="d-flex justify-content-center m-1 ">
        <form class="d-flex" role="search">
            <input type="search" class="form-control me-2 bg-dark text-white" id="BuscarAlumno" name="BuscarAlumno"
                   placeholder="Buscar">
            <button class="btn btn-darkSearch" type="submit">Buscar</button>
        </form>
    </div>
</div>

<div id="tablaAlumnos" class="container mt-2 mb-3 justify-content-center text-center">
    <%
        Boolean insertarSatisfactorio = (Boolean) session.getAttribute("insertarSatisfactorio");
        Boolean eliminarSatisfactorio = (Boolean) session.getAttribute("eliminarSatisfactorio");
        List<Alumno> alumnos = (List<Alumno>) request.getAttribute("alumno");
        if (insertarSatisfactorio != null && insertarSatisfactorio) {
    %>
    <div class="alert alert-success text-center mt-2" id="mensajeCrud" role="alert">
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
    <div class="alert alert-success text-center mt-2" id="mensajeCrud" role="alert">
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
    <table class=" table table-hover table-responsive table-borderless table-dark mt-3">
        <thead class="table-warning">
        <tr>
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
                    <button type="submit" class="btn btn-darkTable">Actualizar</button>
                </form>
            </td>
            <td>
                <form action="./eliminarAlumno" method="post">
                    <input type="hidden" name="id" value="<%= a.getId() %>">
                    <button type="submit" class="btn btn-darkTable">Eliminar</button>
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
    <form action="./index.jsp" method="post">
        <button type="submit" class="btn btn-dark mt-2 p-2 ">Salir</button>
    </form>
</div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

<!-- Footer -->
<footer class="bg-dark text-white text-center mt-auto">
    <div class="container-fluid">
        <p class="small m-1"> © 2024 eDev_Daza. Todos los derechos reservados.</p>
    </div>
</footer>

</body>
</html>
