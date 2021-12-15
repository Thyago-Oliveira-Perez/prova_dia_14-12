package Model;

public class Livro {

    private int idLivro;
    private String nomeLivro;
    private int idGenero;
    private int idBilbioteca;

    public Livro() {
    }

    public Livro(int idLivro, String nomeLivro, int idGenero, int idBilbioteca) {
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.idGenero = idGenero;
        this.idBilbioteca = idBilbioteca;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdBilbioteca() {
        return idBilbioteca;
    }

    public void setIdBilbioteca(int idBilbioteca) {
        this.idBilbioteca = idBilbioteca;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "idLivro=" + idLivro +
                ", nomeLivro='" + nomeLivro + '\'' +
                ", idGenero=" + idGenero +
                ", idBilbioteca=" + idBilbioteca +
                '}';
    }
}
