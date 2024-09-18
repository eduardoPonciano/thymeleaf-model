package br.com.eponciano.model.thymeleaf.service;

import java.util.List;

import br.com.eponciano.model.thymeleaf.model.StudentDTO;

public interface StudentService {

	StudentDTO findbyId(String id);

	String save(StudentDTO st);

	List<StudentDTO> listAll();

	void update(String id, StudentDTO st);

	void delete(String id);

	boolean isStudentUnique(String id);
}
