import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Producto> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- Menú de Productos ---");
            System.out.println("1. Crear Producto");
            System.out.println("2. Listar Productos");
            System.out.println("3. Modificar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Crear Pedido");
            System.out.println("6. Listar Pedidos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> crearProducto();
                case 2 -> listarProductos();
                case 3 -> modificarProducto();
                case 4 -> eliminarProducto();
                case 5 -> crearPedido();
                case 6 -> listaPedidos();
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 7);
        sc.close();
    }

    public static void listaPedidos() {
        System.out.println("Listando pedidos... en proceso");
    }

    public static void crearPedido() {
        System.out.println("Creando pedido... en proceso");
    }

static void crearProducto() {
    int id = 0;
    String entradaId;

    // Validar ID numérico y único
    while (true) {
        System.out.print("ID del producto: ");
        entradaId = sc.nextLine();

        if (!esEntero(entradaId)) {
            System.out.println("⚠️ El ID debe ser un número entero.");
            continue; // pedir de nuevo
        }

        id = Integer.parseInt(entradaId);

        if (buscarProductoPorId(id) != null) {
            System.out.println("⚠️ El ID ya existe. Ingrese otro.");
            continue; // pedir de nuevo
        }

        break; // ID válido y único
    }

    // Pedir nombre (podés agregar validación si querés)
    System.out.print("Nombre: ");
    String nombre = sc.nextLine();

    // Validar precio decimal y positivo
    double precio = 0.0;
    while (true) {
        System.out.print("Precio: ");
        String entradaPrecio = sc.nextLine();

        if (!esDecimal(entradaPrecio)) {
            System.out.println("⚠️ El precio debe ser un número válido.");
            continue; // pedir de nuevo
        }

        precio = Double.parseDouble(entradaPrecio);

        if (precio <= 0) {
            System.out.println("⚠️ El precio debe ser mayor que cero.");
            continue; // pedir de nuevo
        }

        break; // precio válido
    }

    // Crear y agregar producto
    Producto nuevo = new Producto(id, nombre, precio);
    lista.add(nuevo);
    System.out.println("✅ Producto agregado correctamente.");
}

    public static void listarProductos() {
        if (lista.isEmpty()) {
            System.out.println("No hay productos cargados.");
        } else {
            for (Producto p : lista) {
                p.mostrar();
            }
        }
    }

    public static void modificarProducto() {
        System.out.print("ID del producto a modificar: ");
        int id = sc.nextInt();
        for (Producto producto : lista) {
            if (producto.getId() == id) {
                sc.nextLine();
                System.out.print("Nuevo nombre: ");
                producto.setNombre(sc.nextLine());
                System.out.print("Nuevo precio: ");
                producto.setPrecio(sc.nextDouble());
                System.out.println("Producto actualizado.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public static void eliminarProducto() {
        System.out.print("ID del producto a eliminar: ");
        int id = sc.nextInt();
        lista.removeIf(p -> p.getId() == id);
        System.out.println("Producto eliminado si existía.");
    }

// AXIlIARES (no se cuantos voy a necesitar)
// Verifica si es un entero válido
public static boolean esEntero(String texto) {
    //aca impremente el try catch
    // para verificar si el texto es un entero
    try {
        Integer.parseInt(texto);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

// Verifica si es un número decimal válido
public static boolean esDecimal(String texto) {
    //aca tambuen
    try {
        Double.parseDouble(texto);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

// Busca producto por ID en la lista
public static Producto buscarProductoPorId(int id) {
    // un for que recorre la lista
    // y si el id coincide con el del producto
    // devuelve el producto
    for (Producto p : lista) {
        if (p.getId() == id) {
            return p;
        }
    }
    return null;
}

}
