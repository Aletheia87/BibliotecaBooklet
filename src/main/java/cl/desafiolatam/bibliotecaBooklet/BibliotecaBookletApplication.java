package cl.desafiolatam.bibliotecaBooklet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cl.desafiolatam.bibliotecaBooklet.model.Libro;
import cl.desafiolatam.bibliotecaBooklet.repository.ILibroRepository;
import cl.desafiolatam.bibliotecaBooklet.service.ILibroService;
import cl.desafiolatam.bibliotecaBooklet.service.LibroService;

@SpringBootApplication
public class BibliotecaBookletApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaBookletApplication.class, args);
		
//		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(BibliotecaBookletApplication.class);
//		ILibroService libroService = acac.getBean(ILibroService.class);
//		System.out.println(libroService.findById(12));
//		ILibroRepository repository = acac.getBean(ILibroRepository.class);
//		System.out.println(repository.findById(12));
//		Libro libro = new Libro();
//		libro.setId(12);
//		libro.setTitulo("Chao");
//		repository.update(libro);
		
	}


}