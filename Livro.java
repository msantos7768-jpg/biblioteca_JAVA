package biblioteca;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private boolean disponibilidade = true;

    public Livro(int id, String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
