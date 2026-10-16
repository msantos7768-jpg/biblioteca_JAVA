package biblioteca;

import biblioteca.biblioteca.exception.LivroIndisponívelException;
import biblioteca.biblioteca.exception.LivroNaoEmprestadoException;
import biblioteca.controlleer.Biblioteca;
import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;

import java.util.Scanner;

public class Main {

    public static void painelUsuarios() {
        System.out.println("====SISTEAM DE BIBLIOTECA====");
        System.out.println("----Perfil de Usuário----");
        System.out.println("1 - Adm");
        System.out.println("2 - Estudante");
        System.out.println("0 - Sair");
    }

    public static void menuBibliotecario() {
        System.out.println("====SISTEMA DE BIBLIOTECA====");
        System.out.println("----Menu-----");
        System.out.println("\n1 - Cadastrar livro\n2 - Listar Livros\n3 - Cadastrar estudante\n4 - Listar usuários\n5 - Consultar todos empréstimos\n" +
                "6 - Consultar empréstimo por ID\n 0 - Retornar ao menu de usuários\"");
    }

    public static void menuEstudante() {
        System.out.println("====SISTEMA DE BIBLIOTECA====");
        System.out.println("----Menu----");
        System.out.println("\n1 - Consultar livros disponíveis\n2 - Realizar empréstimo\n3 - Devolver livro\n 0 - Retornar ao menu de usuários");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();//Criando o objeto Biblioteca

        painelUsuarios();
        System.out.println("Escolha seu perfil de usuário");
        int opUsuario = scanner.nextInt();

        while (opUsuario != 0) {
            if (opUsuario == 1) {
                menuBibliotecario();
                System.out.println("Escolha a opção desejada: ");
                int opBibliotecario = scanner.nextInt();
                while(opBibliotecario !=0) {
                    if (opBibliotecario == 1) {
                        System.out.println("\n====CADASTRO DE LIVROS====");
                        System.out.println("Digite o título do livro: ");
                        String titulo = scanner.nextLine();
                        String buffer = scanner.nextLine();
                        System.out.println("Digite o nome do autor: ");
                        String autor = scanner.nextLine();
                        biblioteca.cadastrarLivro(titulo, autor);
                    } else if (opBibliotecario == 2) {
                        System.out.println("\n====LISTAGEM DE LIVROS====");
                        biblioteca.listarLivros();
                    } else if (opBibliotecario == 3) {
                        System.out.println("\n====CADASTRO DE ESTUDANTE====");
                        System.out.println("Digite o nome do aluno: ");
                        String nome = scanner.nextLine();
                        String buffer = scanner.nextLine();
                        System.out.println("Digite seu e-mail: ");
                        String email = scanner.nextLine();
                        System.out.println("Digite o curso: ");
                        String curso = scanner.nextLine();
                        System.out.println("Digite o número de mátricula");
                        int matricula = scanner.nextInt();
                        biblioteca.cadastrarUsuario(nome, email, curso, matricula);
                    } else if (opBibliotecario == 4) {
                        System.out.println("====LISTAR ESTUDANTES CADASTRADOS====");
                        biblioteca.listarUsuarios();
                    } else if (opBibliotecario == 5) {
                        System.out.println("====CONSULTA DE TODOS OS EMPRÉSTIMOS====");
                        biblioteca.consultarEmprestimos();
                    } else if (opBibliotecario == 6) {
                        System.out.println("====CONSULTA DE EMPRÉSTIMOS POR USUÁRIO====");
                        System.out.println("Digite o ID do usuário: ");
                        int idUsuario = scanner.nextInt();
                        Usuario usuario = biblioteca.tentativasUsuario(idUsuario);
                        if (usuario != null) {
                            biblioteca.consultarEmprestimosPorIdUsuario(idUsuario);
                        }
                    }
                }
                painelUsuarios();
                System.out.println("Escolha seu perfil de usuário");
                opUsuario = scanner.nextInt();
            } else if (opUsuario == 2) {
                menuEstudante();
                System.out.println("Escolha a opção desejada: ");
                int opEstudante =  scanner.nextInt();
                while(opEstudante !=0) {
                    if (opEstudante == 1) {
                        System.out.println("====LIVROS DISPONÍVEIS====");
                        biblioteca.livrosDisponiveis();
                    } else if (opEstudante == 2) {
                        System.out.println("Digite o ID do usuário: ");
                        int idUsuario = scanner.nextInt();
                        Usuario usuario = biblioteca.tentativasUsuario(idUsuario);
                        System.out.println("Digite o ID do livro: ");
                        int idLivro = scanner.nextInt();
                        Livro livro = biblioteca.tentativasLivro(idLivro);
                        if (usuario != null && livro != null) {
                            // Verifica disponibilidade antes da confirmação
                            if (!livro.isDisponibilidade()) {
                                System.out.println("O livro está indisponível para empréstimo.");
                            } else {
                                // confirmação de empréstimo
                                System.out.println("\n===== CONFIRMAÇÃO =====");
                                System.out.println("Usuário: " + usuario.getNome());
                                System.out.println("Livro: " + livro.getTitulo());
                                System.out.println("Autor: " + livro.getAutor());
                                System.out.println("\nDeseja realizar o empréstimo?");
                                System.out.println("1 - Sim");
                                System.out.println("2 - Não");

                                int confirmacao = scanner.nextInt();

                                // em caso de confirmação
                                if (confirmacao == 1) {
                                    try { //aplicando a exceção da regra de negócio
                                        biblioteca.realizarEmprestimo(livro.getId(), usuario.getId());
                                    } catch (LivroIndisponívelException e) {
                                        System.out.println(e.getMessage());
                                    }
                                } else if (confirmacao == 2) {
                                    System.out.println("Empréstimo cancelado.");
                                } else {
                                    System.out.println("Opção inválida. Empréstimo cancelado.");
                                }
                            }
                        }

                    } else if (opEstudante == 3) {
                        System.out.println("\n====DEVOLUÇÃO====");

                        System.out.println("Digite o ID do usuário: "); //confirmando a existência do usuário
                        int idUsuario = scanner.nextInt();
                        Usuario usuario = biblioteca.tentativasUsuario(idUsuario);

                        System.out.println("Digite o ID do livro: "); //confirmando a existência do livro
                        int idLivro = scanner.nextInt();
                        Livro livro = biblioteca.tentativasLivro(idLivro);

                        if (usuario != null && livro != null) {

                            try {
                                Emprestimo emprestimo = biblioteca.buscarEmprestimoAtivoPorLivro(livro.getId());

                                System.out.println("\n====Confirmação====");
                                System.out.println("Usuário: " + usuario.getNome());
                                System.out.println("Livro: " + livro.getTitulo());
                                System.out.println("Deseja confirmar a devolução");
                                System.out.println("1 - Sim");
                                System.out.println("2 - Não");

                                int op = scanner.nextInt();

                                if (op == 1) {
                                    biblioteca.devolverLivro(usuario.getId(), livro.getId());
                                } else if (op == 2) {
                                    System.out.println("Processo de devolução encerrado");
                                } else {
                                    System.out.println("Opção inválida!");
                                }

                            } catch (LivroNaoEmprestadoException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
                painelUsuarios();
                System.out.println("Escolha seu perfil de usuário");
                opUsuario = scanner.nextInt();
            }
        }
    }
}