# 🥷 Cadastro de Ninjas — API REST

> Projeto de estudo e portfólio desenvolvido com **Spring Boot 3**, demonstrando na prática a construção de uma API REST completa com CRUD, padrão DTO + Mapper, interface web com Thymeleaf e documentação interativa com Swagger.

<p align="left">
  <img src="https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java" />
  <img src="https://img.shields.io/badge/Spring%20Boot-3.4.5-brightgreen?style=flat-square&logo=springboot" />
  <img src="https://img.shields.io/badge/H2-Database-blue?style=flat-square" />
  <img src="https://img.shields.io/badge/Flyway-Migration-red?style=flat-square" />
  <img src="https://img.shields.io/badge/Swagger-OpenAPI%203-85EA2D?style=flat-square&logo=swagger" />
  <img src="https://img.shields.io/badge/Lombok-enabled-pink?style=flat-square" />
  <img src="https://img.shields.io/badge/status-em%20desenvolvimento-yellow?style=flat-square" />
</p>

---

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Tecnologias](#-tecnologias)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Pré-requisitos](#-pré-requisitos)
- [Como Instalar e Rodar](#-como-instalar-e-rodar)
- [Endpoints da API](#-endpoints-da-api)
- [Interface Web](#-interface-web)
- [Banco de Dados](#-banco-de-dados)
- [Documentação Swagger](#-documentação-swagger)
- [Autor](#-autor)

---

## 📖 Sobre o Projeto

O **Cadastro de Ninjas** é uma API REST desenvolvida para fins de estudo e composição de portfólio. O projeto aborda os principais conceitos do ecossistema Spring Boot, incluindo:

- Construção de API REST com Spring Web
- Padrão **DTO (Data Transfer Object)** com Mapper manual
- Persistência de dados com **Spring Data JPA + Hibernate**
- Versionamento de banco de dados com **Flyway**
- Interface web com **Thymeleaf**
- Documentação interativa com **SpringDoc OpenAPI (Swagger)**
- Banco de dados em arquivo com **H2**

O sistema permite gerenciar **Ninjas** e **Missões**, com relacionamento entre as entidades (muitos ninjas para uma missão).

---

## 🛠 Tecnologias

| Tecnologia | Versão | Descrição |
|---|---|---|
| Java | 17 | Linguagem principal |
| Spring Boot | 3.4.5 | Framework principal |
| Spring Web | — | Construção da API REST |
| Spring Data JPA | — | Persistência e repositórios |
| Hibernate | 6.x | ORM |
| H2 Database | — | Banco de dados em arquivo |
| Flyway | — | Migrations do banco de dados |
| Thymeleaf | — | Interface web (templates HTML) |
| Lombok | — | Redução de boilerplate |
| SpringDoc OpenAPI | 2.8.9 | Documentação Swagger |
| Maven | — | Gerenciador de dependências |

---

## 📁 Estrutura do Projeto

```
src/main/java/dev/jv/CadastroDeNinjas/
│
├── Ninjas/
│   ├── Controller/
│   │   ├── NinjaController.java        # API REST de ninjas
│   │   └── NinjaControllerUI.java      # Controller para interface web
│   ├── Service/
│   │   └── NinjaService.java
│   ├── NinjaModel.java                 # Entidade JPA
│   ├── NinjaDTO.java                   # DTO de transferência
│   ├── NinjaMapper.java                # Mapper DTO <-> Model
│   └── NinjaRepository.java
│
├── Missoes/
│   ├── Controller/
│   │   └── MissaoController.java       # API REST de missões
│   ├── Service/
│   │   └── MissaoService.java
│   ├── MissaoModel.java
│   ├── MissaoDTO.java
│   ├── MissaoMapper.java
│   └── MissaoRepository.java
│
└── CadastroDeNinjasApplication.java

src/main/resources/
├── templates/
│   ├── ListarNinjas.html               # Listagem de ninjas
│   └── DetalhesNinja.html              # Detalhes do ninja
├── db/migration/
│   ├── V1__create_tables.sql           # Criação das tabelas
│   └── V2__...sql                      # Migration adicional
└── application.properties
```

---

## ✅ Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

- [Java 17+](https://adoptium.net/)
- [Maven 3.8+](https://maven.apache.org/download.cgi) *(ou usar o Maven Wrapper incluído no projeto)*
- Uma IDE como [IntelliJ IDEA](https://www.jetbrains.com/idea/) ou [VS Code](https://code.visualstudio.com/)

---

## 🚀 Como Instalar e Rodar

### 1. Clone o repositório

```bash
git clone https://github.com/vitorfxp/API-Cadastro.git
cd API-Cadastro
```

### 2. Configure o `application.properties`

O arquivo já vem configurado para H2 com persistência em arquivo. Verifique se está assim em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:h2:file:./data/CadastroDeNinjasDb;AUTO_SERVER=TRUE
spring.datasource.username=cadastro_bd
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

### 3. Rode o projeto

**Via Maven:**
```bash
./mvnw spring-boot:run
```

**Via IntelliJ:**
Abra o projeto e execute a classe `CadastroDeNinjasApplication.java` clicando no botão ▶️.

### 4. Acesse a aplicação

| Recurso | URL |
|---|---|
| API REST | `http://localhost:8080` |
| Interface Web | `http://localhost:8080/ninja/ui/listar` |
| Swagger UI | `http://localhost:8080/swagger-ui/index.html` |
| H2 Console | `http://localhost:8080/h2-console` |

---

## 📡 Endpoints da API

### 🥷 Ninjas — `/ninja`

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/ninja/listar` | Lista todos os ninjas |
| `GET` | `/ninja/listar/{id}` | Busca um ninja por ID |
| `POST` | `/ninja/adicionar` | Cria um novo ninja |
| `PUT` | `/ninja/atualizar/{id}` | Atualiza um ninja existente |
| `DELETE` | `/ninja/deletar/{id}` | Remove um ninja |

#### Exemplo de body para criar/atualizar ninja:
```json
{
  "nome": "Naruto Uzumaki",
  "email": "naruto@konoha.com",
  "idade": 17,
  "nivel": "GENIN",
  "aldeia": "Konoha",
  "habilidadeEspecial": "Rasengan",
  "missoes": {
    "id": 1
  }
}
```

---

### ⚔️ Missões — `/missao`

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/missao/listar` | Lista todas as missões |
| `GET` | `/missao/listar/{id}` | Busca uma missão por ID |
| `POST` | `/missao/criar` | Cria uma nova missão |
| `PUT` | `/missao/atualizar/{id}` | Atualiza uma missão existente |
| `DELETE` | `/missao/deletar/{id}` | Remove uma missão |

#### Exemplo de body para criar/atualizar missão:
```json
{
  "nome": "Missão B",
  "descricao": "Escoltar o daimyo até a capital",
  "rank": "B"
}
```

---

## 🌐 Interface Web

O projeto conta com uma interface web construída com Thymeleaf, acessível pelo navegador:

| Página | URL |
|---|---|
| Lista de Ninjas | `/ninja/ui/listar` |
| Detalhes do Ninja | `/ninja/ui/listar/{id}` |
| Deletar Ninja | `/ninja/ui/deletar/{id}` |

---

## 🗄 Banco de Dados

O projeto utiliza **H2** com persistência em arquivo (os dados são mantidos entre reinicializações).

O banco é versionado com **Flyway**, que executa as migrations automaticamente ao iniciar a aplicação.

Para acessar o console do H2:
1. Acesse `http://localhost:8080/h2-console`
2. Use a URL: `jdbc:h2:file:./data/CadastroDeNinjasDb`
3. Usuário: `cadastro_bd`
4. Senha: *(deixe em branco)*

### Modelo de dados

```
tb_missoes
├── id (PK)
├── nome
├── descricao
└── rank

tb_cadastro
├── id (PK)
├── nome
├── email (unique)
├── idade
├── nivel
├── aldeia
├── habilidade_especial
└── missoes_id (FK → tb_missoes)
```

---

## 📚 Documentação Swagger

A documentação interativa da API está disponível via **SpringDoc OpenAPI 2.x**:

```
http://localhost:8080/swagger-ui/index.html
```

Pelo Swagger UI é possível visualizar todos os endpoints, seus parâmetros, exemplos de request/response e testar as rotas diretamente pelo navegador.

---

## 👤 Autor

Feito com 💙 por **vitorfxp**

[![GitHub](https://img.shields.io/badge/GitHub-vitorfxp-181717?style=flat-square&logo=github)](https://github.com/vitorfxp)
[![Repositório](https://img.shields.io/badge/Repositório-API--Cadastro-blue?style=flat-square&logo=github)](https://github.com/vitorfxp/API-Cadastro)

---

> *Projeto desenvolvido para fins de estudo e portfólio. Feedbacks são bem-vindos!* 🚀
