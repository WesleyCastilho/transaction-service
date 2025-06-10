# 📌 Transaction Service

Serviço de transações financeiras desenvolvido com **Spring Boot**, **Java 17**, **PostgreSQL** e **Docker**, como parte de uma etapa técnica.

---

## ✅ Funcionalidades Implementadas

- 🔹 Criar conta: `POST /accounts`
- 🔹 Buscar conta por ID: `GET /accounts/{id}`
- 🔹 Registrar transação: `POST /transactions`
- 🔹 Cadastrar tipos de operação: `POST /operation-types`
- 🔹 Documentação interativa com Swagger: `/swagger-ui.html`

---

## ⚙️ Tecnologias e Ferramentas

- Java 17
- Spring Boot
- PostgreSQL 15
- Maven (via Docker)
- Docker & Docker Compose
- Swagger/OpenAPI 3
- Testes unitários com JUnit

---

## 🐳 Como Executar o Projeto com Docker

> ✅ Não é necessário ter Maven ou Java instalados localmente.

### Pré-requisitos

- Docker
- Docker Compose

### Passos para execução

1. Clone o repositório:
   git clone https://github.com/seu-usuario/transaction-service.git
   cd transaction-service

2. Dê permissão ao script e execute:

   chmod +x run.sh
   ./run.sh

> A aplicação estará disponível em: `http://localhost:8080`
> O Swagger pode ser acessado em: `http://localhost:8080/swagger-ui.html`

---

## 🧪 Executando os Testes


./mvnw test

> Os testes cobrem os principais fluxos: criação de contas, operações e transações.

---



---

## 🧾 data.sql – Tipos de Operação Padrão

O projeto carrega automaticamente os seguintes tipos de operação ao subir o banco:

```
INSERT INTO operation_type (id, description) VALUES (1, 'COMPRA A VISTA');
INSERT INTO operation_type (id, description) VALUES (2, 'COMPRA PARCELADA');
INSERT INTO operation_type (id, description) VALUES (3, 'SAQUE');
INSERT INTO operation_type (id, description) VALUES (4, 'PAGAMENTO');
```

---

## 🚀 Dockerfile

Build multi-stage otimizado:

* Etapa 1: Compila o JAR usando Maven
* Etapa 2: Executa somente com JDK



## 🌐 Swagger

A documentação da API pode ser acessada em:

```
http://localhost:8080/swagger-ui.html
```

Se estiver usando Springdoc 2.x, o caminho pode ser:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🧠 Observações Técnicas

* O `application.yml` está configurado para conectar ao banco `transactionsdb` usando o hostname `db`, como definido no Docker Compose.
* A flag `spring.sql.init.mode=always` garante a execução do `data.sql` ao iniciar.
* A porta da aplicação é exposta em `8080`.

---

## 👨‍💻 Autor

Wesley Castilho
[LinkedIn](https://www.linkedin.com/in/wesley-castilho/)
