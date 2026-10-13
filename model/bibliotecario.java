package biblioteca.model;

public class bibliotecario extends Usuario {
    private int registroFuncional;
    private int limiteEmprestimos;

    public bibliotecario(int id, String nome, String email) {
        super(id, nome, email);
    }

    public int getRegistroFuncional() {
        return registroFuncional;
    }

    public void setRegistroFuncional(int registroFuncional) {
        this.registroFuncional = registroFuncional;
    }

    public int getLimiteEmprestimos() {
        return limiteEmprestimos;
    }

    public void setLimiteEmprestimos(int limiteEmprestimos) {
        this.limiteEmprestimos = limiteEmprestimos;
    }
}
