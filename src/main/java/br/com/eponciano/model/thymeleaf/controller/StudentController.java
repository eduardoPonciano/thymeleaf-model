package br.com.eponciano.model.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import br.com.eponciano.model.thymeleaf.model.StudentDTO;
import br.com.eponciano.model.thymeleaf.service.StudentService;
import jakarta.validation.Valid;

/**
 * 
 * O @StudentController é responsável por expor a API REST que lida com as operações relacionadas ao
 * objeto @StudentDTO.
 * 
 * Mantendo o código limpo (Clean Code), este controller não tem responsabilidades sobre a interface
 * com o usuário ou pela renderização de páginas.
 * 
 * Este controller lida diretamente com as operações de CRUD (Create, Read, Update, Delete) para o 
 * StudentDTO, gerenciando a manipulação dos dados do estudante de forma clara e organizada.
 * 
 * Funcionalidades:
 * - GET: Obter um ou mais estudantes com base no @StudentDTO.
 * - POST: Criar um novo estudante com base nos dados recebidos no formato DTO.
 * - PUT: Atualizar um estudante existente com dados novos.
 * - DELETE: Remover um estudante do sistema.
 * 
 */
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public List<StudentDTO> getAllStudents() {
		return studentService.listAll();
	}

	@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public RedirectView saveStudent(@Valid @ModelAttribute StudentDTO student) {
		studentService.save(student);
		return new RedirectView("/list");
	}

	@PutMapping("/{id}")
	public RedirectView updateStudent(@PathVariable String id, @Valid @ModelAttribute StudentDTO studentDTO) {
		studentService.update(id, studentDTO);
		return new RedirectView("/list");
	}

	@DeleteMapping("/{id}")
	public RedirectView deleteStudent(@PathVariable String id) {
		studentService.delete(id);
		return new RedirectView("/list");
	}
}
