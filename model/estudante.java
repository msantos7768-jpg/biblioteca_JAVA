package biblioteca.model;

import java.math.BigInteger;

public class estudante extends Usuario {
    private String curso;
    private BigInteger matricula;

    public estudante(int id, String nome, String email, String curso, BigInteger matricula) {
        super(id, nome, email);
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public BigInteger getMatricula() {
        return matricula;
    }

    public void setMatricula(BigInteger matricula) {
        this.matricula = matricula;
    }
}
