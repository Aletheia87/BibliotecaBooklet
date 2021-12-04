package cl.desafiolatam.bibliotecaBooklet.service;

import cl.desafiolatam.bibliotecaBooklet.model.Libro;
import cl.desafiolatam.bibliotecaBooklet.vo.LibroVO;

public interface ILibroService {

	public LibroVO getAllLibros();
	public LibroVO add(Libro libro);
	public LibroVO update(Libro libro);
	public LibroVO updateDisponibilidad(Libro libro);
	public LibroVO delete(Libro libro);
	public LibroVO findById(Integer id);
	public LibroVO findByTitulo(String titulo);
	public LibroVO findByAutor(String autor);
	
	
}