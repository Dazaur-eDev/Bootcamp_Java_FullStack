package com.daza.m5_sesion4_evaluation.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/myapp";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        try{
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e ) {
            throw new RuntimeException("No se pudo cargar el driver de la base de datos", e);
        }
    }
}
