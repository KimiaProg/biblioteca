package clases;


public class Libro implements Comparable<Libro>{

	private String titulo;
	private String isbn;
	private Genero genero;
	private String autor;
	private Integer paginas;

	public Libro() {

	}

	public Libro(String isbn) {
		this.isbn = isbn;
	}

	public Libro(String titulo, String isbn, Genero genero, String autor, Integer paginas) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.genero = genero;
		this.paginas = paginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		return "[titulo=" + titulo + ", isbn=" + isbn + ", genero=" + genero + ", autor=" + autor + ", paginas="
				+ paginas + "]";
	}

	@Override
	public boolean equals(Object libro) {
		boolean devolver = false;
		Libro libro1 = new Libro();
		libro1 = (Libro) libro;

		if (this.isbn.equalsIgnoreCase(libro1.isbn)) {
			devolver = true;
		}
		return devolver;

	}

	@Override
	public int compareTo(Libro libro) {
		int devolver = 0;
		if (this.titulo.compareToIgnoreCase(libro.titulo) == 0) {
			devolver = 0;
		} else if (this.titulo.compareToIgnoreCase(libro.titulo) < 0) {
			devolver = (-1);

		} else {
			devolver = (+1);
		}
		return devolver;
	}

	
	
	

}