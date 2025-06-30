# :clapper: Sistema de Locação de Filmes (API REST)

## :books: Contexto

Uma antiga locadora da cidade decidiu informatizar o seu sistema de controle de filmes. Até então, todo o gerenciamento era feito manualmente, em planilhas e fichas de papel. O dono da locadora contratou você para desenvolver uma **API REST** utilizando **Java com Spring Boot**, que permita o cadastro e controle de filmes, clientes e locações.

---

## :dart: Objetivo

Desenvolver uma aplicação back-end que permita:

- Cadastrar filmes com seus dados básicos.
- Cadastrar clientes com informações de contato.
- Registrar locações de um ou mais filmes para um cliente.
- Atualizar o status de devolução das locações.
- Garantir que filmes não possam ser alugados se estiverem indisponíveis.

---

## :bricks: Requisitos Técnicos

### :white_check_mark: Tecnologias obrigatórias

- Java 17+
- Spring Boot (Web, JPA, H2 Database)
- Banco em memória (H2)
- Padrão REST
- Projeto organizado em camadas (Model, Repository, Service, Controller)

### :white_check_mark: Entidades mínimas

#### 🎞️ Filme
- ID
- Título
- Diretor
- Ano de lançamento
- Disponibilidade (`boolean`)

#### :bust_in_silhouette: Cliente
- ID
- Nome
- E-mail
- Telefone

#### :package: Locação
- ID
- Data da locação
- Data prevista para devolução
- Cliente associado
- Lista de filmes alugados
- Status de devolução (`boolean`)

### :white_check_mark: Regras de negócio

- Um cliente pode ter várias locações.
- Uma locação pode conter mais de um filme.
- Um filme só pode ser alugado se estiver disponível.
- Ao devolver os filmes, o sistema deve marcar a locação como devolvida e tornar os filmes disponíveis novamente.

---

## :globe_with_meridians: Endpoints esperados

### Filmes
- `POST /filmes` – Cadastrar filme
- `GET /filmes` – Listar todos os filmes
- `GET /filmes/{id}` – Buscar filme por ID
- `PUT /filmes/{id}` – Atualizar filme
- `DELETE /filmes/{id}` – Remover filme

### Clientes
- `POST /clientes` – Cadastrar cliente
- `GET /clientes` – Listar clientes
- `GET /clientes/{id}` – Buscar cliente por ID
- `PUT /clientes/{id}` – Atualizar cliente
- `DELETE /clientes/{id}` – Remover cliente

### Locações
- `POST /locacoes` – Registrar nova locação
- `GET /locacoes` – Listar locações
- `GET /locacoes/{id}` – Detalhar locação
- `PUT /locacoes/{id}/devolver` – Marcar como devolvida
