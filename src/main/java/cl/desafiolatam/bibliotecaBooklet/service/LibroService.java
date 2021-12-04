package cl.desafiolatam.bibliotecaBooklet.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.bibliotecaBooklet.BibliotecaBookletApplication;
import cl.desafiolatam.bibliotecaBooklet.model.Libro;
import cl.desafiolatam.bibliotecaBooklet.repository.ILibroRepository;
import cl.desafiolatam.bibliotecaBooklet.vo.LibroVO;

@Service
public class LibroService implements ILibroService{

	@Autowired
	ILibroRepository repository;
	
	
	LibroVO respuesta;
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(BibliotecaBookletApplication.class);

	@Override
	public LibroVO getAllLibros() {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "101");
		try {
			respuesta.setLibros((List<Libro>) repository.getAllLibros());
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuesta.getLibros().size()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Libro Service: Error en getAllLibros", e);
		}
		return respuesta;

	}

	@Override
	public LibroVO add(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "102");
		try {
			repository.add(libro);
			respuesta.setMensaje(String.format("Se ha guardado correctamente al libro %s", libro.getTitulo()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Libro Service: Error en add", e);
		}
		return respuesta;
	}


	@Override
	public LibroVO update(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "103");
		try {
			repository.update(libro);
			respuesta.setMensaje(String.format("Se ha actualizado correctamente al libro %s", libro.getTitulo()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Libro Service: Error en update", e);
		}
		return respuesta;

	}

	@Override
	public LibroVO updateDisponibilidad(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "104" );
		try {
			repository.updateDisponibilidad(libro);
			respuesta.setLibros(new ArrayList<Libro>());
			respuesta.setMensaje(String.format("Se ha actualizado disponible correctamente al libro %s", libro.getTitulo()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.error("Libro Service: Error en actualizarDisponible", e);
		}
		return respuesta;
}

	@Override
	public LibroVO delete(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "105" );
				try {
				repository.delete(libro);
				respuesta.setMensaje("Se ha eliminado correctamente al Libro");
				respuesta.setCodigo("0");
				} catch (Exception e) {
				logger.trace("Libro Service: Error en delete", e);
				}
				return respuesta;
				
	}

	@Override
	public LibroVO findById(Integer id) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "106");
		try {
		//	Libro libro = repository.findById(id).get(0);
			System.out.println(repository.findById(id));
			respuesta.getLibros().add(repository.findById(id));
			respuesta.setMensaje("Libro encontrado correctamente.");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Libro Service: Error en findById", e);
		}
		return respuesta;
	}


	@Override
	public LibroVO findByTitulo(String titulo) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "107");
		try {
		//	Libro libro = repository.findById(id).get(0);
			respuesta.getLibros().add(repository.findByTitulo(titulo));
			respuesta.setMensaje("Libro encontrado correctamente.");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Libro Service: Error en findById", e);
		}
		return respuesta;
	}

	@Override
	public LibroVO findByAutor(String autor) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "108");
		try {
		//	Libro libro = repository.findById(id).get(0);
			respuesta.getLibros().add(repository.findByAutor(autor));
			respuesta.setMensaje("Libro encontrado correctamente.");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Libro Service: Error en findById", e);
		}
		return respuesta;
	}
	
}

