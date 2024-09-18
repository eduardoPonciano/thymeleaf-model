package br.com.eponciano.model.thymeleaf.model;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentDTO {

	private UUID id = UUID.randomUUID(); 

	@NotBlank(message = "campo Nome é obrigatorio")
	private String name;
	
	@NotNull(message = "campo Turma é obrigatorio")
	private Integer grade;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

}
