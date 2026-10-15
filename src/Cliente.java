import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
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
    public CategoriaCliente getCategoria() { return categoria; }
    public List<Venta> getComprasRealizadas() { return comprasRealizadas; }


    public void setCodigoAfiliacion(String codigoAfiliacion) { this.codigoAfiliacion = codigoAfiliacion; }
    public void setCategoria(CategoriaCliente categoria) { this.categoria = categoria; }
    public void setComprasRealizadas(List<Venta> comprasRealizadas) { this.comprasRealizadas = comprasRealizadas; }

    @Override
    public String toString() {

        return "Cliente{" +
                "codigoAfiliacion='" + codigoAfiliacion + '\'' +
                ", categoria=" + categoria +
                ", comprasRealizadas=" + comprasRealizadas +
                '}';
    }
}



