import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);
    static Empresa empresa = new Empresa(
            "ModaStyle", 900123456, "Armenia, Quindío"
    );

    public static void main(String[] args) {

        Sucursal armenia = new Sucursal(
                1, "ModaStyle Armenia",
                "Carrera 14 #20-15", "Armenia"
        );

        Sucursal calarca = new Sucursal(
                2, "ModaStyle Calarcá",
                "Calle 40 #25-10", "Calarcá"
        );

        empresa.agregarSucursal(armenia);
        empresa.agregarSucursal(calarca);

        int opcion;

        do {
            System.out.println("\n========== MODASTYLE ==========");
            System.out.println("1. Registrar prenda");
            System.out.println("2. Registrar cliente o vendedor");
            System.out.println("3. Registrar inventario");
            System.out.println("4. Consultar prendas disponibles");
            System.out.println("5. Registrar venta");
            System.out.println("6. Calcular precio final de una prenda");
            System.out.println("7. Consultar total de una venta");
            System.out.println("8. Consultar prendas agotadas");
            System.out.println("9. Consultar ventas de un vendedor");
            System.out.println("10. Consultar compras de un cliente");
            System.out.println("11. Consultar ingresos de una sucursal");
            System.out.println("12. Consultar prenda más vendida");
            System.out.println("13. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    registrarPrenda();
                    break;

                case 2:
                    registrarPersona();
                    break;

                case 3:
                    registrarInventario();
                    break;

                case 4:
                    consultarDisponibles();
                    break;

                case 5:
                    registrarVenta();
                    break;

                case 6:
                    calcularPrecioFinal();
                    break;

                case 7:
                    consultarTotalVenta();
                    break;

                case 8:
                    consultarAgotados();
                    break;

                case 9:
                    consultarVentasVendedor();
                    break;

                case 10:
                    consultarComprasCliente();
                    break;

                case 11:
                    consultarIngresos();
                    break;

                case 12:
                    System.out.println(empresa.prendaMasVendida());
                    break;

                case 13:
                    System.out.println("Gracias por utilizar ModaStyle.");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 13);
    }

    // case 1
    public static void registrarPrenda() {

        System.out.println("\n--- REGISTRAR PRENDA ---");

        System.out.print("Código de la prenda: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();

        if (empresa.verificarPrenda(codigo)) {
            System.out.println("Ese código ya está registrado.");
        } else {
            System.out.print("Nombre: ");
            String nombre = entrada.nextLine();

            System.out.print("Marca: ");
            String marca = entrada.nextLine();

            System.out.print("Precio base: ");
            double precio = entrada.nextDouble();
            entrada.nextLine();

            System.out.println("Categorías:");
            System.out.println("1. CAMISETA");
            System.out.println("2. PANTALON");
            System.out.println("3. VESTIDO");
            System.out.println("4. CHAQUETA");
            System.out.println("5. CALZADO");
            System.out.print("Seleccione la categoría: ");

            int opcion = entrada.nextInt();
            entrada.nextLine();

            CategoriaPrenda categoria = CategoriaPrenda.CAMISETA;
            boolean categoriaValida = true;

            switch (opcion) {
                case 1:
                    categoria = CategoriaPrenda.CAMISETA;
                    break;
                case 2:
                    categoria = CategoriaPrenda.PANTALON;
                    break;
                case 3:
                    categoria = CategoriaPrenda.VESTIDO;
                    break;
                case 4:
                    categoria = CategoriaPrenda.CHAQUETA;
                    break;
                case 5:
                    categoria = CategoriaPrenda.CALZADO;
                    break;
                default:
                    categoriaValida = false;
                    System.out.println("Categoría no válida.");
                    break;
            }

            if (categoriaValida) {
                Prenda prenda = new Prenda(
                        codigo, nombre, marca, precio, categoria
                );

                empresa.agregarPrenda(prenda);
                System.out.println("Prenda registrada correctamente.");
            }
        }
    }

    // case 2
    public static void registrarPersona() {

        System.out.println("\n--- REGISTRAR PERSONA ---");
        System.out.println("1. Cliente");
        System.out.println("2. Vendedor");
        System.out.print("Seleccione una opción: ");

        int opcion = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Documento de identidad: ");
        String documento = entrada.nextLine();

        boolean documentoExiste = false;

        for (Cliente cliente : empresa.getListaClientes()) {
            if (cliente.getDocumento().equals(documento)) {
                documentoExiste = true;
            }
        }

        for (Vendedor vendedor : empresa.getListaVendedor()) {
            if (vendedor.getDocumento().equals(documento)) {
                documentoExiste = true;
            }
        }

        if (documentoExiste) {
            System.out.println("Ese documento ya está registrado.");
        } else if (opcion == 1) {

            System.out.print("Nombre completo: ");
            String nombre = entrada.nextLine();

            System.out.print("Correo: ");
            String correo = entrada.nextLine();

            System.out.print("Teléfono: ");
            String telefono = entrada.nextLine();

            System.out.print("Código de afiliación: ");
            String afiliacion = entrada.nextLine();

            if (empresa.verificarCliente(afiliacion)) {
                System.out.println("Ese código de afiliación ya existe.");
            } else {
                System.out.println("Categoría del cliente:");
                System.out.println("1. ORO");
                System.out.println("2. PLATA");
                System.out.println("3. BRONCE");
                System.out.print("Seleccione: ");

                int categoriaOpcion = entrada.nextInt();
                entrada.nextLine();

                CategoriaCliente categoria = CategoriaCliente.ORO;
                boolean categoriaValida = true;

                switch (categoriaOpcion) {
                    case 1:
                        categoria = CategoriaCliente.ORO;
                        break;
                    case 2:
                        categoria = CategoriaCliente.PLATA;
                        break;
                    case 3:
                        categoria = CategoriaCliente.BRONCE;
                        break;
                    default:
                        categoriaValida = false;
                        System.out.println("Categoría no válida.");
                        break;
                }

                if (categoriaValida) {
                    Cliente cliente = new Cliente(
                            documento, nombre, correo, telefono,
                            afiliacion, categoria
                    );

                    empresa.agregarCliente(cliente);
                    System.out.println("Cliente registrado correctamente.");
                }
            }

        } else if (opcion == 2) {

            System.out.print("Nombre completo: ");
            String nombre = entrada.nextLine();

            System.out.print("Correo: ");
            String correo = entrada.nextLine();

            System.out.print("Teléfono: ");
            String telefono = entrada.nextLine();

            System.out.print("Código de empleado: ");
            String codigoEmpleado = entrada.nextLine();

            if (empresa.verificarVendedor(codigoEmpleado)) {
                System.out.println("Ese código de empleado ya existe.");
            } else {
                System.out.print("Fecha de contratación: ");
                String fecha = entrada.nextLine();

                System.out.print("Salario básico: ");
                double salario = entrada.nextDouble();
                entrada.nextLine();

                int indiceSucursal = seleccionarSucursal();

                if (indiceSucursal >= 0) {
                    Sucursal sucursal = empresa.getListaSucursal().get(indiceSucursal);
                    Vendedor vendedor = new Vendedor(
                            documento, nombre, correo, telefono,
                            codigoEmpleado, fecha, salario, sucursal
                    );

                    empresa.agregarVendedor(vendedor);
                    sucursal.getListaVendedores().add(vendedor);

                    System.out.println("Vendedor registrado correctamente.");
                }
            }

        } else {
            System.out.println("Opción no válida.");
        }
    }

    // case 3
    public static void registrarInventario() {

        System.out.println("\n--- REGISTRAR INVENTARIO ---");

        int indiceSucursal = seleccionarSucursal();

        if (indiceSucursal >= 0) {
            Sucursal sucursal = empresa.getListaSucursal().get(indiceSucursal);

            System.out.print("Código de la prenda: ");
            int codigo = entrada.nextInt();
            entrada.nextLine();

            int indicePrenda = buscarPrenda(codigo);

            if (indicePrenda < 0) {
                System.out.println("La prenda no existe.");
            } else {
                Prenda prenda = empresa.getListaPrendas().get(indicePrenda);
                System.out.print("Talla: ");
                int talla = entrada.nextInt();
                entrada.nextLine();

                System.out.print("Color: ");
                String color = entrada.nextLine();

                if (sucursal.verificarInventario(codigo, talla, color)) {
                    System.out.println(
                            "Ya existe un inventario con esa prenda, talla y color."
                    );
                } else {
                    System.out.print("Cantidad disponible: ");
                    int cantidad = entrada.nextInt();
                    entrada.nextLine();

                    if (cantidad > 0) {
                        Inventario inventario = new Inventario(talla, color, cantidad);

                        inventario.setPrenda(prenda);
                        sucursal.agregarInventario(inventario);

                        System.out.println("Inventario registrado correctamente.");
                    } else {
                        System.out.println("La cantidad debe ser mayor que cero.");
                    }
                }
            }
        }
    }

    // case 4
    public static void consultarDisponibles() {

        System.out.println("\n--- CONSULTAR DISPONIBLES ---");

        int indiceSucursal = seleccionarSucursal();

        if (indiceSucursal >= 0) {
            Sucursal sucursal = empresa.getListaSucursal().get(indiceSucursal);
            sucursal.consultarDisponibles();
        }
    }

    // case 5
    public static void registrarVenta() {

        System.out.println("\n--- REGISTRAR VENTA ---");

        int indiceSucursal = seleccionarSucursal();

        if (indiceSucursal >= 0) {
            Sucursal sucursal = empresa.getListaSucursal().get(indiceSucursal);

            System.out.print("Código de la venta: ");
            String codigoVenta = entrada.nextLine();

            if (buscarVenta(codigoVenta) >= 0) {
                System.out.println("Ese código de venta ya existe.");
            } else {

                System.out.print("Código de afiliación del cliente: ");
                String codigoCliente = entrada.nextLine();

                int indiceCliente = buscarCliente(codigoCliente);

                System.out.print("Código del vendedor: ");
                String codigoVendedor = entrada.nextLine();

                int indiceVendedor = buscarVendedor(codigoVendedor);

                if (indiceCliente < 0) {
                    System.out.println("El cliente no existe.");
                } else if (indiceVendedor < 0) {
                    System.out.println("El vendedor no existe.");
                } else if (empresa.getListaVendedor().get(indiceVendedor).getSucursal().getCodigo()
                        != sucursal.getCodigo()) {
                    System.out.println(
                            "El vendedor no pertenece a esa sucursal."
                    );
                } else if (sucursal.getListaInventarios().isEmpty()) {
                    System.out.println("La sucursal no tiene inventario.");
                } else {
                    Cliente cliente = empresa.getListaClientes().get(indiceCliente);
                    Vendedor vendedor = empresa.getListaVendedor().get(indiceVendedor);

                    Venta venta = new Venta(
                            codigoVenta,
                            LocalDate.now().toString(),
                            sucursal,
                            cliente,
                            vendedor
                    );

                    List<Inventario> seleccionados = new ArrayList<>();

                    String respuesta = "S";

                    while (respuesta.equalsIgnoreCase("S")) {

                        System.out.println("\n--- INVENTARIO ---");

                        for (int i = 0;
                             i < sucursal.getListaInventarios().size(); i++) {

                            Inventario inv =
                                    sucursal.getListaInventarios().get(i);

                            System.out.println(
                                    (i + 1) + ". "
                                            + inv.getPrenda().getNombre()
                                            + " | Talla: " + inv.getTalla()
                                            + " | Color: " + inv.getColor()
                                            + " | Disponible: "
                                            + inv.getCantidadDisponible()
                            );
                        }

                        System.out.print("Número de la prenda: ");
                        int posicion = entrada.nextInt();
                        entrada.nextLine();

                        if (posicion < 1
                                || posicion > sucursal.getListaInventarios().size()) {
                            System.out.println("Selección no válida.");
                        } else {

                            Inventario inventario =
                                    sucursal.getListaInventarios().get(posicion - 1);

                            if (inventario.getCantidadDisponible() <= 0) {
                                System.out.println("Esta prenda está agotada.");
                            } else if (seleccionados.contains(inventario)) {
                                System.out.println(
                                        "Ya seleccionaste esta combinación de prenda."
                                );
                            } else {

                                System.out.print("Cantidad que desea comprar: ");
                                int cantidad = entrada.nextInt();
                                entrada.nextLine();

                                if (cantidad <= 0) {
                                    System.out.println(
                                            "La cantidad debe ser mayor que cero."
                                    );
                                } else if (cantidad
                                        > inventario.getCantidadDisponible()) {
                                    System.out.println(
                                            "No hay suficientes unidades disponibles."
                                    );
                                } else {
                                    DetalleVenta detalle = new DetalleVenta(
                                            inventario, cantidad, cliente
                                    );

                                    venta.agregarDetalle(detalle);
                                    seleccionados.add(inventario);

                                    System.out.println(
                                            "Subtotal: $" + detalle.getSubtotal()
                                    );
                                }
                            }
                        }

                        System.out.print(
                                "¿Desea agregar otra prenda? (S/N): "
                        );
                        respuesta = entrada.nextLine();
                    }

                    if (venta.getDetalles().isEmpty()) {
                        System.out.println("La venta no tiene prendas.");
                    } else {

                        System.out.println("\n--- RESUMEN DE LA VENTA ---");

                        for (DetalleVenta detalle : venta.getDetalles()) {
                            System.out.println(detalle);
                        }

                        System.out.println(
                                "Total de la venta: $" + venta.getValorTotal()
                        );

                        System.out.print(
                                "¿Confirma la venta? (S/N): "
                        );
                        String confirmacion = entrada.nextLine();

                        if (confirmacion.equalsIgnoreCase("S")) {
                            sucursal.procesarVenta(venta);
                        } else {
                            System.out.println("Venta cancelada.");
                        }
                    }
                }
            }
        }
    }

    // case 6
    public static void calcularPrecioFinal() {

        System.out.println("\n--- CALCULAR PRECIO FINAL ---");

        System.out.print("Código de la prenda: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();

        int indicePrenda = buscarPrenda(codigo);

        System.out.print("Código de afiliación del cliente: ");
        String afiliacion = entrada.nextLine();

        int indiceCliente = buscarCliente(afiliacion);

        if (indicePrenda < 0) {
            System.out.println("La prenda no existe.");
        } else if (indiceCliente < 0) {
            System.out.println("El cliente no existe.");
        } else {
            Prenda prenda = empresa.getListaPrendas().get(indicePrenda);
            Cliente cliente = empresa.getListaClientes().get(indiceCliente);
            double precio = prenda.calcularPrecioRecargo();
            double descuento = cliente.obtenerDescuento();
            double precioFinal = precio - (precio * descuento);

            System.out.println("Precio base: $" + prenda.getPrecioBase());
            System.out.println("Precio con recargo: $" + precio);
            System.out.println(
                    "Descuento del cliente: " + (descuento * 100) + "%"
            );
            System.out.println("Precio unitario final: $" + precioFinal);
        }
    }

    // case 7
    public static void consultarTotalVenta() {

        System.out.println("\n--- TOTAL DE UNA VENTA ---");

        System.out.print("Código de la venta: ");
        String codigo = entrada.nextLine();

        int indiceVenta = buscarVenta(codigo);

        if (indiceVenta < 0) {
            System.out.println("La venta no existe.");
        } else {
            Venta venta = obtenerVenta(indiceVenta);
            for (DetalleVenta detalle : venta.getDetalles()) {
                System.out.println(detalle);
            }

            System.out.println("Valor total: $" + venta.getValorTotal());
        }
    }

    // case 8
    public static void consultarAgotados() {

        System.out.println("\n--- PRENDAS AGOTADAS ---");

        for (Sucursal sucursal : empresa.getListaSucursal()) {
            sucursal.consultarAgotados();
        }
    }

    // case 9
    public static void consultarVentasVendedor() {

        System.out.println("\n--- VENTAS DEL VENDEDOR ---");

        System.out.print("Código del vendedor: ");
        String codigo = entrada.nextLine();

        int indiceVendedor = buscarVendedor(codigo);

        if (indiceVendedor < 0) {
            System.out.println("El vendedor no existe.");
        } else if (empresa.getListaVendedor().get(indiceVendedor).getVentasRegistradas().isEmpty()) {
            System.out.println("El vendedor no tiene ventas registradas.");
        } else {
            Vendedor vendedor = empresa.getListaVendedor().get(indiceVendedor);
            double total = 0;

            for (Venta venta : vendedor.getVentasRegistradas()) {
                System.out.println(
                        "Venta: " + venta.getCodigo()
                                + " | Fecha: " + venta.getFecha()
                                + " | Total: $" + venta.getValorTotal()
                );

                total += venta.getValorTotal();
            }

            System.out.println("Total vendido: $" + total);
        }
    }

    // case 10
    public static void consultarComprasCliente() {

        System.out.println("\n--- COMPRAS DEL CLIENTE ---");

        System.out.print("Código de afiliación: ");
        String codigo = entrada.nextLine();

        int indiceCliente = buscarCliente(codigo);

        if (indiceCliente < 0) {
            System.out.println("El cliente no existe.");
        } else if (empresa.getListaClientes().get(indiceCliente).getComprasRealizadas().isEmpty()) {
            System.out.println("El cliente no tiene compras registradas.");
        } else {
            Cliente cliente = empresa.getListaClientes().get(indiceCliente);
            double total = 0;

            for (Venta venta : cliente.getComprasRealizadas()) {
                System.out.println(
                        "Venta: " + venta.getCodigo()
                                + " | Fecha: " + venta.getFecha()
                                + " | Total: $" + venta.getValorTotal()
                );

                total += venta.getValorTotal();
            }

            System.out.println("Total de compras: $" + total);
        }
    }

    // case 11
    public static void consultarIngresos() {

        System.out.println("\n--- INGRESOS DE SUCURSAL ---");

        int indiceSucursal = seleccionarSucursal();

        if (indiceSucursal >= 0) {
            Sucursal sucursal = empresa.getListaSucursal().get(indiceSucursal);
            System.out.println(
                    "Ingresos totales de " + sucursal.getNombre()
                            + ": $" + sucursal.ingresosTotales()
            );
        }
    }

    // case 12
    public static int seleccionarSucursal() {

        System.out.println("\nSucursales:");

        for (Sucursal sucursal : empresa.getListaSucursal()) {
            System.out.println(
                    sucursal.getCodigo() + ". " + sucursal.getNombre()
            );
        }

        System.out.print("Código de la sucursal: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();

        for (int i = 0; i < empresa.getListaSucursal().size(); i++) {
            if (empresa.getListaSucursal().get(i).getCodigo() == codigo) {
                return i;
            }
        }

        System.out.println("La sucursal no existe.");
        return -1;
    }

    public static int buscarPrenda(int codigo) {
        for (int i = 0; i < empresa.getListaPrendas().size(); i++) {
            if (empresa.getListaPrendas().get(i).getCodigoPrenda() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public static int buscarCliente(String afiliacion) {
        for (int i = 0; i < empresa.getListaClientes().size(); i++) {
            if (empresa.getListaClientes().get(i).getCodigoAfiliacion().equals(afiliacion)) {
                return i;
            }
        }
        return -1;
    }

    public static int buscarVendedor(String codigo) {
        for (int i = 0; i < empresa.getListaVendedor().size(); i++) {
            if (empresa.getListaVendedor().get(i).getCodigoEmpleado().equals(codigo)) {
                return i;
            }
        }
        return -1;
    }

    public static int buscarVenta(String codigo) {
        int indice = 0;
        for (Sucursal sucursal : empresa.getListaSucursal()) {
            for (Venta venta : sucursal.getListaVentas()) {
                if (venta.getCodigo().equals(codigo)) {
                    return indice;
                }
                indice++;
            }
        }
        return -1;
    }

    public static Venta obtenerVenta(int indiceBuscado) {
        int indice = 0;
        for (Sucursal sucursal : empresa.getListaSucursal()) {
            for (Venta venta : sucursal.getListaVentas()) {
                if (indice == indiceBuscado) {
                    return venta;
                }
                indice++;
            }
        }
        return empresa.getListaSucursal().get(0).getListaVentas().get(0);
    }

}



