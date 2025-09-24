package proy1g16;

public class NodoSucursal {
    private Sucursal sucursal;
    private NodoSucursal next;

    public NodoSucursal(Sucursal sucursal, NodoSucursal next) {
        this.sucursal = sucursal;
        this.next = next;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public NodoSucursal getNext() {
        return next;
    }
    public void setNext(NodoSucursal next) {
        this.next = next;
    }
}
