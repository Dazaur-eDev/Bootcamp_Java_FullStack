<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sesión Iniciada</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/styles/styles.css">
</head>

<body>

<header>
    <!-- Navbar -->
    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Modulo 5 - Sesion 3 - Evaluation - Sesión iniciada con Request a nombre de
                : <%= request.getAttribute("nombre")%>
            </a>
        </div>
    </nav>
</header>

<div class="container mt-5">
    <div class="row justify-content-center min-vh-100">
        <div class="col-md-6 ">
            <!-- Titulo de la pagina -->
            <%
                String nombre = (String) request.getAttribute("nombre");
                nombre = nombre.trim(); // trim para eliminar espacio en blanco al inicio y final del nombre
                if (nombre.isEmpty()) {
            %>
            <h1 class="text-center mt-4 mb-4">ACCESO DENEGADO</h1>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title text-center mb-4"> Hubo un error en su nombre y/o contraseña. <br> Su nombre no puede ser vacío y la contraseña debe contener como mínimo cuatro caracteres.</h5>
                    <form action="./index.jsp" method="post">
                        <div class="d-grid">
                            <button type="submit" class="btn btn-dark">Regresar</button>
                        </div>
                    </form>
                </div>
                <%
                } else {
                %>

                <h1 class="text-center mt-4 mb-4">BIENVENIDO</h1>
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title text-center mb-4"> Estimado <%= request.getAttribute("nombre")%> ha ingresado ha su área personal <br>
                            utilizando Request.</h5>
                        <form action="./logoutServletConRequest" method="post">
                            <div class="d-grid">
                                <button type="submit" class="btn btn-dark">Cerrar Sesión</button>
                            </div>
                        </form>
                    </div>

                </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>

    <!-- Footer -->
    <footer class="bg-dark text-white text-center">
        <div class="container-fluid">
            <p class="small m-1"> © 2024 eDev_Daza. Todos los derechos reservados.</p>
        </div>
    </footer>

</body>
</html>