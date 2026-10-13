package biblioteca.biblioteca.exception;

public class LivroIndisponívelException  extends RuntimeException{
    public LivroIndisponívelException(String mensagem){
        super(mensagem);
    }
}
