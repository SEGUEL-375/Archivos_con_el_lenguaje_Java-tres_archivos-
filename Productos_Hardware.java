import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


class Producto {
    
    String nombre;
    double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " : $" + precio;
    }
}

public class Productos_Hardware {
    private static ArrayList<Producto> listaProductos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de leer un entero

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                
                case 4:
                    editarProducto();
                    break;
                     
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú de Productos de Hardware ---");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Mostrar Productos");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Editar Producto");
        System.out.println("5. Salir");
    }

    private static void agregarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese el precio del producto: $");
        double precio = scanner.nextDouble();
        
        Producto nuevoProducto = new Producto(nombre, precio);
        listaProductos.add(nuevoProducto);
        
        System.out.println("Producto agregado con éxito.");
    }

    private static void mostrarProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("Lista de Productos:");
            for (Producto producto : listaProductos) {
                System.out.println(producto);
            }
        }
    }

    private static void eliminarProducto() {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos para eliminar.");
            return;
        }

        System.out.println("Lista de Productos:");
        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println(+ (i + 1) + "." + listaProductos.get(i));
        }

        System.out.print("Ingrese el número del producto a eliminar: ");
        int indice = scanner.nextInt();

        if (indice >= 1 && indice <= listaProductos.size()) {
            Producto productoEliminado = listaProductos.remove(indice - 1);
            System.out.println("Producto \"" + productoEliminado + "\" eliminado con éxito.");
        } else {
            System.out.println("Número de producto no válido.");
        }
    }

    private static void editarProducto() {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos para editar.");
            return;
        }

        System.out.println("Lista de Productos:");
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
            for (int i = 0; i < listaProductos.size(); i++) {
                String formattedNumber = numberFormat.format(i + 1);
                System.out.println(formattedNumber + ". " + listaProductos.get(i));
            }

        System.out.print("Ingrese el número del producto a editar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer un entero

        if (indice >= 1 && indice <= listaProductos.size()) {
            Producto productoAEditar = listaProductos.get(indice - 1);

            System.out.print("Ingrese el nuevo nombre del producto: ");
            String nuevoNombre = scanner.nextLine();
            productoAEditar.nombre = nuevoNombre;

            System.out.print("Ingrese el nuevo precio del producto: $");
            double nuevoPrecio = scanner.nextDouble();
            productoAEditar.precio = nuevoPrecio;

            System.out.println("Producto editado con éxito.");
        } else {
            System.out.println("Número de producto no válido.");
        }
    }
}
