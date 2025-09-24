package proy1g16;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        CadenaLibrerias cadena = new CadenaLibrerias();
        int i = 0;
        while (i != 1) {
            System.out.println("*************** Menú ***************");
            System.out.println("1. Agregar una sucursal por nombre");
            System.out.println("2. Eliminar la última sucursal");
            System.out.println("3. Eliminar sucursal por nombre");
            System.out.println("4. Buscar sucursal por nombre");
            System.out.println("5. Agregar libro a una sucursal");
            System.out.println("6. Agregar libro digital a una sucursal");
            System.out.println("7. Eliminar libro de una sucursal");
            System.out.println("8. Mostrar datos de un libro por ISBN");
            System.out.println("9. Calcular el precio total de los libros de una sucursal");
            System.out.println("10. Cantidad de libros distintos registrados en la cadena");
            System.out.println("11. Promedio del tamaño de archivo de los libros digitales distintos en la cadena");
            System.out.println("12. Documentación");
            System.out.println("13. Cerrar menú");
            System.out.println("************************************");
            int opcion = Integer.parseInt(lector.readLine());

            String nombreSuc;
            String isbn;
            String titulo;
            double precio;
            int tamanoArchivo;

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de la sucursal");
                    nombreSuc = lector.readLine();
                    if (cadena.agregarSucursal(nombreSuc)) {
                        System.out.println("La sucursal se ha agregado exitosamente");
                    } else {
                        System.out.println("La sucursal no se ha agregado porque ya existe");
                    }
                    break;
                case 2:
                    if (cadena.eliminarUltimo()) {
                        System.out.println("La última sucursal agregada se ha eliminado exitosamente");
                    } else {
                        System.out.println("No se pudo eliminar porque la cadena está vacía");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la sucursal");
                    nombreSuc = lector.readLine();
                    if (cadena.eliminarSucursalPorNombre(nombreSuc)) {
                        System.out.println("La sucursal se ha eliminado exitosamente");
                    } else {
                        System.out.println("No se encontró esa sucursal");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de la sucursal");
                    nombreSuc = lector.readLine();
                    if (cadena.buscarSucursal(nombreSuc)) {
                        System.out.println("Se ha encontrado la sucursal");
                    } else {
                        System.out.println("No se ha encontrado la sucursal");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el nombre de la sucursal a la que desea agregar el libro");
                    nombreSuc = lector.readLine();
                    System.out.println("Ingrese el ISBN del libro");
                    isbn = lector.readLine();
                    System.out.println("Ingrese el título del libro");
                    titulo = lector.readLine();
                    System.out.println("Ingrese el precio del libro");
                    precio = Double.parseDouble(lector.readLine());
                    if (cadena.AgregarLibro(nombreSuc, isbn, titulo, precio, 0) == 1) {
                        System.out.println("El libro se ha agregado exitosamente");
                        cadena.agregarTipoDeContenido(isbn);
                    } else {
                        System.out.println("No se pudo agregar (ISBN repetido o sucursal no existe)");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el nombre de la sucursal a la que desea agregar el libro digital");
                    nombreSuc = lector.readLine();
                    System.out.println("Ingrese el ISBN del libro digital");
                    isbn = lector.readLine();
                    System.out.println("Ingrese el título del libro digital");
                    titulo = lector.readLine();
                    System.out.println("Ingrese el precio del libro digital");
                    precio = Double.parseDouble(lector.readLine());
                    System.out.println("Ingrese el tamaño de archivo del libro digital (entero)");
                    tamanoArchivo = Integer.parseInt(lector.readLine());
                    if (cadena.AgregarLibro(nombreSuc, isbn, titulo, precio, tamanoArchivo) == 1) {
                        cadena.agregarTipoDeContenido(isbn);
                        System.out.println("El libro digital se ha agregado exitosamente");
                    } else {
                        System.out.println("No se pudo agregar (ISBN repetido o sucursal no existe)");
                    }
                    break;
                case 7:
                    System.out.println("Ingrese el nombre de la sucursal");
                    nombreSuc = lector.readLine();
                    System.out.println("Ingrese el ISBN del libro a eliminar");
                    isbn = lector.readLine();
                    int tipo = cadena.ObtenerTipoDeContenido(isbn);
                    if (cadena.EliminarLibro(nombreSuc, isbn) == 1) {
                        cadena.eliminarTipoDeContenido(tipo);
                        System.out.println("El libro se ha eliminado correctamente");
                    } else {
                        System.out.println("No se pudo eliminar (ISBN no encontrado o sucursal no existe)");
                    }
                    break;
                case 8:
                    System.out.println("Ingrese el nombre de la sucursal");
                    nombreSuc = lector.readLine();
                    System.out.println("Ingrese el ISBN del libro");
                    isbn = lector.readLine();
                    String datos = cadena.mostrarDatosLibroPorISBN(nombreSuc, isbn);
                    if (datos.equals("ISBNNoEncontrado")) {
                        System.out.println("El libro no se encontró porque no existe");
                    } else if (datos.equals("")) {
                        System.out.println("No se encontró la sucursal");
                    } else {
                        System.out.println(datos);
                    }
                    break;
                case 9:
                    System.out.println("Ingrese el nombre de la sucursal");
                    nombreSuc = lector.readLine();
                    double total = cadena.CalcularPrecioTotalDeLibrosDeUnaSucursal(nombreSuc);
                    if (total == 0) {
                        System.out.println("La sucursal no existe o no tiene libros registrados");
                    } else {
                        System.out.println("El precio total de los libros de la sucursal " + nombreSuc + " es: " + total);
                    }
                    break;
                case 10:
                    System.out.println("El número total de libros distintos en la cadena es: " + cadena.NumeroTotalLibrosEnParalelo());
                    break;
                case 11:
                    System.out.println("El promedio del tamaño de archivo de los libros digitales distintos en la cadena es: " + cadena.PromedioTamanoArchivoLibrosDigitalesDistintos());
                    break;
                case 12:
                    System.out.println(" o Nombre de la Clase A: CadenaLibrerias");
                    System.out.println(" o Nombre de la Clase B: Sucursal");
                    System.out.println(" o Atributo identificador clase B: nombreSucursal (String)");
                    System.out.println(" o Principio utilizado por la lista en la clase B: Pila");
                    System.out.println(" o Nombre de la Clase C: Libro");
                    System.out.println(" o Atributo identificador clase C: ISBN (String)");
                    System.out.println(" o Nombre de la Clase D: LibroDigital (+tamanoArchivo, int)");
                    break;
                case 13:
                    i = 1;
                    System.out.println("¡Hasta luego!");
                    break;
            }
        }
    }
}
