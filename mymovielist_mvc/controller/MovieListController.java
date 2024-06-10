import java.util.ArrayList;

public class MovieListController {
    private AgendaDeFilmes model;
    private MovieListView view;

    public MovieListController(AgendaDeFilmes model, MovieListView view) {
        this.model = model;
        this.view = view;
    }

    public void iniciar() {
        boolean executando = true;

        while (executando) {
            int opcao = view.mostrarMenuPrincipal();
            switch (opcao) {
                case 1:
                    gerenciarFilmes();
                    break;
                case 2:
                    gerenciarWatchlist();
                    break;
                case 3:
                    executando = false;
                    break;
                default:
                    view.exibirMensagem("Opção inválida. Tente novamente.");
            }
        }
    }

    private void gerenciarFilmes() {
        boolean executando = true;

        while (executando) {
            int opcao = view.mostrarMenuFilmes();
            switch (opcao) {
                case 1:
                    view.mostrarFilmes(model.getFilmes());
                    break;
                case 2:
                    adicionarNovoFilme();
                    break;
                case 3:
                    editarLista();
                    break;
                case 4:
                    executando = false;
                    break;
                default:
                    view.exibirMensagem("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarNovoFilme() {
        String titulo = view.pedirTitulo();
        int nota = view.pedirNota();
        boolean favorito = view.pedirFavorito();
        model.adicionarFilme(new Filme(titulo, nota, favorito));
        view.exibirMensagem("Filme adicionado com sucesso!");
    }

    private void editarLista() {
        ArrayList<Filme> filmes = model.getFilmes();
        if (filmes.isEmpty()) {
            view.exibirMensagem("Nenhum filme para editar.");
            return;
        }

        view.mostrarFilmes(filmes);
        int index = view.pedirIndiceFilme(filmes.size());
        if (index < 0 || index >= filmes.size()) {
            view.exibirMensagem("Índice inválido.");
            return;
        }

        int opcao = view.mostrarMenuEditarExcluir();
        switch (opcao) {
            case 1:
                String novoTitulo = view.pedirTitulo();
                int novaNota = view.pedirNota();
                boolean novoFavorito = view.pedirFavorito();
                model.editarFilme(index, novoTitulo, novaNota, novoFavorito);
                view.exibirMensagem("Filme editado com sucesso!");
                break;
            case 2:
                model.excluirFilme(index);
                view.exibirMensagem("Filme removido com sucesso!");
                break;
            default:
                view.exibirMensagem("Opção inválida. Tente novamente.");
        }
    }

    private void gerenciarWatchlist() {
        boolean executando = true;

        while (executando) {
            int opcao = view.mostrarMenuWatchlist();
            switch (opcao) {
                case 1:
                    view.mostrarWatchlist(model.getWatchlist());
                    break;
                case 2:
                    adicionarFilmeWatchlist();
                    break;
                case 3:
                    editarWatchlist();
                    break;
                case 4:
                    executando = false;
                    break;
                default:
                    view.exibirMensagem("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarFilmeWatchlist() {
        String titulo = view.pedirTitulo();
        model.adicionarFilmeWatchlist(new Filme(titulo, 0, false));
        view.exibirMensagem("Filme adicionado à watchlist com sucesso!");
    }

    private void editarWatchlist() {
        ArrayList<Filme> watchlist = model.getWatchlist();
        if (watchlist.isEmpty()) {
            view.exibirMensagem("Nenhum filme para editar.");
            return;
        }

        view.mostrarWatchlist(watchlist);
        int index = view.pedirIndiceFilme(watchlist.size());
        if (index < 0 || index >= watchlist.size()) {
            view.exibirMensagem("Índice inválido.");
            return;
        }

        int opcao = view.mostrarMenuEditarExcluir();
        switch (opcao) {
            case 1:
                String novoTitulo = view.pedirTitulo();
                int novaNota = view.pedirNota();
                boolean novoFavorito = view.pedirFavorito();
                model.editarFilmeWatchlist(index, novoTitulo, novaNota, novoFavorito);
                view.exibirMensagem("Filme da watchlist editado com sucesso!");
                break;
            case 2:
                model.excluirFilmeWatchlist(index);
                view.exibirMensagem("Filme da watchlist removido com sucesso!");
                break;
            default:
                view.exibirMensagem("Opção inválida. Tente novamente.");
        }
    }
}
