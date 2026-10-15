import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private int talla;
    private String color;
    private int cantidadDisponible;
    private List<DetalleVenta>detalleVentas;
    private Prenda prenda;

    public Inventario(int talla, String color, int cantidadDisponible) {
        this.talla = talla;
        this.color=color;
        this.cantidadDisponible=cantidadDisponible;
        this.detalleVentas=new ArrayList<>();
        this.prenda=prenda;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public List<DetalleVenta> getDetalleVentas() {
        return detalleVentas;
    }
    public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
        this.detalleVentas = detalleVentas;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "talla=" + talla +
                ", color='" + color + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                '}';
    }
    public void agregarDetalleVenta(DetalleVenta detalle) {
        detalleVentas.add(detalle);
    }
}
