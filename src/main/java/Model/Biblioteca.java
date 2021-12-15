package Model;

public class Biblioteca {

    private int idBiblioteca;
    private String nomeBiblioteca;

    public Biblioteca() {
    }

    public Biblioteca(int idBiblioteca, String nomeBiblioteca) {
        this.idBiblioteca = idBiblioteca;
        this.nomeBiblioteca = nomeBiblioteca;
    }

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }

    public void setNomeBiblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "idBiblioteca=" + idBiblioteca +
                ", nomeBiblioteca='" + nomeBiblioteca + '\'' +
                '}';
    }
}
