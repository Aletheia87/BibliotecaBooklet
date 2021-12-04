package cl.desafiolatam.bibliotecaBooklet.model;

public class Libro {

	private Integer id;
	private String titulo;
	private Integer anio;
	private String autor;
	private String imprenta;
	private Boolean disponible;
	
	public Libro() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImprenta() {
		return imprenta;
	}

	public void setImprenta(String imprenta) {
		this.imprenta = imprenta;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}


	public Libro(Integer id, String titulo, Integer anio, String autor, String imprenta, Boolean disponible) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anio = anio;
		this.autor = autor;
		this.imprenta = imprenta;
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", anio=" + anio + ", autor=" + autor + ", imprenta="
				+ imprenta + ", disponible=" + disponible + "]";
	}
	
	
}