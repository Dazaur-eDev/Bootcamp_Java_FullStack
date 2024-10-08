<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reserva Hora Medica</title>
</head>
<body>
<header>
    <h1>FORMULARIO</h1>
</header>
<main>
   <%-- Se redirecciona al servlet /respFormulario --%>
    <form action="/respFormulario" method="get">
        <div>
            <label for="nombre">NOMBRE</label><br>
            <input type="text" name="nombre" id="nombre" required>
        </div>
        <br>

        <div>
            <label for="direccion">DIRECCIÓN</label><br>
            <input type="text" name="direccion" id="direccion" required>
        </div>
        <br>

        <div>
            <label for="esp_medica">ESPECIALIDAD MÉDICA</label><br>
            <select name="esp_medica" id="esp_medica" required>
                <option value="" selected disabled></option>
                <option value="medicina_interna">MEDICINA INTERNA</option>
                <option value="medicina_general">MEDICINA GENERAL</option>
                <option value="traumatologia">TRAUMATOLOGÍA</option>
                <option value="nutricionista">NUTRICIONISTA</option>
            </select>
        </div>
        <br>

        <div>
            <label for="fecha">FECHA</label><br>
            <input type="date" name="fecha" id="fecha" required>
        </div>
        <br>

        <div>
            <label for="hora">HORA</label><br>
            <input type="time" name="hora" id="hora" required>
        </div>
        <br>

        <div>
            <label for="correo">CORREO</label><br>
            <input type="email" name="correo" id="correo" pattern="^[^@]+@[^@]+\.[a-zA-Z]{2,}$" required>
        </div>
        <br>

        <button type="submit">CONFIRMAR</button>
    </form>
</main>

</body>
</html>