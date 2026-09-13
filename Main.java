package biblioteca;

import java.util.Scanner;

public class Main {

    public static void mostrarMenu(){
        System.out.println("====SISTEMA DE BIBLIOTECA====");
        System.out.println("----Menu----");
        System.out.println("1 - Cadastrar livro\n2 - Listar Livros\n3 - Cadastrar usuários\n4 - Listar usuários\n5 - Realizar empréstimos" +
                "\n6 - Devolver livro\n7 - Consultar empréstimos\n0 - Sair");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();//Criando o objeto Biblioteca

        mostrarMenu();
        System.out.println("Escolha a opção desejada: ");
        int escolha = scanner.nextInt();

        while(escolha !=0){

            if (escolha == 1) {
                System.out.println("\n====CADASTRO DE LIVROS====");
                System.out.println("Digite o título do livro: ");
                String titulo = scanner.nextLine();
                System.out.println("Digite o nome do autor: ");
                String autor = scanner.nextLine();
                biblioteca.cadastrarLivro(titulo, autor);
            }

            else if(escolha == 2){
                System.out.println("\n====LISTAGEM DE LIVROS====");
                biblioteca.listarLivros();
            }

            else if (escolha == 3) {
                System.out.println("\n====CADASTRO DE USUÁRIOS====");
                System.out.println("Digite o nome do usuário: ");
                String nome = scanner.nextLine();
                System.out.println("Digite seu e-mail: ");
                String email = scanner.nextLine();
                biblioteca.cadastrarUsuario(nome, email);
            }

            else if (escolha == 4) {
                System.out.println("\n====LISTAGEM DE USUÁRIOS====");
                biblioteca.listarUsuarios();
            }

            else if(escolha == 5){

                System.out.println("\n====EMPRÉSTIMO====");
                System.out.println("Digite o ID do usuário: ");

                Usuario usuario = biblioteca.tentativasUsuario(scanner);

                System.out.println("Digite o ID do Livro: ");

                Livro livro = biblioteca.tentativasLivro(scanner);

                if(usuario != null && livro !=null){
                    // Verifica disponibilidade antes da confirmação
                    if (!livro.isDisponibilidade()) {
                        System.out.println("O livro está indisponível para empréstimo.");
                }
                    else {
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
                            }catch (LivroIndisponívelException e){
                                System.out.println(e.getMessage());
                            }
                        }

                        else if (confirmacao == 2) {
                            System.out.println("Empréstimo cancelado.");
                        }

                        else {
                            System.out.println("Opção inválida. Empréstimo cancelado.");
                        }
                    }
                }
            }

            else if(escolha == 6) {

                System.out.println("\n====DEVOLUÇÃO====");

                System.out.println("Digite o ID do usuário: ");
                Usuario usuario = biblioteca.tentativasUsuario(scanner);

                System.out.println("Digite o ID do livro: ");
                Livro livro = biblioteca.tentativasLivro(scanner);

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
                            biblioteca.devolverLivro(livro.getId());
                        }
                        else if (op == 2) {
                            System.out.println("Processo de devolução encerrado");
                        }
                        else {
                            System.out.println("Opção inválida!");
                        }

                    } catch (LivroNaoEmprestadoException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            else if(escolha == 7){

                System.out.println("====LISTA DE EMPRÉSTIMOS====");
                biblioteca.consultarEmprestimos();
            }

            mostrarMenu();
            System.out.println("Escolha a opção desejada: ");
            escolha = scanner.nextInt();
        }

        scanner.close();//fechamento da classe scanner
    }
}