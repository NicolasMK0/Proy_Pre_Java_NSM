package Pre_Entrega;
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
            System.out.println("El ID debe ser un número entero");
            continue;
        }

        id = Integer.parseInt(entradaId);

        if (buscarProductoPorId(id) != null) {
            System.out.println("El ID ya existe. Ingrese otro ID");
            continue; 
        }

        break; // ID válido y único
    }
    // no hay validacion en nombre, aun
    System.out.print("Nombre: ");
    String nombre = sc.nextLine();

    // Validar so el precio es decimal y positivo
    double precio = 0.0;
    while (true) {
        System.out.print("Precio: ");
        String entradaPrecio = sc.nextLine();

        if (!esDecimal(entradaPrecio)) {
            System.out.println("El precio debe ser un número válido.");
            continue;
        }

        precio = Double.parseDouble(entradaPrecio);

        if (precio <= 0) {
            System.out.println("El precio debe ser mayor que cero.");
            continue; // pedido de nuevo
        }

        break; // precio válido
    }

    // Crear y agregar producto
    Producto nuevo = new Producto(id, nombre, precio);
    lista.add(nuevo);
    System.out.println("Producto agregado correctamente");
}

    public static void listarProductos() {
        if (lista.isEmpty()) {
            System.out.println("No hay productos cargados");
        } else {
            for (Producto p : lista) {
                p.mostrar();
            }
        }
    }

public static void modificarProducto() {
    if (lista.isEmpty()) {
        System.out.println("No hay productos para modificar.");
        return;
    }
    int id;
    String entradaId;

    // Validar ID con esEntero y existencia
    while (true) {
        System.out.print("ID del producto a modificar [0 para salir]: ");
        entradaId = sc.nextLine();
        if (!esEntero(entradaId)) {
            System.out.println("El ID debe ser un número entero.");
            continue;
        }
        id = Integer.parseInt(entradaId);
        if (id == 0) {
            System.out.println("Modificación cancelada.");
            return;
        }
        if (id < 0) {
            System.out.println("El ID debe ser mayor o igual a cero.");
            continue;
        }
        if (buscarProductoPorId(id) == null) {
            System.out.println("El producto con ese ID no existe.");
            continue;
        }
        break;
    }
    Producto producto = buscarProductoPorId(id);
    System.out.print("Nuevo nombre: ");
    String nuevoNombre = sc.nextLine();
    String entradaPrecio;
    double nuevoPrecio;

    // Validar precio con esDecimal y valor positivo
    while (true) {
        System.out.print("Nuevo precio: ");
        entradaPrecio = sc.nextLine();
        if (!esDecimal(entradaPrecio)) {
            System.out.println("El precio debe ser un número válido.");
            continue;
        }
        nuevoPrecio = Double.parseDouble(entradaPrecio);
        if (nuevoPrecio <= 0) {
            System.out.println("El precio debe ser mayor que cero.");
            continue;
        }
        break;
    }
    producto.setNombre(nuevoNombre);
    producto.setPrecio(nuevoPrecio);
    System.out.println("Producto actualizado correctamente.");
}


public static void eliminarProducto() {
    listarProductos();
    if (lista.isEmpty()) {
        System.out.println("No presentas productos para eliminar.");
        return;
    }

    while (true) {
        System.out.print("ID del Producto a eliminar [0 para salir]: ");
        String entrada = sc.nextLine();

        // Usar auxiliar esEntero para validar
        if (!esEntero(entrada)) {
            System.out.println("Ingresa un número válido.");
            continue;
        }

        int id = Integer.parseInt(entrada);

        if (id == 0) {
            System.out.println("Saliendo...");
            return;
        }

        if (id < 0) {
            System.out.println("El ID debe ser mayor o igual a 0.");
            continue;
        }

        if (lista.stream().noneMatch(p -> p.getId() == id)) {
            System.out.println("Ese ID no existe. Intentá de nuevo.");
            continue;
        }

        lista.removeIf(p -> p.getId() == id);
        System.out.println("Producto eliminado.");
        break;
    }
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
