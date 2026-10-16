import java.util.ArrayList;
import java.util.List;

class Cliente extends Persona {
    private String codigoAfiliacion;
    private CategoriaCliente categoria;
    private List<Venta> comprasRealizadas;

      public Cliente(String documento, String nombreCompleto, String correo, String telefono,
            String codigoAfiliacion, CategoriaCliente categoria) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.categoria = categoria;
        this.comprasRealizadas = new ArrayList<>();
    }

    public String getCodigoAfiliacion() { return codigoAfiliacion; }
    public void setCodigoAfiliacion(String codigoAfiliacion) { this.codigoAfiliacion = codigoAfiliacion; }

    public CategoriaCliente getCategoria() { return categoria; }
    public void setCategoria(CategoriaCliente categoria) { this.categoria = categoria; }

    public List<Venta> getComprasRealizadas() { return comprasRealizadas; }
    public void setComprasRealizadas(List<Venta> comprasRealizadas) { this.comprasRealizadas = comprasRealizadas; }

    @Override
    public String toString() {
        return "Cliente{" +
                "documento='" + getDocumento() + '\'' +
                ", nombre='" + getNombreCompleto() + '\'' +
                ", codigoAfiliacion='" + codigoAfiliacion + '\'' +
                ", categoria=" + categoria +
                '}';
    }

    public double obtenerDescuento() {
        switch (this.categoria) {
            case BRONCE: return 0.05;
            case PLATA:  return 0.10;
            case ORO:    return 0.15;
            default:     return 0.0;
        }
    }

    public void agregarCompra(Venta venta) {
        this.comprasRealizadas.add(venta);
    }
}



