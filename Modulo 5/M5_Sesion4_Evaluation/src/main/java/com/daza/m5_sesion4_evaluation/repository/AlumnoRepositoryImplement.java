package com.daza.m5_sesion4_evaluation.repository;

import com.daza.m5_sesion4_evaluation.configuration.DatabaseConnection;
import com.daza.m5_sesion4_evaluation.model.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoRepositoryImplement implements AlumnoRepository {

    @Override
    public List<Alumno> listarAlumnos() {
        List<Alumno> listaDeAlumnos = new ArrayList<>();
        String sql = "SELECT id, nombre, apellido, edad FROM alumno";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Alumno alumno = new Alumno();
                alumno.setId(resultSet.getInt("id"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setApellido(resultSet.getString("apellido"));
                alumno.setEdad(resultSet.getInt("edad"));
                listaDeAlumnos.add(alumno);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar los alumnos", e);
        }
        return listaDeAlumnos;
    }

    @Override
    public void insertarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (nombre, apellido, edad) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, alumno.getNombre());
            preparedStatement.setString(2, alumno.getApellido());
            preparedStatement.setInt(3, alumno.getEdad());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al intentar guardar alumno", e);
        }
    }

    @Override
    public void eliminarAlumno(long id) {
        String sql = "DELETE FROM alumno WHERE id = ?";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al intentar eliminar alumno", e);
        }
    }

    @Override
    public Alumno buscarAlumno(Alumno alumno) {
        return null;
    }

    @Override
    public void actualizarAlumno(Alumno alumno) {

    }
}
