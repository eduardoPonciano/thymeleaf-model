# Projeto Modelo: MVC Spring Boot e Thymeleaf
Este é um projeto de exemplo que demonstra como criar um CRUD (Create, Read, Update, Delete) utilizando Spring Boot e Thymeleaf em um padrão MVC. O foco está na implementação da parte web e nos controllers, com dados armazenados em memória, ou seja, sem persistência em banco de dados. O projeto utiliza serviços RESTful para manipulação dos dados e divide os controllers em dois tipos: um para gerenciar as operações de CRUD do objeto Estudante e outro para preparar os dados entre HTML e DTOs.

# Tecnologias Utilizadas
- Java 17
- Spring Boot 3.x
- Thymeleaf
- Spring Web
- Spring MVC
- Lombok
- Dados armazenados em memória
# Arquitetura MVC
![Descrição da imagem](https://github.com/eduardoPonciano/thymeleaf-model/blob/main/docs/img/arch.png)

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
A camada intermediária que recebe as requisições, processa a lógica e determina a resposta. No projeto, temos dois controllers com responsabilidades distintas:

**1. StudentController**
Responsável por realizar as operações de CRUD (Create, Read, Update, Delete) da entidade Estudante. Ele não lida diretamente com a visualização ou interface de usuário. Ao invés disso, ele expõe funcionalidades para criar, atualizar, buscar e deletar estudantes, utilizando o Service. Este controller processa requisições relacionadas ao objeto de domínio Estudante.

**2. StudentViewController**
Responsável por preparar e fornecer os dados para serem exibidos nas páginas HTML via Thymeleaf. Ele não realiza operações CRUD diretamente. Em vez disso, busca os dados necessários (como listas de estudantes ou atributos de formulários) e os prepara para que o HTML possa renderizar corretamente a interface do usuário. Este controller também recebe dados de formulários preenchidos pelo usuário e os envia para o StudentController para serem processados (por exemplo, enviar um estudante preenchido para ser salvo).

# Páginas Thymeleaf
- **listStudent.html**: **Lista** todos os estudantes com botão de **editar** e **deletar**.
- **formStudent.html**: criar, editar e visualiza dados do estudantes.

# Como Executar o Projeto
1. Clone o repositório.
   
 `git clone https://github.com/eduardoPonciano/thymeleaf-model.git`

2. Navegue até o diretório do projeto e execute o comando

`java -jar target/thymeleaf-model.jar`

3. Acesse a interface web no navegador em http://localhost:9080/.

# Observações
Este projeto armazena os dados em memória, e ao reiniciar a aplicação, os dados são perdidos. Isso foi feito para simplificar o exemplo, focando nos controllers e nas interações web.
