package M4_Sesion8;

public class Venta {
    private Vendedor vendedor;
    private int montoTotalVenta;

    public Venta(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getMontoTotalVenta() {
        return montoTotalVenta;
    }

    public void setMontoTotalVenta(int montoTotalVenta) {
        this.montoTotalVenta = montoTotalVenta;
    }

    @Override
    public String toString() {
        return "Venta[" +
                " vendedor=" + vendedor +
                ", ganancia=" + montoTotalVenta +
                "]";
    }
}
