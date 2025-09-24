package proy1g16;

public class LibroDigital  extends Libro {
	    private int tamanoArchivo;

	    public LibroDigital(String isbn, String titulo, double precio, int tamanoArchivo) {
	        super(isbn, titulo, precio);
	        this.tamanoArchivo = tamanoArchivo;
	    }

	    public int getTamanoArchivo() { 
	        return tamanoArchivo; 
	    }

	    public void setTamanoArchivo(int tamanoArchivo) { 
	        this.tamanoArchivo = tamanoArchivo; 
	    }
	}


