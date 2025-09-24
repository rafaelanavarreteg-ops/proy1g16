package proy1g16;

public class NodoLibro {
    private Libro libro;
    private NodoLibro next;

    public NodoLibro(NodoLibro next, Libro libro) {
        this.next = next;
        this.libro = libro;
    }

    public Libro getLibro() {
        return libro;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public NodoLibro getNext() {
        return next;
    }
    public void setNext(NodoLibro next) {
        this.next = next;
    }
}
