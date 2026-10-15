import java.util.ArrayList;
import java.util.List;

class Vendedor extends Persona {
    private String codigoEmpleado;
    private String fechaContratacion;
    private double salarioBasico;
    private Sucursal sucursal;
    private List<Venta> ventasRegistradas;

    public Vendedor(String documento, String nombreCompleto, String correo, String telefono,
                    String codigoEmpleado, String fechaContratacion, double salarioBasico, Sucursal sucursal) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salarioBasico = salarioBasico;
        this.sucursal = sucursal;
        this.ventasRegistradas = new ArrayList<>();
    }

    public String getCodigoEmpleado() { return codigoEmpleado; }
    public void setCodigoEmpleado(String codigoEmpleado) { this.codigoEmpleado = codigoEmpleado; }

    public String getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(String fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    public double getSalarioBasico() { return salarioBasico; }
    public void setSalarioBasico(double salarioBasico) { this.salarioBasico = salarioBasico; }

    public Sucursal getSucursal() { return sucursal; }
    public void setSucursal(Sucursal sucursal) { this.sucursal = sucursal; }

    public List<Venta> getVentasRegistradas() { return ventasRegistradas; }
    public void setVentasRegistradas(List<Venta> ventasRegistradas) { this.ventasRegistradas = ventasRegistradas; }

    public String obtenerVendedor() {
        return getNombreCompleto() + " (Empleado ID: " + codigoEmpleado + ")";
    }

    public void agregarVenta(Venta venta) {
        this.ventasRegistradas.add(venta);
    }
}