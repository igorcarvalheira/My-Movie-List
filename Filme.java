public class Filme {
    private String titulo;
    private int nota;
    private boolean favorito;

    public Filme(String titulo, int nota, boolean favorito) {
        this.titulo = titulo;
        this.nota = nota;
        this.favorito = favorito;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    @Override
    public String toString() {
        return titulo + " (Nota: " + nota + " estrelas, Favorito: " + (favorito ? "Sim" : "Não") + ")";
    }
}
