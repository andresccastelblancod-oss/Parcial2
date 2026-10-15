import java.util.ArrayList;
import java.util.List;

class Empresa {
    private String nombreComercial;
    private int NIT;
    private String direccionPrincipal;
    private List<Prenda> listaPrendas;
    private List<Cliente> listaClientes;
    private List<Vendedor> listaVendedor;
    private List<Sucursal> listaSucursal;

    public Empresa(String nombreComercial, int NIT, String direccionPrincipal) {
        this.nombreComercial = nombreComercial;
        this.NIT = NIT;
        this.direccionPrincipal = direccionPrincipal;
        this.listaPrendas = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaVendedor = new ArrayList<>();
        this.listaSucursal = new ArrayList<>();
    }

    public String getNombreComercial() { return nombreComercial; }
    public void setNombreComercial(String nombreComercial) { this.nombreComercial = nombreComercial; }

    public int getNIT() { return NIT; }
    public void setNIT(int NIT) { this.NIT = NIT; }

    public String getDireccionPrincipal() { return direccionPrincipal; }
    public void setDireccionPrincipal(String direccionPrincipal) { this.direccionPrincipal = direccionPrincipal; }

    public List<Prenda> getListaPrendas() { return listaPrendas; }
    public void setListaPrendas(List<Prenda> listaPrendas) { this.listaPrendas = listaPrendas; }

    public List<Cliente> getListaClientes() { return listaClientes; }
    public void setListaClientes(List<Cliente> listaClientes) { this.listaClientes = listaClientes; }

    public List<Vendedor> getListaVendedor() { return listaVendedor; }
    public void setListaVendedor(List<Vendedor> listaVendedor) { this.listaVendedor = listaVendedor; }

    public List<Sucursal> getListaSucursal() { return listaSucursal; }
    public void setListaSucursal(List<Sucursal> listaSucursal) { this.listaSucursal = listaSucursal; }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", NIT=" + NIT +
                ", direccionPrincipal='" + direccionPrincipal + '\'' +
                '}';
    }

    public boolean verificarPrenda(int codigo) {
        boolean existe = false;
        for (Prenda prenda : listaPrendas) {
            if (prenda.getCodigoPrenda() == codigo) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean agregarPrenda(Prenda prenda) {
        boolean seAgrego = false;
        if (!verificarPrenda(prenda.getCodigoPrenda())) {
            listaPrendas.add(prenda);
            seAgrego = true;
        }
        return seAgrego;
    }

    public boolean verificarCliente(String codigoAfiliacion) {
        boolean existe = false;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCodigoAfiliacion().equals(codigoAfiliacion)) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean agregarCliente(Cliente cliente) {
        boolean seAgrego = false;
        if (!verificarCliente(cliente.getCodigoAfiliacion())) {
            listaClientes.add(cliente);
            seAgrego = true;
        }
        return seAgrego;
    }

    public boolean verificarVendedor(String codigoEmpleado) {
        boolean existe = false;
        for (Vendedor vendedor : listaVendedor) {
            if (vendedor.getCodigoEmpleado().equals(codigoEmpleado)) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean agregarVendedor(Vendedor vendedor) {
        boolean seAgrego = false;
        if (!verificarVendedor(vendedor.getCodigoEmpleado())) {
            listaVendedor.add(vendedor);
            seAgrego = true;
        }
        return seAgrego;
    }

    public boolean verificarSucursal(int codigo) {
        boolean existe = false;
        for (Sucursal sucursal : listaSucursal) {
            if (sucursal.getCodigo() == codigo) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean agregarSucursal(Sucursal sucursal) {
        boolean seAgrego = false;
        if (!verificarSucursal(sucursal.getCodigo())) {
            listaSucursal.add(sucursal);
            seAgrego = true;
        }
        return seAgrego;
    }

    public String prendaMasVendida() {
        int maxVendidos = 0;
        String resultado = "No hay ventas registradas.";

        for (Prenda prenda : listaPrendas) {
            int totalVendidasPrenda = 0;
            for (Sucursal sucursal : listaSucursal) {
                for (Venta venta : sucursal.getListaVentas()) {
                    for (DetalleVenta detalle : venta.getDetalles()) {
                        if (detalle.getInventario().getPrenda().getCodigoPrenda() == prenda.getCodigoPrenda()) {
                            totalVendidasPrenda += detalle.getCantidad();
                        }
                    }
                }
            }
            if (totalVendidasPrenda > maxVendidos) {
                maxVendidos = totalVendidasPrenda;
                resultado = "La prenda más vendida es " + prenda.getNombre() +
                        " (Código: " + prenda.getCodigoPrenda() + ") con " + maxVendidos + " unidades vendidas.";
            }
        }
        return resultado;
    }
}






