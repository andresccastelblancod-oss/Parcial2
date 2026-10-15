import javax.sound.midi.MidiFileFormat;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombreComercial;
    private int NIT;
    private String direccionPrincipal;
    private List<Prenda>listaPrendas;
    private List<Cliente>listaClientes;

    public Empresa(String nombreComercial, int NIT,String direccionPrincipal) {
        this.nombreComercial = nombreComercial;
        this.NIT=NIT;
        this.direccionPrincipal=direccionPrincipal;
        this.listaPrendas=new ArrayList<>();
        this.listaClientes=new ArrayList<>();

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
    public List<Prenda> getListaPrendas() {
        return listaPrendas;
    }
    public void setListaPrendas(List<Prenda> listaPrendas) {
        this.listaPrendas = listaPrendas;
    }
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", NIT=" + NIT +
                ", direccionPrincipal='" + direccionPrincipal + '\'' +
                '}';
    }
    public boolean verificarPrenda(int codigo){
        boolean existe=false;
        for(Prenda prenda: listaPrendas){
            if(prenda.getCodigoPrenda()==codigo){
                existe=true;;
            }
        }
        return existe;
    }
    public boolean agregarPrenda(Prenda prenda){
        boolean seAgrego=false;
            if(!verificarPrenda(prenda.getCodigoPrenda())){
                listaPrendas.add(prenda);
                seAgrego=true;
            }
            return seAgrego;
    }
    public boolean verficarCliente(String codigoAfiliacion){
        boolean existe=false;
        for (Cliente cliente: listaClientes){
            if (cliente.getCodigoAfiliacion().equals(codigoAfiliacion)){
                existe=true;
            }
        }
        return existe;
    }
    public boolean agregarCliente(Cliente cliente){
        boolean seAgrego=false;
        if (!verficarCliente(cliente.getCodigoAfiliacion())){
            listaClientes.add(cliente);
            seAgrego=true;
        }
        return seAgrego;
    }


}
