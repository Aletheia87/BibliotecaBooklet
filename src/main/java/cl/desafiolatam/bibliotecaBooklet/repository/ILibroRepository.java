package cl.desafiolatam.bibliotecaBooklet.repository;

import java.util.List;

import cl.desafiolatam.bibliotecaBooklet.model.Libro;

public interface ILibroRepository {
	
	public List<Libro> getAllLibros();
	public Integer add(Libro libro);
	public Integer update(Libro libro);
	public Integer updateDisponibilidad(Libro libro);
	public Integer delete(Libro libro);
	public Libro findById(Integer id);
	public Libro findByTitulo(String titulo);
	public Libro findByAutor(String autor);
	
}