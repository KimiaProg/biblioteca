/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package clases;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Libro> catalogo = new ArrayList<Libro>();
		while (true) {
			int opcion = menu();
			switch (opcion) {
			case 1:
				alta(catalogo);
				break;
			case 2:
				listaLibro(catalogo);
				break;
			case 3:
				bajaLibro(catalogo);
				break;
			case 4:
				busquedaLibro(catalogo);
				break;
			case 5:
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Menu
	 * 
	 * @return
	 */
	private static int menu() {
		int opcion = 0;
		do {
			System.out.println("Opciones:");
			System.out.println("1. Alta de Libro");
			System.out.println("2. Lista de Libros");
			System.out.println("3. Baja de Libros");
			System.out.println("4. Búsqueda de Libros");
			System.out.println("5. Ordenacion de Libros");
			System.out.println("Introduce la opcion:");
			opcion = leerOpcion(5);
		} while (opcion <= 0);

		return opcion;
	}

	/**
	 * Lee la opcion seleccionada
	 * 
	 * @param max
	 * @return
	 */
	private static int leerOpcion(int max) {
		int opcion = -1;
		try {
			opcion = sc.nextInt();
			if (opcion > max) {
				opcion = 1;
			}
		} catch (InputMismatchException e) {
			System.out.println("Opcion incorrecta");
		}
		return opcion;
	}

	/**
	 * Obtiene los datos por consola
	 * 
	 * @return
	 */
	private static String obtenerDatosLibro() {
		String datos = null;
		boolean validado = false;
		while (!validado) {
			System.out.println("Introduce los datos de los libros");
			System.out.println("Usa el formato \" \" titulo:isbn:genero:autor:paginas");
			datos = leerCadena();
			if (datos.matches("\\w*:\\w*:\\w*:\\w*:\\w*")) {
				validado = true;
			}
		}
		return datos;
	}

	/**
	 * Convertir los datos libros recogidos po consola en un objeto Libro
	 * 
	 * @param entrada
	 * @return
	 */
	private static Libro procesoEntrada(String entrada) {
		Libro libro = null;
		// Separando los datos del libro y Hacer el libro del cliente
		String[] datos;
		Genero genero = null;
		int pagina = 0;
		boolean valido = true;

		do {
			datos = entrada.split(":");
			try {
				genero = Genero.getGenero(datos[2]);
				pagina = Integer.parseInt(datos[4]);
				valido = true;
			} catch (InputMismatchException e) {
				System.out.println("No existe este género en la librería.");
				valido = false;
				entrada = obtenerDatosLibro();
			} catch (NumberFormatException e) {
				System.out.println("El campo páginas tiene que ser un número");
				valido = false;
				entrada = obtenerDatosLibro();
			}
		} while (valido == false);

		libro = new Libro(datos[0], datos[1], genero, datos[3], pagina);

		return libro;

	}

	/**
	 * lee la cadena
	 * 
	 * @return
	 */
	private static String leerCadena() {
		String datos = null;
		try {
			datos = sc.next();
			// TODO validar la entrada
		} catch (InputMismatchException e) {
			System.out.println("Datos inválidos");
		}
		return datos;
	}

	/**
	 * El método para dar de alta a un libro
	 * 
	 * @param catalogo
	 */
	private static void alta(ArrayList<Libro> catalogo) {
		String datosLibro = obtenerDatosLibro();
		catalogo.add(procesoEntrada(datosLibro));
	}

	/**
	 * Para listar los libros existentes
	 * 
	 * @param catalogo
	 */
	private static void listaLibro(ArrayList<Libro> catalogo) {

		for (int i = 0; i < catalogo.size(); i++) {
			System.out.println("Libro " + i + ": " + catalogo.get(i).toString());
		}
		if (catalogo.size() == 0) {
			System.out.println("No hay ningún libro registrado");
		}
	}

	/**
	 * El método para dar de baja a un libro
	 * 
	 * @param catalogo
	 */
	private static void bajaLibro(ArrayList<Libro> catalogo) {
		boolean validado = false;
		String entrada = "";
		while (!validado) {
			System.out.println("A qué libro quieres dar de baja? (Escribe el "
					+ "título y el nombre del autor del libro con este formato: titulo:autor)");
			entrada = sc.next();
			if (entrada.matches("\\w*:\\w*")) {
				validado = true;
			}
		}
		String[] datos = entrada.split(":");
		String titulo = datos[0];
		String autor = datos[1];
		Libro libro = busquedaLibroCatalogo(titulo, autor, catalogo);
		if (libro != null) {
			catalogo.remove(libro);
			System.out.println("Se ha dado de baja al libro satisfactoriamente");
		} else {
			System.out.println("No existe este libro en el catálogo.");
		}

	}

	/**
	 * El método para buscar un libro y mostrarlo por pantalla
	 * 
	 * @param catalogo
	 */
	private static void busquedaLibro(ArrayList<Libro> catalogo) {
		String entrada = "";
		boolean validado = false;

		while (!validado) {
			System.out.println("Qué libro deseas buscar?");
			System.out.println("Escribe el título y el nombre del autor del libro con este formato: titulo:autor");

			entrada = sc.next();
			if (entrada.matches("\\w*:\\w*")) {
				validado = true;
			}
		}
		String[] datos = entrada.split(":");
		String titulo = datos[0];
		String autor = datos[1];

		Libro libro = busquedaLibroCatalogo(titulo, autor, catalogo);
		if (libro != null) {
			System.out.println("El libro se ha encontrado satisfactoriamente");
			System.out.println("Aquí lo tienes: " + libro.toString());
		} else {
			System.out.println("No existe este libro en el catálogo.");
		}
	}

	/**
	 * Busca un libro en el catalogo
	 * 
	 * @param titulo
	 * @param autor
	 * @param catalogo
	 * @return
	 */
	private static Libro busquedaLibroCatalogo(String titulo, String autor, ArrayList<Libro> catalogo) {
		Libro libro = null;
		for (int i = 0; i < catalogo.size(); i++) {
			if (catalogo.get(i).getAutor().equalsIgnoreCase(autor)
					&& catalogo.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				libro = catalogo.get(i);
				break;
			}
		}
		return libro;
	}

	/**
	 * Ordena los libros
	 * 
	 * @param catalogo
	 * @return
	 */
	private static ArrayList<Libro> ordenarLibro(ArrayList<Libro> catalogo) {
		return catalogo;
	}
	

}
