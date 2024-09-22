package com.Daza.vistas;

import static com.Daza.utils.leerConsola.*;

public abstract class MenuTemplate {
    public abstract void exportarDatos();
    public abstract void crearAlumno();
    public abstract void agregarMateria();
    public abstract void agregarNotaPasoUno();
    public abstract void listarAlumnos();
    public abstract void terminarPrograma();

    public void iniciarMenu() {
        int option = dataInputInt();
        switch (option) {
            case 1:
                crearAlumno();
                break;
            case 2:
                listarAlumnos();
                break;
            case 3:
                agregarMateria();
                break;
            case 4:
                agregarNotaPasoUno();
                break;
            case 5:
                terminarPrograma();
                break;
            case 6:
                exportarDatos();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

}
