package biblioteca.model;

public class estudante extends Usuario {
    private String curso;
    private int matricula;

    public estudante(int id, String nome, String email, String curso, int matricula) {
        super(id, nome, email);
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
