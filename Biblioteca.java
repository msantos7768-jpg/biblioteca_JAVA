package biblioteca;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

///
public class Biblioteca {

    private ArrayList<Livro>livros;
    private ArrayList<Usuario>usuarios;
    private ArrayList<Emprestimo>emprestimos;
    private int proximoIdLivro = 1;
    private int proximoIdUsuario = 1;

    public Biblioteca() {
        this.livros = new ArrayList<Livro>();
        this.usuarios = new ArrayList<Usuario>();
        this.emprestimos = new ArrayList<Emprestimo>();
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void cadastrarLivro(String titulo, String autor){
        Livro livro = new Livro(proximoIdLivro, titulo, autor);
        livros.add(livro);

        proximoIdLivro ++;
    }

    public void listarLivros(){ //implementar a listagem de livros
        for (int i = 0; i < livros.size(); i++){
            System.out.println("ID: " + livros.get(i).getId() + "\nLivro: " + livros.get(i).getTitulo() +
                    "\nAutor: " + livros.get(i).getAutor() + "\n----------\n");
        }
    }

    public void cadastrarUsuario(String nome, String email){
        Usuario usuario = null;
           for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getEmail().equals(email)) {
                    System.out.println("E-mail já existente");
                }
            }
        usuario = new Usuario(proximoIdUsuario, nome, email);
        usuarios.add(usuario);

        proximoIdUsuario++;
    }

    public void listarUsuarios(){
        for (int i = 0; i < usuarios.size(); i++){
            System.out.println("ID do usuário: " + usuarios.get(i).getId() + "\nNome: " + usuarios.get(i).getNome()
                    + "\nE-mail: " + usuarios.get(i).getEmail() + "\n----------\n");
        }
    }

    public Livro buscarLivroPorId(int Id){
        for (int i = 0; i < livros.size(); i++){
            if (Id == livros.get(i).getId()){
                System.out.println("Livro encontrado!");
                return livros.get(i);
            }
        }
        return null;

    }

    public Usuario buscarUsuarioPorId(int Id){
        for (int i = 0; i <usuarios.size(); i++){
            if (Id == usuarios.get(i).getId()){
                System.out.println("Usuário encontrado!");
                return usuarios.get(i);
            }
        }
        return null;
    }


    public void realizarEmprestimo(int idLivro, int idUsuario){
       Livro l = buscarLivroPorId(idLivro);
        Usuario us = buscarUsuarioPorId(idUsuario);
        if (l == null){
        }
        else if (us == null){
        }
        else if (l.isDisponibilidade()) {
            System.out.println("Realizando empréstimo...");
            LocalDate data = LocalDate.now();
            Emprestimo emprestimo = new Emprestimo(l,us, data);
            emprestimos.add(emprestimo);
            l.setDisponibilidade(false);
            System.out.println("Empréstimo realizado!");

        }
        else{
            throw new LivroIndisponívelException("Livro indisponível para empréstimo!");
        }
    }

    public void devolverLivro(int idLivro) {
        Livro livro = buscarLivroPorId(idLivro);
        if (livro == null) {
            System.out.println("Opção inválida, livro não identificado");
        } else {
            for (int i = 0; i < emprestimos.size(); i++) {
                Emprestimo emprestimoPosition = emprestimos.get(i); //acessando a posição do empréstimo
                if (livro == emprestimoPosition.getLivro()) { //acessando o livro dentro da posição da lista
                    if (emprestimoPosition.isAtivo()) {
                        System.out.println("Empréstimo encontrado!");
                        livro.setDisponibilidade(true);
                        emprestimoPosition.setAtivo(false);
                        System.out.println("Devolução realizada");
                        break;
                    }
                }
            }
        }
    }
    public void consultarEmprestimos(){

        for (int i = 0; i <emprestimos.size(); i++){
            Emprestimo emprestimo = emprestimos.get(i);
            String status;
            if (emprestimo.isAtivo()){
                status = "Ativo";
            } else {
                status = "Devolvido";
            }

            System.out.println("Usuário: "+ emprestimo.getUsuario().getNome() + "\nID do Usuário: " + emprestimo.getUsuario().getId()
                    + "\nData do empréstimo: " + emprestimo.getDataEmprestimo() + "\nLivro: " + emprestimo.getLivro().getTitulo()
                    + "\nStatus de empréstimo: " + status + "\n");
        }
    }

    public Emprestimo buscarEmprestimoAtivoPorLivro(int idLivro) {
        for (int i = 0; i < emprestimos.size(); i++) {

            Emprestimo emprestimo = emprestimos.get(i);

            if (emprestimo.getLivro().getId() == idLivro
                    && emprestimo.isAtivo()) {

                return emprestimo;
            }
        }

        throw new LivroNaoEmprestadoException(
                "O livro não está em empréstimo"
        );
    }
    public Usuario tentativasUsuario(Scanner scanner){
        int tentativas = 0;
        Usuario usuario = null;

        while (tentativas < 3 && usuario == null){
            int idUsuario = scanner.nextInt();
            usuario = buscarUsuarioPorId(idUsuario);
            if(usuario == null){
                tentativas++;

                if(tentativas < 3){
                    System.out.println("Usuário não encontrado. Tente novamente");
                }
            }
        }
        if(usuario == null){
            System.out.println("Número de tentativas atingido. Tente novamente!");
        }

        return  usuario;
    }

    public Livro tentativasLivro(Scanner scanner){
        int tentativas = 0;
        Livro livro = null;

        while (tentativas < 3 && livro == null){
            int idLivro = scanner.nextInt();
            livro = buscarLivroPorId(idLivro);
            if(livro == null){
                tentativas++;

                if(tentativas <3){
                    System.out.println("Livro não encontrado. Tente novamente.");
                }
            }
        }
        if (livro == null){
            System.out.println("Número de tentativas atingido. Tente novamente!");
        }

        return livro;
    }


}
