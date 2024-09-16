# Projeto Modelo: Spring Boot e Thymeleaf
Este é um projeto de exemplo que demonstra como criar um CRUD (Create, Read, Update, Delete) utilizando Spring Boot e Thymeleaf. O foco está na implementação da parte web e nos controllers, com dados armazenados em memória, ou seja, sem persistência em banco de dados. O projeto utiliza serviços RESTful para manipulação dos dados e divide os controllers em dois tipos: um para gerenciar as operações de CRUD do objeto Estudante e outro para preparar os dados entre HTML e DTOs.

# Tecnologias Utilizadas
- Java 17
- Spring Boot 3.x
- Thymeleaf
- Spring Web
- Spring MVC
- Lombok
- Dados armazenados em memória
  
# Funcionalidades
- CRUD (Create, Read, Update, Delete) para o objeto Estudante
- Interface web com Thymeleaf para interagir com o CRUD
- Controllers RESTful para gerenciar a API e a interação com a view
- Dados temporários armazenados em memória (não persistidos)

# Endpoints RESTful
1. GET /api/estudantes: Retorna a lista de todos os estudantes.
2. GET /api/estudantes/{id}: Retorna os detalhes de um estudante específico.
3. POST /api/estudantes: Cria um novo estudante.
4. PUT /api/estudantes/{id}: Atualiza os dados de um estudante existente.
5. DELETE /api/estudantes/{id}: Remove um estudante.

# Controllers
1. EstudanteController.java
Este controller é responsável pela lógica do CRUD da API RESTful. Ele gerencia as requisições de criação, leitura, atualização e deleção de estudantes, respondendo com dados no formato JSON.

2. ViewController.java
Este controller é responsável pela interação entre a view (HTML + Thymeleaf) e os dados. Ele prepara os dados e os passa para as páginas HTML utilizando DTOs.

# Páginas Thymeleaf
- **listStudent.html**: **Lista** todos os estudantes com botão de **editar** e **deletar**.
- **formStudent.html**: criar, editar e visualiza dados do estudantes.

# Como Executar o Projeto
1. Clone o repositório.
2. Navegue até o diretório do projeto e execute o comando

 `git clone https://github.com/eduardoPonciano/thymeleaf-model.git`

3. Acesse a interface web no navegador em http://localhost:9080/.

# Observações
Este projeto armazena os dados em memória, e ao reiniciar a aplicação, os dados são perdidos. Isso foi feito para simplificar o exemplo, focando nos controllers e nas interações web.
