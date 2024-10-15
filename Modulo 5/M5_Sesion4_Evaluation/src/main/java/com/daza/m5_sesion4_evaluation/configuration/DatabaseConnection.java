package com.daza.m5_sesion4_evaluation.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    //Comando show port; en cmd en cliente psql :5432
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/modulo5";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "1234";

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se pudo cargar el driver de la base de datos", e);
        }
    }

    //    Con synchronized se hace que solo un hilo pueda ejecutar el metodo getInstance() al mismo tiempo. Si otro hilo intenta invocar
    //    este metodo mientras un hilo ya lo está ejecutando, tendrá que esperar hasta que el primer hilo termine. Además, se utiliza singleton para generar
    //    una sola instancia de conexión.
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()){
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        return connection;
    }

    public void closeConnection(){
        if( connection != null ){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Error al cerrar la conexión", e);
            }
        }
    }
}
