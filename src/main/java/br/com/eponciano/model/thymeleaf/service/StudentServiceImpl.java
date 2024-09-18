package br.com.eponciano.model.thymeleaf.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.eponciano.model.thymeleaf.dao.StudentDaoImpl;
import br.com.eponciano.model.thymeleaf.model.StudentDTO;
import jakarta.validation.Valid;

/**
 * A classe @StudentServiceImpl atua como uma camada de serviço entre os controladores e o DAO,
 * garantindo que as regras de negócio sejam aplicadas adequadamente.
 * 
 * Esta implementação utiliza o DAO @StudentDaoImpl para realizar as operações de CRUD
 * (Create, Read, Update, Delete) com validações adicionais e conversões de tipos quando necessário.
 * 
 * Métodos:
 * - {@link #findbyId(String)} - Busca um estudante com base no ID fornecido.
 * - {@link #save(StudentDTO)} - Salva um novo estudante no sistema.
 * - {@link #listAll()} - Retorna uma lista de todos os estudantes cadastrados.
 * - {@link #update(String, StudentDTO)} - Atualiza os dados de um estudante com base no ID fornecido.
 * - {@link #delete(String)} - Remove um estudante com base no ID fornecido.
 * - {@link #isStudentUnique(String)} - Verifica se um estudante é único no sistema.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {


	@Override
	public StudentDTO findbyId(String id) {
		UUID uuid = UUID.fromString(id);
		return StudentDaoImpl.getStudent(uuid);
	}

	@Override
	public String save(@Valid StudentDTO st) {
		UUID uuid =  StudentDaoImpl.saveStudent(st);
		return uuid.toString();
	}

	@Override
	public List<StudentDTO> listAll() {
		return StudentDaoImpl.listAllStudents();
	}

	@Override
	public void update(String id, StudentDTO st) {
		UUID uuid = UUID.fromString(id);
		StudentDTO stEntity = StudentDaoImpl.getStudent(uuid);
		if (stEntity != null) {
			stEntity.setName(st.getName());
			stEntity.setGrade(st.getGrade());
			StudentDaoImpl.update(uuid, st);
		}
	}

	@Override
	public void delete(String id) {
		UUID uuid = UUID.fromString(id);
		StudentDTO stEntity = StudentDaoImpl.getStudent(uuid);
		if (stEntity != null) {
			StudentDaoImpl.delete(uuid);
		}
	}

	@Override
	public boolean isStudentUnique(String id) {
		UUID uuid = UUID.fromString(id);
		StudentDTO student = StudentDaoImpl.getStudent(uuid);
		return (student == null || (id != null & !id.equals(student.getId())));
	}

}
