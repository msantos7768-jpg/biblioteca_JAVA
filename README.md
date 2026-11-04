# 📚 Sistema de Biblioteca

Projeto desenvolvido em Java com o objetivo de praticar conceitos de **Programação Orientada a Objetos (POO)**, estruturas de dados, persistência de dados e integração com banco de dados.

O sistema simula o gerenciamento de uma biblioteca, permitindo controlar livros, usuários, empréstimos e devoluções.

## 🚧 Status do projeto

**Versão 2.0 — Em desenvolvimento**

A primeira versão do sistema foi desenvolvida utilizando estruturas de dados em memória (`ArrayList`), com as principais funcionalidades de gerenciamento de uma biblioteca.

Atualmente, o projeto está passando por uma evolução estrutural, com a implementação de persistência de dados utilizando **MySQL e JDBC**.

Nesta etapa, foram iniciados:

- Configuração da conexão entre Java e MySQL.
- Implementação da classe de conexão com o banco de dados.
- Criação da camada DAO (*Data Access Object*).
- Implementação inicial do DAO de usuários.
- Externalização das credenciais do banco de dados, evitando sua exposição no código-fonte.

A migração das demais funcionalidades para o banco de dados será realizada gradualmente.

---

## 🎯 Objetivo

Desenvolver um sistema de gerenciamento de biblioteca capaz de controlar:

- 📖 Livros
- 👤 Usuários
- 📋 Empréstimos
- 🔄 Devoluções

O projeto também busca aprofundar conhecimentos em Java, POO, organização em camadas, JDBC e bancos de dados relacionais.

---

## ⚙️ Funcionalidades

### 📖 Livros

- Cadastrar livros
- Listar livros
- Buscar livro por ID
- Controlar disponibilidade do livro

### 👤 Usuários

- Cadastrar usuários
- Listar usuários
- Buscar usuário por ID
- Utilizar matrícula como identificador único

### 📋 Empréstimos

- Realizar empréstimos
- Verificar disponibilidade do livro
- Associar um livro a um usuário
- Registrar a data do empréstimo
- Consultar empréstimos

### 🔄 Devoluções

- Devolver livros
- Alterar a disponibilidade do livro
- Alterar o status do empréstimo

> **Observação:** essas funcionalidades foram implementadas inicialmente na versão 1.0. A adaptação completa para persistência no MySQL ainda está em desenvolvimento.

---

## 🛠️ Tecnologias utilizadas

- **Java** — linguagem principal.
- **MySQL** — sistema gerenciador de banco de dados.
- **JDBC** — comunicação entre Java e MySQL.
- **Git e GitHub** — versionamento e gerenciamento do projeto.

---

## 🧱 Estrutura do projeto

```text
biblioteca/
│
├── Main.java
│
├── DAO/
│   └── usuarioDAO.java
│
├── connection/
│   └── conexaoBD.java
│
├── controlleer/
│   └── Biblioteca.java
│
├── model/
│   ├── Livro.java
│   ├── Usuario.java
│   ├── Emprestimo.java
│   └── estudante.java
│
├── biblioteca/
│   └── exception/
│
├── .env.example
├── .gitignore
└── README.md
```

### 📂 Organização das classes

- **Main:** ponto de entrada e interação com o usuário pelo terminal.
- **DAO:** responsável pelas operações de acesso e manipulação dos dados no banco.
- **connection:** responsável pelo estabelecimento da conexão com o MySQL.
- **controlleer:** concentra a lógica de gerenciamento da biblioteca.
- **model:** contém as classes que representam as entidades do sistema.
- **biblioteca/exception:** contém as exceções personalizadas do projeto.

---

## 🗄️ Banco de dados

O projeto utiliza MySQL para iniciar a migração da persistência de dados.

A comunicação com o banco é realizada por meio de JDBC, utilizando `PreparedStatement` para executar comandos SQL parametrizados.

As credenciais de acesso são obtidas por meio de variáveis de ambiente:

- `DB_URL`
- `DB_USER`
- `DB_PASSWORD`

As credenciais não devem ser armazenadas diretamente no código-fonte nem enviadas ao repositório.

### Configuração local

Configure as variáveis de ambiente no terminal antes de executar a aplicação.

Exemplo utilizando Git Bash:

```bash
export DB_URL="jdbc:mysql://localhost:3306/bibliotecajava"
export DB_USER="seu_usuario"
export DB_PASSWORD="sua_senha"
```

O arquivo `.env.example` disponibiliza um modelo das configurações necessárias.

O arquivo `.env`, utilizado para armazenar configurações locais, é ignorado pelo Git. O Java utiliza `System.getenv()` para acessar as variáveis de ambiente.

---

## 📌 Próximas etapas

- [x] Implementar a conexão entre Java e MySQL.
- [x] Criar a estrutura inicial da camada DAO.
- [x] Implementar o cadastro de usuários no DAO.
- [x] Externalizar as credenciais do banco de dados.
- [ ] Implementar as operações de consulta de usuários.
- [ ] Criar os DAOs de livros e empréstimos.
- [ ] Adaptar as operações de empréstimo e devolução para o MySQL.
- [ ] Integrar completamente a aplicação ao banco de dados.
- [ ] Realizar testes e refatorações.

---

## 📚 Objetivo de aprendizado

Este projeto faz parte da minha jornada de aprendizado em desenvolvimento Java.

Cada evolução representa a aplicação prática de novos conceitos, buscando melhorar não apenas o funcionamento do sistema, mas também sua organização, manutenção e estrutura.