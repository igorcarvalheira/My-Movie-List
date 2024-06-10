import java.util.ArrayList;

public class AgendaDeFilmes {
    private ArrayList<Filme> filmes;
    private ArrayList<Filme> watchlist;

    public AgendaDeFilmes() {
        filmes = new ArrayList<>();
        watchlist = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    public void adicionarFilmeWatchlist(Filme filme) {
        watchlist.add(filme);
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public ArrayList<Filme> getWatchlist() {
        return watchlist;
    }

    public void editarFilme(int index, String novoTitulo, int novaNota, boolean novoFavorito) {
        Filme filme = filmes.get(index);
        filme.setTitulo(novoTitulo);
        filme.setNota(novaNota);
        filme.setFavorito(novoFavorito);
    }

    public void excluirFilme(int index) {
        filmes.remove(index);
    }

    public void editarFilmeWatchlist(int index, String novoTitulo, int novaNota, boolean novoFavorito) {
        Filme filme = watchlist.get(index);
        filme.setTitulo(novoTitulo);
        filme.setNota(novaNota);
        filme.setFavorito(novoFavorito);
    }

    public void excluirFilmeWatchlist(int index) {
        watchlist.remove(index);
    }
}
