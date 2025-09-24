package proy1g16;

public class CadenaLibrerias {
    private NodoSucursal lista, tail;
    private NodoLibro head;

    public CadenaLibrerias() {
        super();
        lista = new NodoSucursal(null, null);
        tail  = new NodoSucursal(null, null);
        head  = new NodoLibro(null, null);
    }

    public void agregarTipoDeContenido(String isbn) {
        NodoLibro auxLibro = head;
        NodoSucursal auxSucursal = lista;

        while (auxSucursal.getNext() != null) {
            if (auxSucursal.getNext().getSucursal().BuscarYDevolverLibro(isbn) != null)
                break;
            auxSucursal = auxSucursal.getNext();
        }

        Libro libro = auxSucursal.getNext().getSucursal().BuscarYDevolverLibro(isbn);

        while (auxLibro.getNext() != null) {
            if (auxLibro.getNext().getLibro() != null) {
                if (auxLibro.getNext().getLibro() instanceof LibroDigital &&
                    libro instanceof LibroDigital &&
                    ((LibroDigital) auxLibro.getNext().getLibro()).getTamanoArchivo() ==
                    ((LibroDigital) libro).getTamanoArchivo()) {
                    return;
                }
            }
            auxLibro = auxLibro.getNext();
        }
        auxLibro.setNext(new NodoLibro(null, libro));
    }

    public int ObtenerTipoDeContenido(String isbn) {
        NodoSucursal auxSucursal = lista;
        while (auxSucursal.getNext() != null) {
            int tipo = auxSucursal.getNext().getSucursal().BuscarYDevolverTipoDeContenido(isbn);
            if (tipo != -1) {
                return tipo;
            }
            auxSucursal = auxSucursal.getNext();
        }
        return -1;
    }

    public void eliminarTipoDeContenido(int contenido) {
        NodoLibro auxLibro = head;
        NodoSucursal auxSucursal = lista;

        while (auxSucursal.getNext() != null) {
            if (auxSucursal.getNext().getSucursal().BuscarTipoContenido(contenido) == false) {
                while (auxLibro.getNext() != null) {
                    if (auxLibro.getNext().getLibro() instanceof LibroDigital &&
                        ((LibroDigital) auxLibro.getNext().getLibro()).getTamanoArchivo() == contenido) {
                        auxLibro.setNext(auxLibro.getNext().getNext());
                        return;
                    }
                    auxLibro = auxLibro.getNext();
                }
            }
            auxSucursal = auxSucursal.getNext();
        }
    }

    public String mostrarDatosLibroPorISBN(String nombreSucursal, String isbn) {
        NodoSucursal auxSucursal = lista;
        while (auxSucursal.getNext() != null) {
            if (auxSucursal.getNext().getSucursal().getNombreSucursal().equals(nombreSucursal)) {
                if (auxSucursal.getNext().getSucursal().BuscarLibro(isbn)) {
                    return auxSucursal.getNext().getSucursal().MostrarDatosLibro(isbn, nombreSucursal);
                } else {
                    return "ISBNNoEncontrado";
                }
            }
            auxSucursal = auxSucursal.getNext();
        }
        return "";
    }

    public boolean agregarSucursal(String nombreSucursal) {
        NodoSucursal auxSucursal = lista;
        Sucursal nueva = new Sucursal(nombreSucursal);
        NodoSucursal nuevoNodo = new NodoSucursal(nueva, null);

        while (auxSucursal.getNext() != null) {
            if (auxSucursal.getNext().getSucursal().getNombreSucursal().equals(nombreSucursal)) {
                return false;
            }
            auxSucursal = auxSucursal.getNext();
        }
        tail = auxSucursal;
        tail.setNext(nuevoNodo);
        tail = tail.getNext();
        return true;
    }

    public boolean eliminarUltimo() {
        NodoSucursal auxSucursal = lista;
        if (auxSucursal.getNext() != null) {
            while (auxSucursal.getNext() != tail) {
                auxSucursal = auxSucursal.getNext();
            }
            auxSucursal.setNext(auxSucursal.getNext().getNext());
            tail = auxSucursal;
            return true;
        }
        return false;
    }

