package proy1g16;

public class LibroDigital  extends Libro {
	    private double tamanoArchivo;

	    public LibroDigital(String isbn, String titulo, double precio, double tamanoArchivo) {
	        super(isbn, titulo, precio);
	        this.tamanoArchivo = tamanoArchivo;
	    }

	    public double getTamanoArchivo() { 
	        return tamanoArchivo; 
	    }

	    public void setTamanoArchivo(double tamanoArchivo) { 
	        this.tamanoArchivo = tamanoArchivo; 
	    }
	}




