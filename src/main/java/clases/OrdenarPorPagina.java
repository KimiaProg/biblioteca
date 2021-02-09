package clases;

import java.util.Comparator;

public class OrdenarPorPagina extends Libro implements Comparator<Libro> {

	public OrdenarPorPagina() {
		
	}
	@Override
	public int compare(Libro libro1, Libro libro2) {
		return libro1.getPaginas() - libro2.getPaginas();
	}
}
