package br.com.eponciano.model.thymeleaf.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.eponciano.model.thymeleaf.model.StudentDTO;

@ControllerAdvice
public class ValidationControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String handleValidationExceptions(MethodArgumentNotValidException ex, Model model) {
		Map<String, String> errors = new HashMap<>();

		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}

		model.addAttribute("validationErrors", errors);
		Object target = ex.getBindingResult().getTarget();

		// Mantém o valor de "edit" na tela de cadastro
		if (!model.containsAttribute("edit")) {
			model.addAttribute("edit", false);
		}
		
		//para caso houver mais de um objeto a ser validado
		if (target instanceof StudentDTO) {
			model.addAttribute("student", target);
			return "formStudent";
		}

		return "errorPage"; // Página de erro genérica
	}


}
