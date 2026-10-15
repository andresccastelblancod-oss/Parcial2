import java.util.ArrayList;
import java.util.List;

class Sucursal {
    private int codigo;
    private String nombre;
    private String direccion;
    private String ciudad;
    private List<Inventario> listaInventarios;
    private List<Vendedor> listaVendedores;
    private List<Venta> listaVentas;

    public Sucursal(int codigo, String nombre, String direccion, String ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.listaInventarios = new ArrayList<>();
        this.listaVendedores = new ArrayList<>();
        this.listaVentas = new ArrayList<>();
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public List<Inventario> getListaInventarios() { return listaInventarios; }
    public void setListaInventarios(List<Inventario> listaInventarios) { this.listaInventarios = listaInventarios; }

    public List<Vendedor> getListaVendedores() { return listaVendedores; }
    public void setListaVendedores(List<Vendedor> listaVendedores) { this.listaVendedores = listaVendedores; }

    public List<Venta> getListaVentas() { return listaVentas; }
    public void setListaVentas(List<Venta> listaVentas) { this.listaVentas = listaVentas; }

    @Override
    public String toString() {
        return "Sucursal{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }

    public boolean verificarInventario(int codigoPrenda, int talla, String color) {
        boolean existe = false;
        for (Inventario inv : listaInventarios) {
            if (inv.getPrenda().getCodigoPrenda() == codigoPrenda &&
                    inv.getTalla() == talla &&
                    inv.getColor().equalsIgnoreCase(color)) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean agregarInventario(Inventario inventario) {
        boolean existe = false;
        for (Inventario inv : listaInventarios) {
            if (inv.getPrenda().getCodigoPrenda() == inventario.getPrenda().getCodigoPrenda() &&
                    inv.getTalla() == inventario.getTalla() &&
                    inv.getColor().equalsIgnoreCase(inventario.getColor())) {

                inv.setCantidadDisponible(inv.getCantidadDisponible() + inventario.getCantidadDisponible());
                existe = true;
            }
        }

        if (!existe) {
            listaInventarios.add(inventario);
        }
        return true;
    }

    public void consultarDisponibles() {
        System.out.println("--- Inventario Disponible en " + nombre + " ---");
        for (Inventario inv : listaInventarios) {
            if (inv.getCantidadDisponible() > 0) {
                System.out.println(inv.getPrenda().getNombre() + " | Talla: " + inv.getTalla() +
                        " | Color: " + inv.getColor() + " | Disponible: " + inv.getCantidadDisponible());
            }
        }
    }

    public void consultarAgotados() {
        System.out.println("--- Inventario Agotado en " + nombre + " ---");
        for (Inventario inv : listaInventarios) {
            if (inv.getCantidadDisponible() == 0) {
                System.out.println(inv.getPrenda().getNombre() + " | Talla: " + inv.getTalla() +
                        " | Color: " + inv.getColor() + " | Agotado");
            }
        }
    }

    public boolean procesarVenta(Venta venta) {
        boolean stockSuficiente = true;

        for (DetalleVenta detalle : venta.getDetalles()) {
            if (detalle.getInventario().getCantidadDisponible() < detalle.getCantidad()) {
                stockSuficiente = false;
                System.out.println("Error: Stock insuficiente de " + detalle.getInventario().getPrenda().getNombre());
            }
        }

        if (stockSuficiente) {
            for (DetalleVenta detalle : venta.getDetalles()) {
                Inventario inv = detalle.getInventario();
                inv.setCantidadDisponible(inv.getCantidadDisponible() - detalle.getCantidad());
                inv.agregarDetalleVenta(detalle);
            }

            this.listaVentas.add(venta);
            venta.getCliente().agregarCompra(venta);
            venta.getVendedor().agregarVenta(venta);
            System.out.println("Venta " + venta.getCodigo() + " procesada con éxito.");
            return true;
        }

        return false;
    }

    public double ingresosTotales() {
        double total = 0.0;
        for (Venta venta : listaVentas) {
            total += venta.getValorTotal();
        }
        return total;
    }
}