public class Empresa {
    private String nombreComercial;
    private int NIT;
    private String direccionPrincipal;

    public Empresa(String nombreComercial, int NIT,String direccionPrincipal) {
        this.nombreComercial = nombreComercial;
        this.NIT=NIT;
        this.direccionPrincipal=direccionPrincipal;

    }
    public String getNombreComercial() {
        return nombreComercial;
    }
    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }
    public int getNIT() {
        return NIT;
    }
    public void setNIT(int NIT) {
        this.NIT = NIT;
    }
    public String getDireccionPrincipal() {
        return direccionPrincipal;
    }
    public void setDireccionPrincipal(String direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", NIT=" + NIT +
                ", direccionPrincipal='" + direccionPrincipal + '\'' +
                '}';
    }

}
