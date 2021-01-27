/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package clases;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Libro> catalogo = new ArrayList<Libro>();
		while (true) {
			int opcion = menu();
			switch (opcion) {
			case 1:
				alta(catalogo);
				break;
				//Alta de libro
				//titulo,isbn,genero,autor,paginas
				//Llamar a un metodo alta(catologo)
			case 2:
				//Lista de libros
				break;
			default:
				break;
			}
		}
	}

	
	private static int menu() {
		int opcion = 0;
		do {
			System.out.println("Opciones:");
			System.out.println("1.Alta de libros \n2.Lista de libros");
			System.out.println("Introduce la opción:");
			opcion = leerOpcion(2);
		} while (opcion <= 0);
		return opcion;
	}

	
	private static int leerOpcion(int max) {
		int opcion = -1;
		Scanner sc = new Scanner(System.in);
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
	
	
	private static String leerCadena() {
		String opcion = null;
		Scanner sc = new Scanner(System.in);
		try {
			opcion = sc.next();
			//TODO validar la entrada
		} catch (InputMismatchException e) {
			System.out.println("Opcion incorrecta");
		}
		return opcion;
	}
	
	
	private static void alta(ArrayList<Libro> catalogo){
		//leer de la entrada
		System.out.println("Introduce los datos de los libros");
		System.out.println("Usa el formato \" \" titulo:isbn:genero:autor:paginas");
		String cadena= leerCadena();
		
		//Separando los datos del libro y Hacer el libro del cliente
		String[] arrayC=cadena.split(":");
		Integer paginasInt = Integer.getInteger(arrayC[4]);
		Genero gen= Genero.valueOf(arrayC[2]);
		catalogo.add(new Libro(arrayC[0], arrayC[1], gen, arrayC[3], paginasInt));
	}
}
