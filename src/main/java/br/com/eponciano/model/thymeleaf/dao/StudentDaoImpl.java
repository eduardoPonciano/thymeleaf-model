package br.com.eponciano.model.thymeleaf.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.eponciano.model.thymeleaf.model.StudentDTO;

/**
 * A implementação da classe @StudentDaoImpl simula o acesso a dados dos estudantes 
 * utilizando uma lista estática em memória. A classe oferece métodos para realizar operações 
 * CRUD (Create, Read, Update, Delete) sobre o objeto @StudentDTO, sem a necessidade de 
 * persistência em banco de dados.
 * 
 * Esta classe armazena os estudantes em uma lista estática e fornece métodos para listar, salvar,
 * recuperar, atualizar e excluir estudantes com base em um identificador único {@code UUID}.
 * 
 * Métodos:
 * - {@link #listAllStudents()} - Retorna uma lista de todos os estudantes armazenados.
 * - {@link #saveStudent(StudentDTO)} - Salva um novo estudante na lista.
 * - {@link #getStudent(UUID)} - Retorna um estudante específico com base no UUID fornecido.
 * - {@link #update(UUID, StudentDTO)} - Atualiza as informações de um estudante com base no UUID.
 * - {@link #delete(UUID)} - Remove um estudante com base no UUID.
 */
public class StudentDaoImpl {

	private static List<StudentDTO> ListStudent = new ArrayList<StudentDTO>();

	public static List<StudentDTO> listAllStudents() {
		return ListStudent;
	}

	public static UUID saveStudent(StudentDTO st) {
		ListStudent.add(st);
		return st.getId();
	}

	public static StudentDTO getStudent(UUID id) {
		return ListStudent.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
	}

	public static void update(UUID id, StudentDTO updateRequestDTO) {
		for (StudentDTO request : ListStudent) {
			if (request.getId().equals(id)) {
				request = updateRequestDTO;
				break;
			}
		}
	}

	public static boolean delete(UUID id) {
		return ListStudent.removeIf(request -> request.getId().equals(id));
	}

}
