package biblioteca;

public class LivroIndisponívelException  extends RuntimeException{
    public LivroIndisponívelException(String mensagem){
        super(mensagem);
    }
}
