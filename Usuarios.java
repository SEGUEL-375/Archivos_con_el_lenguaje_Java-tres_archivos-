import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {
    private static ArrayList<String> listaUsuarios = new ArrayList<>();
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
                    registrarUsuario();
                    break;
                case 2:
                    eliminarUsuario();
                    break;
                case 3:
                    editarUsuario();
                    break;
                case 4:
                    verUsuarios();
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
        System.out.println("\n--- Menú de Usuarios ---");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Eliminar Usuario");
        System.out.println("3. Editar Usuario");
        System.out.println("4. Ver Usuarios Registrados");
        System.out.println("5. Salir");
    }

    private static void registrarUsuario() {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        listaUsuarios.add(nombre);
        System.out.println("Usuario registrado con éxito.");
    }

    private static void eliminarUsuario() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios para eliminar.");
            return;
        }

        System.out.println("Lista de usuarios:");
        mostrarListaUsuarios();

        System.out.print("Ingrese el número del usuario a eliminar: ");
        int indice = scanner.nextInt();

        if (indice >= 1 && indice <= listaUsuarios.size()) {
            String usuarioEliminado = listaUsuarios.remove(indice - 1);
            System.out.println("Usuario \"" + usuarioEliminado + "\" eliminado con éxito.");
        } else {
            System.out.println("Número de usuario no válido.");
        }
    }

    private static void editarUsuario() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios para editar.");
            return;
        }

        System.out.println("Lista de usuarios:");
        mostrarListaUsuarios();

        System.out.print("Ingrese el número del usuario a editar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer un entero

        if (indice >= 1 && indice <= listaUsuarios.size()) {
            System.out.print("Ingrese el nuevo nombre del usuario: ");
            String nuevoNombre = scanner.nextLine();
            listaUsuarios.set(indice - 1, nuevoNombre);
            System.out.println("Usuario editado con éxito.");
        } else {
            System.out.println("Número de usuario no válido.");
        }
    }

    private static void verUsuarios() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Lista de usuarios:");
            mostrarListaUsuarios();
        }
    }

    private static void mostrarListaUsuarios() {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.println((i + 1) + ". " + listaUsuarios.get(i));
        }
    }
}