    public boolean eliminarSucursalPorNombre(String nombreSucursal) {
        NodoSucursal auxSucursal = lista;
        while (auxSucursal.getNext() != null) {
            if (auxSucursal.getNext().getSucursal().getNombreSucursal().equals(nombreSucursal)) {
                auxSucursal.setNext(auxSucursal.getNext().getNext());
                return true;
            }
            auxSucursal = auxSucursal.getNext();
        }
        return false;
    }

    public boolean buscarSucursal(String nombreSucursal) {
        NodoSucursal auxSucursal = lista;
        while (auxSucursal.getNext() != null) {
            if (auxSucursal.getNext().getSucursal().getNombreSucursal().equals(nombreSucursal)) {
                return true;
            }
            auxSucursal = auxSucursal.getNext();
        }
        return false;
    }

    public int AgregarLibro(String nombreSucursal, String isbn, String titulo, double precio, double tamanoArchivo) {
        if (tamanoArchivo == 0) {
            Libro nuevo = new Libro(isbn, titulo, precio);
            NodoSucursal auxSucursal = lista;
            while (auxSucursal.getNext() != null) {
                if (auxSucursal.getNext().getSucursal().getNombreSucursal().equals(nombreSucursal)) {
                    if (!auxSucursal.getNext().getSucursal().BuscarLibro(isbn)) {
                        auxSucursal.getNext().getSucursal().AgregarLibro(nuevo);
                        return 1; // agregado
                    } else {
                        return -1; // ISBN repetido
                    }
                }
                auxSucursal = auxSucursal.getNext();
            }
            return -1; // sucursal no existe
        } else {
            LibroDigital nuevo = new LibroDigital(isbn, titulo, precio, (int) tamanoArchivo);
            NodoSucursal auxSucursal = lista;
            while (auxSucursal.getNext() != null) {
                if (auxSucursal.getNext().getSucursal().getNombreSucursal().equals(nombreSucursal)) {
                    if (!auxSucursal.getNext().getSucursal().BuscarLibro(isbn)) {
                        auxSucursal.getNext().getSucursal().AgregarLibro(nuevo);
                        return 1;
                    } else {
                        return -1; // ISBN repetido
                    }
                }
                auxSucursal = auxSucursal.getNext();
            }
            return -1; // sucursal no existe
        }
    }

    public int EliminarLibro(String nombreSucursal, String isbn) {
        NodoSucursal auxSucursal = lista;
        while (auxSucursal.getNext() != null) {
            if (auxSucursal.getNext().getSucursal().getNombreSucursal().equals(nombreSucursal)) {
                return auxSucursal.getNext().getSucursal().EliminarLibro(isbn);
            }
            auxSucursal = auxSucursal.getNext();
        }
        return -1; // sucursal no existe
    }

    public double CalcularPrecioTotalDeLibrosDeUnaSucursal(String nombreSucursal) {
        NodoSucursal auxSucursal = lista;
        double total = 0;
        while (auxSucursal.getNext() != null) {
            if (auxSucursal.getNext().getSucursal().getNombreSucursal().equals(nombreSucursal)) {
                total = auxSucursal.getNext().getSucursal().CalcularPrecioLibros();
            }
            auxSucursal = auxSucursal.getNext();
        }
        return total;
    }

    public int NumeroTotalLibrosEnParalelo() {
        NodoLibro auxLibro = head;
        int contador = 0;
        while (auxLibro.getNext() != null) {
            contador++;
            auxLibro = auxLibro.getNext();
        }
        return contador;
    }

    public double PromedioTamanoArchivoLibrosDigitalesDistintos() {
        NodoLibro auxLibro = head;
        double sumaTotal = 0;
        int contador = 0;
        while (auxLibro.getNext() != null) {
            if (auxLibro.getNext().getLibro() instanceof LibroDigital) {
                sumaTotal += ((LibroDigital) auxLibro.getNext().getLibro()).getTamanoArchivo();
                contador++;
            }
            auxLibro = auxLibro.getNext();
        }
        if (contador == 0) {
            return 0;
        } else {
            return sumaTotal / contador;
        }
    }
}
