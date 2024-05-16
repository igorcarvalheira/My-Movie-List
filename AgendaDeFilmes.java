import java.util.ArrayList;

public class AgendaDeFilmes {
    private ArrayList<Filme> filmes;
    private ArrayList<Filme> watchlist;

    public AgendaDeFilmes() {
        filmes = new ArrayList<>();
        watchlist = new ArrayList<>();
    }

    public void adicionarFilme(String titulo, int nota, boolean favorito) {
        filmes.add(new Filme(titulo, nota, favorito));
    }

    public void adicionarFilmeWatchlist(String titulo) {
        watchlist.add(new Filme(titulo, 0, false));
    }

    public void mostrarFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme adicionado.");
        } else {
            for (Filme filme : filmes) {
                System.out.println(filme);
            }
        }
    }

    public void mostrarWatchlist() {
        if (watchlist.isEmpty()) {
            System.out.println("Nenhum filme na watchlist.");
        } else {
            for (Filme filme : watchlist) {
                System.out.println(filme.getTitulo());
            }
        }
    }

    public void editarFilme(int index, String novoTitulo, int novaNota, boolean novoFavorito) {
        Filme filme = filmes.get(index);
        filme.setNota(novaNota);
        filme.setFavorito(novoFavorito);
        System.out.println("Filme editado com sucesso!");
    }

    public void excluirFilme(int index) {
        filmes.remove(index);
        System.out.println("Filme removido com sucesso!");
    }

    public void editarFilmeWatchlist(int index, String novoTitulo, int novaNota, boolean novoFavorito) {
        Filme filme = watchlist.get(index);
        filme.setNota(novaNota);
        filme.setFavorito(novoFavorito);
        filme.setTitulo(novoTitulo);
        System.out.println("Filme da watchlist editado com sucesso!");
    }

    public void excluirFilmeWatchlist(int index) {
        watchlist.remove(index);
        System.out.println("Filme da watchlist removido com sucesso!");
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public ArrayList<Filme> getWatchlist() {
        return watchlist;
    }
}
