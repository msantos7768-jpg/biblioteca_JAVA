# 📚 Sistema de Biblioteca

Projeto desenvolvido em Java com o objetivo de praticar os principais conceitos de **Programação Orientada a Objetos (POO)** e construção de um sistema utilizando estruturas de dados e interação via terminal.

## 🚧 Status do projeto

**Versão 1.0 — Funcional**

O sistema possui as principais funcionalidades de uma biblioteca, porém ainda existem pontos que podem ser melhorados e refatorados.

Esta primeira versão foi desenvolvida com foco no aprendizado e na implementação da lógica do sistema.

Uma futura versão será criada com melhorias na organização, validações e estrutura do código.

---

## 🎯 Objetivo

Desenvolver um sistema simples de gerenciamento de biblioteca capaz de controlar:

- 📖 Livros
- 👤 Usuários
- 📋 Empréstimos
- 🔄 Devoluções

O projeto também tem como objetivo praticar conceitos fundamentais de Java e POO.

---

## ⚙️ Funcionalidades

Atualmente o sistema permite:

### 📖 Livros
- Cadastrar livros
- Listar livros
- Buscar livro por ID
- Controlar disponibilidade do livro

### 👤 Usuários
- Cadastrar usuários
- Listar usuários
- Buscar usuário por ID

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

---

## 🧱 Estrutura do projeto

O projeto utiliza algumas classes principais:

```text
biblioteca/
│
├── Main.java
├── Biblioteca.java
├── Livro.java
├── Usuario.java
└── Emprestimo.java
