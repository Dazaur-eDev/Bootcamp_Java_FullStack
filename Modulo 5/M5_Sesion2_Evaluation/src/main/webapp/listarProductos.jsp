<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.daza.m5_sesion2_evaluation.dto.ProductoResponseDTO" %>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla de Productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/styles/styles.css">
</head>

<header>
    <!-- Navbar -->
    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Modulo 5 - Sesion 2 - Evaluation - Listar Productos</a>
        </div>
    </nav>
</header>

<body>

<!-- Sección de lista de productos-->
<div class="container mt-5">
    <!-- Titulo de la pagina -->
    <h1 class="text-center">Productos Disponibles</h1>
    <!--Lista de datos ingresados en index.jsp-->
    <fieldset disabled>
        <div class="mb-3 w-auto">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control bg-dark text-white" id="nombre" name="nombre"
                   value="<%= request.getAttribute("nombre")%>">

            <label for="direccion" class="form-label">Dirección</label>
            <input type="text" class="form-control bg-dark text-white" id="direccion" name="direccion"
                   value="<%= request.getAttribute("direccion")%>">
        </div>
    </fieldset>

    <%--Tabla para insertar los datos de la base de datos de los productos--%>
    <form action="factura" method="POST">
        <table class="table table-striped table-dark text-center align-middle mt-5">
            <%--Titulo de la tabla--%>
            <thead>
            <tr>
                <th>NOMBRE</th>
                <th class="text-left">DESCRIPCIÓN</th>
                <th>PRECIO UNITARIO</th>
                <th>CANTIDAD</th>
            </tr>
            </thead>
            <%--Contenido de la tabla--%>

            <tbody>
            <%
                List<ProductoResponseDTO> productos = (List<ProductoResponseDTO>) request.getAttribute("productos");
                if (productos != null) {
                    for (ProductoResponseDTO producto : productos) {
            %>
            <tr>
                <td><%= producto.getNombre() %>
                </td>
                <td><%= producto.getDescripcion() %>
                </td>
                <td><%= producto.getPrecioUnitario() %>
                </td>
                <td>
                    <input type="hidden" name="productoId" value="<%= producto.getId() %>">
                    <input type="number" class="form-control bg-dark text-white" id="cantidad_<%= producto.getId() %>"
                           name="cantidad_<%= producto.getId() %>" placeholder="Indique cantidad que desea llevar">
                </td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
        <!-- Botón de confirmar proceso de compra -->
        <div class="d-flex justify-content-center align-items-center mt-4">
            <button type="submit" class="btn btn-dark">Confirmar compra</button>
        </div>
    </form>
</div>

<!-- Footer -->
<footer class="bg-dark text-white text-center">
    <div class="col-12">
        <p class="small m-1">&copy; 2024 eDev_Daza. Todos los derechos reservados.</p>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>