# API que faz um ciclo de vendas e pagamentos
API feita com Java e Spring Boot.

### Detalhes da API RESTful
* Projeto criado com Spring Boot e Java 8
* Banco de dados Mysql


### Como executar a aplicação
Certifique-se de ter o Maven instalado e adicionado ao PATH de seu sistema operacional, assim como o Git.
```
git clone git clone https://github.com/danilomolina/api-store.git
cd api-store
mvn spring-boot:run
Acesse os endpoints através da url http://localhost:8080/api/v1
```
### Importando o projeto no Eclipse ou STS 
No Eclipse/STS, importe o projeto como projeto Maven.

### MySql
 * O banco de dados Mysql deve estar instalado na maquina com usuario root e senha Isl_4_tybz
 * Deve ser criado um Schema com o nome de game-api

### Documentação dos EndPoints 
  * Para acessar a documentação dos endpoints, execute a aplicação e acesse pelo navegador o endereço:   http://localhost:8080/swagger-ui.html

### Não foi implementado por falta de tempo
* Autenticação e autorização com Spring Security e tokens JWT (JSON Web Token)
* Testes unitários e de integração com JUnit e Mockito
* Banco H2 para realizar os testes
* Caching com EhCache

