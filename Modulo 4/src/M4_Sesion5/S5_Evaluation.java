package M4_Sesion5;

import java.util.Scanner;

public class S5_Evaluation {
    Producto[] tablaProductos = new Producto[7];
    int totalProductos;
    public void appProductos() {
        boolean flag = false;
        System.out.println("Bienvenido a la App de Productos");
        listaInicialProductos();
        Scanner sc = new Scanner(System.in);
        while (flag != true) {
            menuPrincipal();
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    verProductos();
                    break;
                case 2:
                    agregarProducto();
                    break;
                case 3:
                    modificarProducto();
                    break;
                case 4:
                    //eliminarProducto();
                    System.out.println("no disponible aún, no es funcional al 100%");
                    break;
                case 5:
                    flag = true;
                    break;
            }
        }
    }

    public void listaInicialProductos() {
        tablaProductos[0] = new Producto("Chocolate", 500, "Chocolate amargo, 500 gr.");
        tablaProductos[1] = new Producto("Leche", 800, "Leche entera, 1 litro.");
        tablaProductos[2] = new Producto("Arroz", 900, "Arroz grado 2, 1 kilo.");
    }

    private void menuPrincipal() {
        System.out.println("Elija una opción:");
        System.out.println("1.- Ver productos");
        System.out.println("2.- Agregar productos");
        System.out.println("3.- Modificar productos");
        System.out.println("4.- Eliminar productos");
        System.out.println("5.- Salir");
    }

    private void verProductos() {
        totalProductos = 0;
        for (int i = 0; i < 7; i++) {
            if (tablaProductos[i] != null) {
                System.out.println( (i+1) + " .- Producto: " + tablaProductos[i].getNombre() + " - Valor: " + tablaProductos[i].getValor() + " - Descripcion: " + tablaProductos[i].getDescripcion());
                totalProductos += 1;
            }
        }
    }

    private void agregarProducto() {
        Scanner producto = new Scanner(System.in);
        Scanner valor = new Scanner(System.in);
        Scanner descripcion = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto que desea agregar:");
        String nuevoProducto = producto.nextLine();
        System.out.println("Ingrese el valor del producto:");
        int nuevoValor = valor.nextInt();
        System.out.println("Ingrese el descripcion del producto:");
        String nuevaDescripcion = descripcion.nextLine();
        System.out.println("El producto ha sido ingresado como Producto " + (totalProductos+1));
        tablaProductos[totalProductos] = new Producto(nuevoProducto, nuevoValor, nuevaDescripcion);
    }

    private void modificarProducto() {
        System.out.println("Seleccione el número de producto que desea modificar:");
        verProductos();
        Scanner sc = new Scanner(System.in);
        int indiceProductoSeleccionado = sc.nextInt();
        System.out.println("Seleccione el numero de opcion que desea modificar:");
        System.out.println("1.- Nombre: " + tablaProductos[indiceProductoSeleccionado - 1].getNombre());
        System.out.println("2.- Valor: " + tablaProductos[indiceProductoSeleccionado - 1].getValor());
        System.out.println("3.- Descripción: " + tablaProductos[indiceProductoSeleccionado - 1].getDescripcion());
        Scanner sc2 = new Scanner(System.in);
        int atributoModificar = sc2.nextInt();
        switch (atributoModificar){
            case 1:
                System.out.println("Escriba el nuevo nombre: ");
                Scanner nombre = new Scanner(System.in);
                String nuevoNombre = nombre.nextLine();
                tablaProductos[indiceProductoSeleccionado-1].setNombre(nuevoNombre);
                break;
            case 2:
                System.out.println("Escriba el nuevo valor: ");
                Scanner valor = new Scanner(System.in);
                int nuevoValor = valor.nextInt();
                tablaProductos[indiceProductoSeleccionado-1].setValor(nuevoValor);
                break;
            case 3:
                System.out.println("Escriba la nueva descripcion: ");
                Scanner descripcion = new Scanner(System.in);
                String nuevaDescripcion = descripcion.nextLine();
                tablaProductos[indiceProductoSeleccionado-1].setDescripcion(nuevaDescripcion);
                break;
        }
        System.out.println("La modificación se ha efectuado, los cambios han quedado registrados de la siguiente forma:");
        System.out.println( (indiceProductoSeleccionado-1) + " .- Producto: " + tablaProductos[indiceProductoSeleccionado-1].getNombre() + " - Valor: " + tablaProductos[indiceProductoSeleccionado-1].getValor() + " - Descripcion: " + tablaProductos[indiceProductoSeleccionado-1].getDescripcion());
    }

//    Necesito analizar el tema del indice al borrar un valor que no es el ultimo esto genera un desplazamiento del indice
//    private void eliminarProducto() {
//        System.out.println("Seleccione el número de producto que desea eliminar:");
//        verProductos();
//        Scanner sc = new Scanner(System.in);
//        int indiceProductoSeleccionado = sc.nextInt();
//        System.out.println("El producto ha eliminar es el siguiente:");
//        System.out.println( (indiceProductoSeleccionado-1) + " .- Producto: " + tablaProductos[indiceProductoSeleccionado-1].getNombre() + " - Valor: " + tablaProductos[indiceProductoSeleccionado-1].getValor() + " - Descripcion: " + tablaProductos[indiceProductoSeleccionado-1].getDescripcion());
//        tablaProductos[indiceProductoSeleccionado-1] = null;
//    }
}

