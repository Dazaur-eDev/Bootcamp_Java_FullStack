package com.Daza.vistas;

import com.Daza.utils.ReadConsole;

public abstract class MenuTemplate {
    public abstract void exportarDatos();

    public abstract void crearAlumno();

    public abstract void agregarMateria();

    public abstract void agregarNotaPasoUno();

    public abstract void listarAlumnos();

    public abstract void terminarPrograma();

    public void iniciarMenu() {
        boolean tokenSalida = false;
        while (!tokenSalida) {
            menuList();
            int option = ReadConsole.dataInputInt("un número de las opciones anteriores");
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
                    exportarDatos();
                    break;
                case 6:
                    terminarPrograma();
                    tokenSalida = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor ingrese opciones entre el 1 y el 6");
                    break;
            }
        }
    }

    public void menuList() {
        System.out.println("________________________________\n" +
                "1 . Crear Alumnos \n" +
                "2 . Listar Alumnos \n" +
                "3 . Agregar Materias \n" +
                "4 . Agregar Notas \n" +
                "5 . Exportar Promedios a archivo. \n" +
                "6 . Salir. \n" +
                "________________________________");
    }
}
