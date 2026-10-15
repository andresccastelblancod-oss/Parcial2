public class Inventario {
    private int talla;
    private String color;
    private int cantidadDisponible;

    public Inventario(int talla, String color, int cantidadDisponible) {
        this.talla = talla;
        this.color=color;
        this.cantidadDisponible=cantidadDisponible;

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

    @Override
    public String toString() {
        return "Inventario{" +
                "talla=" + talla +
                ", color='" + color + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                '}';
    }
}
