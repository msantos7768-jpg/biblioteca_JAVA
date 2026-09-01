package biblioteca;
import java.util.ArrayList;
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
        String buffer = scanner.nextLine(); //Limpeza do buffer

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
            } else if (escolha == 3) {
                System.out.println("\n====CADASTRO DE USUÁRIOS====");
                System.out.println("Digite o nome do usuário: ");
                String nome = scanner.nextLine();
                System.out.println("Digite seu e-mail: ");
                String email = scanner.nextLine();
                biblioteca.cadastrarUsuario(nome, email);
            } else if (escolha == 4) {
                System.out.println("\n====LISTAGEM DE USUÁRIOS====");
                biblioteca.listarUsuarios();
            }
            else if(escolha == 5){

                System.out.println("\n====EMPRÉSTIMO====");
                int tentativas = 0;
                Usuario usuario = null;

                // Busca do usuário
                while (tentativas < 3 && usuario == null) {
                    System.out.println("Digite o ID do usuário: ");
                    int idUsuario = scanner.nextInt();
                    usuario = biblioteca.buscarUsuarioPorId(idUsuario);
                    if (usuario == null) {
                        tentativas++;

                        if (tentativas < 3) {
                            System.out.println("Usuário não encontrado. Tente novamente.");
                        }
                    }
                }
                if (usuario == null) {
                    System.out.println("Número máximo de tentativas atingido. Empréstimo cancelado.");
                } else {

                    tentativas = 0;
                    Livro livro = null;

                    // Busca do livro
                    while (tentativas < 3 && livro == null) {
                        System.out.println("Digite o ID do livro: ");
                        int idLivro = scanner.nextInt();
                        livro = biblioteca.buscarLivroPorId(idLivro);
                        if (livro == null) {
                            tentativas++;

                            if (tentativas < 3) {
                                System.out.println("Livro não encontrado. Tente novamente.");
                            }
                        }
                    }
                    //Número de tentativas ultrapassados
                    if (livro == null) {
                        System.out.println("Número máximo de tentativas atingido. Empréstimo cancelado.");
                    } else {
                        // Verifica disponibilidade antes da confirmação
                        if (!livro.isDisponibilidade()) {
                            System.out.println("O livro está indisponível para empréstimo.");
                        } else {
                            //confirmação de empréstimo
                            System.out.println("\n===== CONFIRMAÇÃO =====");
                            System.out.println("Usuário: " + usuario.getNome());
                            System.out.println("Livro: " + livro.getTitulo());
                            System.out.println("Autor: " + livro.getAutor());
                            System.out.println("\nDeseja realizar o empréstimo?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Não");
                            int confirmacao = scanner.nextInt();
                            //em caso de confirmação
                            if (confirmacao == 1) {
                                biblioteca.realizarEmprestimo(
                                        livro.getId(),
                                        usuario.getId()
                                );
                            } else if (confirmacao == 2) {
                                System.out.println("Empréstimo cancelado.");
                            } else {
                                System.out.println("Opção inválida. Empréstimo cancelado.");
                            }
                        }
                    }
                }
            }
            else if(escolha == 6){
                System.out.println("\n====DEVOLUÇÃO====");

                int tentativas = 0;
                Usuario usuario = null;
                while (tentativas <3 && usuario == null){
                    System.out.println("Digite o ID do usuário: ");
                    int idUsuario = scanner.nextInt();
                    usuario = biblioteca.buscarUsuarioPorId(idUsuario);
                    if (usuario == null){
                        tentativas++;

                        if(tentativas < 3){
                            System.out.println("Usuário não encontrado, tente novamente!");
                        }
                    }
                }
                if(usuario == null){
                    System.out.println("Número máximo de tentativas excedido.");
                }
                else{
                    tentativas = 0;
                    Livro livro = null;
                    while (tentativas < 3 && livro == null){
                        System.out.println("Digite o ID do livro: ");
                        int idLivro = scanner.nextInt();
                        livro = biblioteca.buscarLivroPorId(idLivro);
                        if(livro == null){
                            tentativas++;
                            if (tentativas <3){
                                System.out.println("Livro não identificado, tente novamente!");
                            }
                        }
                    }
                    if(livro == null){
                        System.out.println("Número de tentativas excedido, devolução cancelada...");
                    }
                    else {
                        System.out.println("\n====Confirmação====");
                        System.out.println("Usuário: " + usuario.getNome());
                        System.out.println("Livro: " + livro.getTitulo());
                        System.out.println("Deseja confirmar a devolução");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Não");
                        int op = scanner.nextInt();
                        if (op == 1){
                            biblioteca.devolverLivro(livro.getId());
                        }
                        else if (op == 2){
                            System.out.println("Processo de devolução encerrado");
                        }
                        else{
                            System.out.println("Opção inválida!");
                        }
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
