import java.util.ArrayList;
import java.util.List;

class Venta {
    private String codigo;
    private String fecha;
    private Sucursal sucursal;
    private Cliente cliente;
    private Vendedor vendedor;
    private List<DetalleVenta> detalles;
    private double valorTotal;

    public Venta(String codigo, String fecha, Sucursal sucursal, Cliente cliente, Vendedor vendedor) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.sucursal = sucursal;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.detalles = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public Sucursal getSucursal() { return sucursal; }
    public void setSucursal(Sucursal sucursal) { this.sucursal = sucursal; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Vendedor getVendedor() { return vendedor; }
    public void setVendedor(Vendedor vendedor) { this.vendedor = vendedor; }

    public List<DetalleVenta> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleVenta> detalles) { this.detalles = detalles; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public void agregarDetalle(DetalleVenta detalle) {
        this.detalles.add(detalle);
        this.valorTotal += detalle.getSubtotal();
    }
}