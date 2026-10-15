class DetalleVenta {
private Inventario inventario;
private int cantidad;
private double precioUnitarioFinal;
private double subtotal;

public DetalleVenta(Inventario inventario, int cantidad, Cliente cliente) {
    this.inventario = inventario;
    this.cantidad = cantidad;
    this.precioUnitarioFinal = 0.0;
    this.subtotal = 0.0;
    calcularSubtotal(cliente);
}

public Inventario getInventario() { return inventario; }
public void setInventario(Inventario inventario) { this.inventario = inventario; }

public int getCantidad() { return cantidad; }
public void setCantidad(int cantidad) { this.cantidad = cantidad; }

public double getPrecioUnitarioFinal() { return precioUnitarioFinal; }
public void setPrecioUnitarioFinal(double precioUnitarioFinal) { this.precioUnitarioFinal = precioUnitarioFinal; }

public double getSubtotal() { return subtotal; }
public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

@Override
public String toString() {
    return "DetalleVenta{" +
            "prenda=" + inventario.getPrenda().getNombre() +
            ", cantidad=" + cantidad +
            ", precioUnitarioFinal=" + precioUnitarioFinal +
            ", subtotal=" + subtotal +
            '}';
}

public void calcularSubtotal(Cliente cliente) {
    double precioRecargo = this.inventario.getPrenda().calcularPrecioRecargo();
    double descuento = cliente.obtenerDescuento();
    this.precioUnitarioFinal = precioRecargo - (precioRecargo * descuento);
    this.subtotal = this.precioUnitarioFinal * this.cantidad;
}
}

