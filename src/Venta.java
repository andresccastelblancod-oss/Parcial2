import java.util.ArrayList;
import java.util.List;

public class Venta {
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
    public String getFecha() { return fecha; }
    public Sucursal getSucursal() { return sucursal; }
    public Cliente getCliente() { return cliente; }
    public Vendedor getVendedor() { return vendedor; }
    public List<DetalleVenta> getDetalles() { return detalles; }
    public double getValorTotal() { return valorTotal; }

    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setSucursal(Sucursal sucursal) { this.sucursal = sucursal; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setVendedor(Vendedor vendedor) { this.vendedor = vendedor; }
    public void setDetalles(List<DetalleVenta> detalles) { this.detalles = detalles; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }


}