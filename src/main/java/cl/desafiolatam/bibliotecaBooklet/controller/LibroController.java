package cl.desafiolatam.bibliotecaBooklet.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.desafiolatam.bibliotecaBooklet.model.Libro;
import cl.desafiolatam.bibliotecaBooklet.service.LibroService;
import cl.desafiolatam.bibliotecaBooklet.vo.LibroVO;

@Controller
public class LibroController {

	private static final Logger log = LoggerFactory.getLogger(LibroController.class);
	
	@Autowired
	LibroService service;

	
	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		model.addAttribute("VO", service.getAllLibros());
		return "home";
	}
	

	@GetMapping("/editarForm")
	public ModelAndView editarForm(Model model, @RequestParam Integer id, RedirectAttributes ra) {
		LibroVO respuestaServicio = new LibroVO();
		respuestaServicio.setMensaje("No se pudo cargar la vista de edición, intente nuevamente.");
		try {
			respuestaServicio = service.findById(id);
		//	System.out.println(respuestaServicio.getLibros());
			model.addAttribute("mensaje", respuestaServicio.getMensaje());
			model.addAttribute("VO", respuestaServicio.getLibros().get(0));
			return new ModelAndView("editar");
		} catch (Exception e) {
			log.error("Error en LibroController editar", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		respuestaServicio = service.getAllLibros();
		
		return new ModelAndView("redirect:/home");
	}


	@PostMapping("/editar")
	public ModelAndView editarLibro(@ModelAttribute Libro libro, RedirectAttributes ra) {
		LibroVO respuestaServicio = service.update(libro);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		//if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
	//	} else {
//			return new ModelAndView("redirect:/editarForm");
//		}
	}
	
	
	@GetMapping("/agregarForm")
	public String agregarForm(Model model) {
		return "agregar";
	}

	
	@PostMapping("/agregar")
	public ModelAndView agregarLibro(@ModelAttribute Libro libro, RedirectAttributes ra) {
		LibroVO respuestaServicio = service.add(libro);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/agregarForm");
		}
	}
	
	
	@GetMapping("/eliminar")
	public ModelAndView eliminarLibro(Model model, @RequestParam Integer id, RedirectAttributes ra) {
		LibroVO respuestaServicio = new LibroVO();
		respuestaServicio.setMensaje("No se pudo eliminar al Libro, intente nuevamente.");
		try {
			Libro eliminado = new Libro();
			eliminado.setId(id);
			respuestaServicio = service.delete(eliminado);
			ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
			return new ModelAndView("redirect:/home");
		} catch (Exception e) {
			log.error("Error en LibroController eliminar", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());

		respuestaServicio = service.getAllLibros();
		ra.addAttribute("VO", respuestaServicio);
		return new ModelAndView("redirect:/home");
	}
	

	@GetMapping("/disponiblidad")
	public ModelAndView editarDisponilidad(@ModelAttribute Libro libro, RedirectAttributes ra) {
		LibroVO respuestaServicio = service.updateDisponibilidad(libro);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		//if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
	//	} else {
//			return new ModelAndView("redirect:/editarForm");
//		}
	}
	
	@PostMapping("/buscarLibros")
	public ModelAndView buscarLibros(@RequestParam(value = "filtro", required = false) String filtro, Model modelo) {
		if(filtro.equals("")) {
			modelo.addAttribute("libro", service.getAllLibros().getLibros());
			
		}else if (service.findByAutor(filtro).getLibros().size() == 0){
			modelo.addAttribute("libro", service.findByAutor(filtro).getLibros());
			
		}else {
			modelo.addAttribute("libro", service.findByTitulo(filtro).getLibros());
		}

		return new ModelAndView("redirect:/home");
	}
}