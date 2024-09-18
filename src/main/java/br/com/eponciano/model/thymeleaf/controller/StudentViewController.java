package br.com.eponciano.model.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eponciano.model.thymeleaf.model.StudentDTO;
import br.com.eponciano.model.thymeleaf.service.StudentService;

/**
 * O @StudentViewController é responsável por preparar e fornecer os dados necessários para as views
 * (páginas HTML) renderizadas pelo Thymeleaf.
 * 
 * Seguindo os princípios de Clean Code ao separar a responsabilidade de manipulação de dados (@StudentDTO)
 * da lógica de apresentação.
 * 
 * Este controller lida com a interação entre o usuário e a interface, preparando os dados para
 * preenchimento de formulários e listas que serão exibidos nas páginas HTML. Ele também é responsável
 * por coletar os dados enviados pelo usuário e repassá-los ao StudentController para processamento,
 * garantindo que a lógica de apresentação esteja desacoplada da lógica de negócio.
 *
 * Funcionalidades:
 * - Preparar dados (DTOs e atributos) para exibir nas páginas HTML via Thymeleaf.
 * - Receber os dados preenchidos pelo usuário e enviá-los ao StudentController para operações de CRUD.
 * - Renderizar a interface para criar, editar e visualizar estudantes.
 */
@Controller
@RequestMapping("/")
public class StudentViewController {

	@Autowired
	StudentService studentService;
	
	@GetMapping(value = { "/", "/list" })
	public String showAllStudents(ModelMap model) {
		model.addAttribute("allstudents", studentService.listAll());
		return "listStudent";
	}

	@GetMapping("/new")
	public String showNewStudentForm(ModelMap model) {
		model.addAttribute("student", new StudentDTO());		
		model.addAttribute("edit", false);
		return "formStudent";
	}
	

	@GetMapping("/edit/{id}")
	public String showEditStudentForm(@PathVariable String id, ModelMap model, StudentDTO studentDTO) {
		studentDTO=studentService.findbyId(studentDTO.getId().toString());
		model.addAttribute("student", studentDTO);
		model.addAttribute("edit", true);
		return "formStudent";
	}
}
