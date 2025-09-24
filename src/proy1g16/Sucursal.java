package proy1g16;

public class Sucursal {
    private String nombreSucursal;
    private NodoLibro head;

    public Sucursal(String nombreSucursal) {
        super();
        this.nombreSucursal = nombreSucursal;
        head = new NodoLibro(null, null);
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public double CalcularPrecioLibros() {
        NodoLibro aux = head;
        double total = 0;
        while (aux.getNext() != null) {
            total += aux.getNext().getLibro().getPrecio();
            aux = aux.getNext();
        }
        return total;
    }

    public String MostrarDatosLibro(String isbn, String nombreSucursal) {
        NodoLibro aux = head;
        String dato = "";
        while (aux.getNext() != null) {
            if (aux.getNext().getLibro().getIsbn().equals(isbn)) {
                if (aux.getNext().getLibro() instanceof LibroDigital) {
                    dato = dato
                        + "|Sucursal: " + nombreSucursal
                        + "|ISBN: " + aux.getNext().getLibro().getIsbn()
                        + "|Título: " + aux.getNext().getLibro().getTitulo()
                        + "|Precio: " + aux.getNext().getLibro().getPrecio()
                        + "|Tamaño de archivo: " + ((LibroDigital) aux.getNext().getLibro()).getTamanoArchivo();
                } else {
                    dato = dato
                        + "|Sucursal: " + nombreSucursal
                        + "|ISBN: " + aux.getNext().getLibro().getIsbn()
                        + "|Título: " + aux.getNext().getLibro().getTitulo()
                        + "|Precio: " + aux.getNext().getLibro().getPrecio();
                    return dato;
                }
            }
            aux = aux.getNext();
        }
        return dato;
    }

    public boolean BuscarLibro(String isbn) {
        NodoLibro aux = head;
        while (aux.getNext() != null) {
            if (aux.getNext().getLibro().getIsbn().equals(isbn))
                return true;
            aux = aux.getNext();
        }
        return false;
    }

    public boolean AgregarLibro(Libro nuevo) {
        NodoLibro aux = new NodoLibro(null, nuevo);
        aux.setNext(head.getNext());
        head.setNext(aux);
        return true;
    }

    public int EliminarLibro(String isbn) {
        NodoLibro aux = head;
        while (aux.getNext() != null) {
            if (aux.getNext().getLibro().getIsbn().equals(isbn)) {
                aux.setNext(aux.getNext().getNext());
                return 1;
            }
            aux = aux.getNext();
        }
        return -1;
    }

    public int BuscarYDevolverTipoDeContenido(String codigo) {
        NodoLibro aux = head;
        while (aux.getNext() != null) {
            if (aux.getNext().getLibro().getIsbn().equals(codigo)) {
                if (aux.getNext().getLibro() instanceof LibroDigital) {
                    return ((LibroDigital) aux.getNext().getLibro()).getTamanoArchivo();
                } else {
                    return -1; 
                }
            }
            aux = aux.getNext();
        }
        return -1; 
    }

    public boolean BuscarTipoContenido(int contenido) {
        NodoLibro aux = head;
        while (aux.getNext() != null) {
            if (aux.getNext().getLibro() instanceof LibroDigital) {
                if (((LibroDigital) aux.getNext().getLibro()).getTamanoArchivo() == contenido) {
                    return true;
                }
            }
            aux = aux.getNext();
        }
        return false;
    }
    
    public Libro BuscarYDevolverLibro(String isbn) {
        NodoLibro aux = head;
        while (aux.getNext() != null) {
            if (aux.getNext().getLibro().getIsbn().equals(isbn)) {
                return aux.getNext().getLibro();
            }
            aux = aux.getNext();
        }
        return null;
    }  
}
