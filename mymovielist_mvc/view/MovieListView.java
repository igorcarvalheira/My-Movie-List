import java.util.Scanner;
import java.util.ArrayList;

public class MovieListView {
    private Scanner scanner;

    public MovieListView() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal() {
        System.out.println("1. Meus Filmes");
        System.out.println("2. Minha Watchlist");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public int mostrarMenuFilmes() {
        System.out.println("1. Mostrar Meus Filmes");
        System.out.println("2. Adicionar Novo Filme");
        System.out.println("3. Editar Lista");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public int mostrarMenuWatchlist() {
        System.out.println("1. Mostrar Watchlist");
        System.out.println("2. Adicionar Filme à Watchlist");
        System.out.println("3. Editar Watchlist");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public String pedirTitulo() {
        System.out.print("Título do filme: ");
        scanner.nextLine(); // Consome a nova linha
        return scanner.nextLine();
    }

    public int pedirNota() {
        System.out.print("Nota (0-5): ");
        return scanner.nextInt();
    }

    public boolean pedirFavorito() {
        System.out.print("Favorito (true/false): ");
        return scanner.nextBoolean();
    }

    public void mostrarFilmes(ArrayList<Filme> filmes) {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme adicionado.");
        } else {
            for (Filme filme : filmes) {
                System.out.println(filme);
            }
        }
    }

    public void mostrarWatchlist(ArrayList<Filme> watchlist) {
        if (watchlist.isEmpty()) {
            System.out.println("Nenhum filme na watchlist.");
        } else {
            for (Filme filme : watchlist) {
                System.out.println(filme.getTitulo());
            }
        }
    }

    public int pedirIndiceFilme(int tamanho) {
        System.out.print("Escolha o índice do filme (0 a " + (tamanho - 1) + "): ");
        return scanner.nextInt();
    }

    public int mostrarMenuEditarExcluir() {
        System.out.println("1. Editar Filme");
        System.out.println("2. Excluir Filme");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
