class Prenda {
    private int codigoPrenda;
    private String nombre;
    private String marca;
    private double precioBase;
    private CategoriaPrenda categoria;

    public Prenda(int codigoPrenda, String nombre, String marca, double precioBase, CategoriaPrenda categoria) {
        this.codigoPrenda = codigoPrenda;
        this.nombre = nombre;
        this.marca = marca;
        this.precioBase = precioBase;
        this.categoria = categoria;
    }

    public int getCodigoPrenda() { return codigoPrenda; }
    public void setCodigoPrenda(int codigoPrenda) { this.codigoPrenda = codigoPrenda; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public CategoriaPrenda getCategoria() { return categoria; }
    public void setCategoria(CategoriaPrenda categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return "Prenda{" +
                "codigo=" + codigoPrenda +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", precioBase=" + precioBase +
                ", categoria=" + categoria +
                '}';
    }

    public int obtenerCodigoPrenda() {
        return this.codigoPrenda;
    }

    public double calcularPrecioRecargo() {
        switch (this.categoria) {
            case VESTIDO:  return this.precioBase * 1.10; // 10% recargo
            case CHAQUETA: return this.precioBase * 1.15; // 15% recargo
            case CALZADO:  return this.precioBase * 1.05; // 5% recargo
            default:       return this.precioBase;        // CAMISETA / PANTALON
        }
    }
}