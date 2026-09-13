package biblioteca;

public class LivroNaoEmprestadoException extends RuntimeException{
    public LivroNaoEmprestadoException (String mensagem){
        super(mensagem);
    }
}
