# API de Gerenciamento de Pacientes

> Projeto finalizado em Outubro de 2025. Desenvolvido como um estudo aprofundado sobre a criação de APIs REST com o ecossistema Spring.

API RESTful completa para gerenciamento de pacientes (CRUD), incluindo funcionalidades de importação de dados via CSV e segurança baseada em tokens JWT com Keycloak.

---
## ✨ Features

- [x] CRUD completo de Pacientes (Criar, Listar, Atualizar, Remover).
- [x] Endpoint para importação de múltiplos pacientes via arquivo CSV.
- [x] Documentação da API interativa com Swagger (OpenAPI).
- [x] Segurança em todos os endpoints com autenticação e autorização via Keycloak (OAuth2/OIDC).
- [x] Testes de unidade para a camada de serviço com JUnit e Mockito.

---
## 🚀 Como Executar o Projeto

Certifique-se de ter o Java 17 (ou superior), Maven e o Docker Desktop instalados e rodando na sua máquina.

```bash
# 1. Clone o repositório
git clone [https://github.com/seu-usuario/pacientes-api-spring.git](https://github.com/seu-usuario/pacientes-api-spring.git)

# 2. Navegue até a pasta do projeto
cd pacientes-api-spring

# 3. Inicie os contêineres do banco de dados e do Keycloak
docker-compose up -d

# 4. Execute a aplicação Spring Boot
# Você pode fazer isso pela sua IDE (IntelliJ) ou via Maven no terminal:
mvn spring-boot:run
```

- A API estará disponível em `http://localhost:8080`.
- A documentação do Swagger estará em `http://localhost:8080/swagger-ui.html`.
- O console de administração do Keycloak estará em `http://localhost:8180` (admin/admin).

---
## 🔌 Endpoints da API

Todos os endpoints (exceto a documentação) são protegidos e exigem um token de acesso JWT válido obtido via Keycloak.

| Verbo HTTP | Endpoint | Descrição | Acesso |
| :--- | :--- | :--- | :--- |
| `GET` | `/pacientes` | Lista todos os pacientes cadastrados. | Protegido |
| `POST` | `/pacientes` | Cadastra um novo paciente. | Protegido |
| `PATCH` | `/pacientes/{id}` | Atualiza parcialmente um paciente existente. | Protegido |
| `DELETE` | `/pacientes/{id}` | Remove um paciente. | Protegido |
| `POST` | `/pacientes/importar` | Importa uma lista de pacientes de um arquivo CSV. | Protegido |

---
## 👨‍💻 Autor

**[João Marcelo Picazo]**

- Github: [jmpcz] (https://github.com/seu-usuario)
- LinkedIn: [joao-marcelo-picazo] (www.linkedin.com/in/joão-marcelo-picazo)

---
## 🛠️ Tecnologias Utilizadas

<div align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk" alt="Java 17">
  <img src="https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=spring" alt="Spring Boot">
  <img src="https://img.shields.io/badge/PostgreSQL-15-blue?style=for-the-badge&logo=postgresql" alt="PostgreSQL">
  <img src="https://img.shields.io/badge/Docker-blue?style=for-the-badge&logo=docker" alt="Docker">
  <img src="https://img.shields.io/badge/Keycloak-red?style=for-the-badge&logo=keycloak" alt="Keycloak">
  <img src="https://img.shields.io/badge/Maven-red?style=for-the-badge&logo=apachemaven" alt="Maven">
  <img src="https://img.shields.io/badge/JUnit5-green?style=for-the-badge&logo=junit5" alt="JUnit 5">
  <img src="https://img.shields.io/badge/Swagger-blue?style=for-the-badge&logo=swagger" alt="Swagger">
</div>

---