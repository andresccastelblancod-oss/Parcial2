public class DetalleVenta {
    private Inventario inventario;
    private int cantidad;
    private double precioUnitarioFinal;
    private double subtotal;


    public DetalleVenta(Inventario inventario, int cantidad, Cliente cliente) {
        this.inventario = inventario;
        this.cantidad = cantidad;
        this.precioUnitarioFinal = 0.0;
        this.subtotal = 0.0;
    }


    public Inventario getInventario() { return inventario; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitarioFinal() { return precioUnitarioFinal; }
    public double getSubtotal() { return subtotal; }


    public void setInventario(Inventario inventario) { this.inventario = inventario; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPrecioUnitarioFinal(double precioUnitarioFinal) { this.precioUnitarioFinal = precioUnitarioFinal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }


}
