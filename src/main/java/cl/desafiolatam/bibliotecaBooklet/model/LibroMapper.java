package cl.desafiolatam.bibliotecaBooklet.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LibroMapper implements RowMapper<Libro>{

	@Override
	public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
		Libro libro = new Libro();
		libro.setId(rs.getInt("id"));
		libro.setTitulo(rs.getString("titulo"));
		libro.setAnio(rs.getInt("anio"));
		libro.setAutor(rs.getString("autor"));
		libro.setImprenta(rs.getString("imprenta"));
		libro.setDisponible(rs.getBoolean("disponible"));
		return libro;
	}

}