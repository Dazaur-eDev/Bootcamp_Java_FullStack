package M4_Sesion8;

import M4_Sesion8.Modulos_E.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class S8_Evaluation {
    boolean tokenSalida = false;
    boolean tokenUsuario = false;

    public void appVenta() {
        // Crear productos
        ArrayList<Producto> stock = new ArrayList<>();
        stock.add(new Vegetales("Tomate", "V001", 800, LocalDate.of(2024, 5, 20), LocalDate.of(2024, 6, 20)));
        stock.add(new Vegetales("Lechuga", "V002", 500, LocalDate.of(2024, 5, 20), LocalDate.of(2024, 6, 20)));
        stock.add(new Vegetales("Zanahoria", "V003", 600, LocalDate.of(2024, 5, 20), LocalDate.of(2024, 6, 20)));
        stock.add(new Vegetales("Morrón", "V004", 900, LocalDate.of(2024, 5, 20), LocalDate.of(2024, 6, 20)));
        stock.add(new Vegetales("Cebolla", "V005", 550, LocalDate.of(2024, 5, 20), LocalDate.of(2024, 6, 20)));

        stock.add(new Vestuario("Zapatilla", "R001", 39000, 40, "rojo"));
        stock.add(new Vestuario("Pantalon", "R002", 13900, 42, "negro"));
        stock.add(new Vestuario("Zapato", "R003", 42900, 40, "marrón"));

        // Crear un vendedor
        Vendedor vendedor = new Vendedor("Patricio", "12345678-9");

        // Crear carrito de compras
        Carrito carrito = new Carrito();

        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al Minimarket App");
        while (!tokenUsuario) {
            ingresoUsuario();
        }
        while (!tokenSalida) {
            boolean tokenContinuar = false;
            menu();
            int opcionMenu = sc.nextInt();
            switch (opcionMenu) {
                case 1:
                    System.out.println("Productos disponibles:");
                    for (int i = 0; i < stock.size(); i++) {
                        System.out.println((i + 1) + ". " + stock.get(i));
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el número del producto a agregar al carrito: ");
                    int indiceProducto = sc.nextInt() - 1;
                    if (indiceProducto >= 0 && indiceProducto < stock.size()) {
                        carrito.agregarProductosCarrito(stock.get(indiceProducto));
                    } else {
                        System.out.println("Producto no válido.");
                    }
                    break;
                case 3:
                    System.out.println("Los productos en su carrito son: ");
                    carrito.listadoProductos();
                    break;
                case 4:
                    if (carrito.getCantidadProductos() == 0) {
                        System.out.println("Su carro se encuentra vacío, no hay nada que pagar");
                        break;
                    }
                    int totalCarrito = carrito.calcularTotal();
                    System.out.println("Total a pagar: $" + totalCarrito);
                    sc.nextLine();
                    while (!tokenContinuar) {
                        System.out.println("Presione Y para pagar o N para vaciar carrito");
                        String continuar = sc.nextLine();
                        if (continuar.equalsIgnoreCase("Y")) {
                            tokenContinuar = true;
                            System.out.println("Se ha pagado el monto de " + totalCarrito);
                            System.out.println("Ha sido atendido por " + vendedor.getNombre());
                            carrito.vaciarCarrito();
                        } else if (continuar.equalsIgnoreCase("N")) {
                            carrito.vaciarCarrito();
                            System.out.println("Se ha vaciado su carro de compra con los productos en ella");
                            tokenContinuar = true;
                        } else {
                            System.out.println("Opción no válida, ingrese 'y' o 'n'");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Gracias por usar Minimarket App");
                    tokenSalida = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

//    public void listadoProductos() {
//        for (Producto p : stock) {
//            System.out.println(p.getCodigo() + " - Nombre: " + p.getNombre() + " - Precio: " + p.getPrecio());
//        }
//    }

//    private void agregarProductosCarrito() {
//        boolean tokenCarrito = false;
//        sc.nextLine();
//
//        Producto productoSeleccionado = null;
//        while (!tokenCarrito) {
//            boolean tokenContinuar = false;
//            if (contadorProductosCarrito > 4) {
//                System.out.println("Carrito se encuentra lleno, pague para agregar mas produtos");
//                tokenContinuar = true;
//                break;
//            }
//            System.out.println("Ingrese el código del producto que desea llevar de acuerdo a la lista inferior:");
//            listadoProductos();
//
//            String codigoProductoSeleccionado = sc.nextLine();
//            for (Producto p : stock) {
//                if (p.getCodigo().equalsIgnoreCase(codigoProductoSeleccionado)) {
//                    productoSeleccionado = p;
//                }
//            }
//            if (productoSeleccionado != null) {
//                carritoCompra.add(productoSeleccionado);
//                System.out.println(productoSeleccionado);
//                contadorProductosCarrito++;
//            } else {
//                System.out.println("Producto no se encuentra en stock");
//            }
//
//            while (!tokenContinuar) {
//                System.out.println("Presione Y para agregar mas productos o N para finalizar");
//                String continuar = sc.nextLine();
//                if (continuar.equalsIgnoreCase("Y")) {
//                    tokenContinuar = true;
//                } else if (continuar.equalsIgnoreCase("N")) {
//                    tokenContinuar = true;
//                    tokenCarrito = true;
//                } else {
//                    System.out.println("Opción no válida");
//                }
//            }
//        }
//        System.out.println("La cantidad de productos en su carrito es de : " + contadorProductosCarrito);
//        mostrarCarrito();
//    }

//    public void mostrarCarrito() {
//        System.out.println("Los productos en su carrito son los siguientes: ");
//        int index = 1;
//        if (carritoCompra.isEmpty()) {
//            System.out.println("No hay productos en carrito");
//        } else {
//            for (Producto c : carritoCompra) {
//                System.out.println(index + ".- " + c.getNombre() + " - Precio: " + c.getPrecio());
//                index++;
//            }
//        }
//    }

    public void menu() {
        System.out.println("¿Qué desea hacer?");
        System.out.println("1.- Mostrar lista de productos");
        System.out.println("2.- Comprar");
        System.out.println("3.- Ver carrito de compras");
        System.out.println("4.- Pagar");
        System.out.println("5.- Salir");
    }

    private void ingresoUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su usuario");
        String usuario = sc.nextLine();
        if (!usuario.isEmpty()) {
            System.out.println("Ingrese su contraseña");
            String password = sc.nextLine();
            if (!password.isEmpty()) {
                System.out.println("Hola " + usuario);
                tokenUsuario = true;
            } else {
                System.out.println("Contraseña no puede ser vacía, vuelva a ingresar su usuario y contraseña");
            }
        } else {
            System.out.println("Nombre de usuario no puede ser vacío, vuelva a intentar");
        }
    }
}
