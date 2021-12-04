package cl.desafiolatam.bibliotecaBooklet.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.bibliotecaBooklet.model.Libro;
import cl.desafiolatam.bibliotecaBooklet.model.LibroMapper;

@Repository
public class LibroRepository implements ILibroRepository {

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public LibroRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public List<Libro> getAllLibros() {
		return jdbcTemplate.query("SELECT * FROM libro", new LibroMapper());
	}

	@Override
	public Integer add(Libro libro) {
		return jdbcTemplate.update("INSERT INTO libro (id, titulo, anio, autor, imprenta, disponible) VALUES (?,?,?,?,?,?)"
				, libro.getId()
				, libro.getTitulo()
				, libro.getAnio()
				, libro.getAutor()
				, libro.getImprenta()
				, libro.getDisponible()
				);
		
	}

	@Override
	public Integer update(Libro libro) {
		return jdbcTemplate.update("UPDATE libro SET titulo = ?, anio = ?, autor = ?, imprenta = ?, disponible = ? WHERE id = ?"
				, libro.getTitulo()
				, libro.getAnio()
				, libro.getAutor()
				, libro.getImprenta()
				, libro.getDisponible()
				, libro.getId()
				);
	}

	@Override
	public Integer updateDisponibilidad(Libro libro) {
		return jdbcTemplate.update("UPDATE libro SET disponible = ? WHERE id = ?"
				, libro.getDisponible()
				, libro.getId()
				);
	}

	@Override
	public Integer delete(Libro libro) {
		return jdbcTemplate.update("DELETE FROM libro WHERE id = ?"
				, libro.getId()
				);
	}

	@Override
	public Libro findById(Integer id) {
		return jdbcTemplate.query("SELECT * FROM libro WHERE id = ?", new LibroMapper(), new Object[] {id}).get(0);

	}

	@Override
	public Libro findByTitulo(String titulo) {
		return (Libro) jdbcTemplate.query("SELECT * FROM libro WHERE titulo = ?", new LibroMapper(), new Object[] {titulo});
	
	}

	@Override
	public Libro findByAutor(String autor) {
		return (Libro) jdbcTemplate.query("SELECT * FROM libro WHERE autor = ?", new LibroMapper(), new Object[] {autor});
	}
	

}