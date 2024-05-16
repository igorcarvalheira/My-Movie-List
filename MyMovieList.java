import java.util.ArrayList;
import java.util.Scanner;

public class MyMovieList {
    private static Scanner scanner = new Scanner(System.in);
    private static AgendaDeFilmes agenda = new AgendaDeFilmes();

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            System.out.println("1. Meus Filmes");
            System.out.println("2. Minha Watchlist");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha

            switch (opcao) {
                case 1:
                    menuMeusFilmes();
                    break;
                case 2:
                    menuWatchlist();
                    break;
                case 3:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void menuMeusFilmes() {
        boolean executando = true;

        while (executando) {
            System.out.println("1. Mostrar Meus Filmes");
            System.out.println("2. Adicionar Novo Filme");
            System.out.println("3. Editar Lista");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha

            switch (opcao) {
                case 1:
                    agenda.mostrarFilmes();
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
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarNovoFilme() {
        System.out.print("Título do filme: ");
        String titulo = scanner.nextLine();
        System.out.print("Nota (0-5): ");
        int nota = scanner.nextInt();
        System.out.print("Favorito (true/false): ");
        boolean favorito = scanner.nextBoolean();
        scanner.nextLine();  // Consome a nova linha
        agenda.adicionarFilme(titulo, nota, favorito);
        System.out.println("Filme adicionado com sucesso!");
    }

    private static void editarLista() {
        ArrayList<Filme> filmes = agenda.getFilmes();
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme para editar.");
            return;
        }

        for (int i = 0; i < filmes.size(); i++) {
            System.out.println(i + ". " + filmes.get(i).getTitulo());
        }

        System.out.print("Escolha o índice do filme para editar ou excluir: ");
        int index = scanner.nextInt();
        scanner.nextLine();  // Consome a nova linha

        if (index < 0 || index >= filmes.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        System.out.println("1. Editar Filme");
        System.out.println("2. Excluir Filme");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consome a nova linha

        switch (opcao) {
            case 1:
                System.out.print("Novo Título do filme: ");
                String novoTitulo = scanner.nextLine();
                System.out.print("Nova Nota (0-5): ");
                int novaNota = scanner.nextInt();
                System.out.print("Favorito (true/false): ");
                boolean novoFavorito = scanner.nextBoolean();
                scanner.nextLine();  // Consome a nova linha
                agenda.editarFilme(index, novoTitulo, novaNota, novoFavorito);
                break;
            case 2:
                agenda.excluirFilme(index);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void menuWatchlist() {
        boolean executando = true;

        while (executando) {
            System.out.println("1. Mostrar Watchlist");
            System.out.println("2. Adicionar Filme à Watchlist");
            System.out.println("3. Editar Watchlist");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha

            switch (opcao) {
                case 1:
                    agenda.mostrarWatchlist();
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
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarFilmeWatchlist() {
        System.out.print("Título do filme: ");
        String titulo = scanner.nextLine();
        agenda.adicionarFilmeWatchlist(titulo);
        System.out.println("Filme adicionado à watchlist com sucesso!");
    }

    private static void editarWatchlist() {
        ArrayList<Filme> watchlist = agenda.getWatchlist();
        if (watchlist.isEmpty()) {
            System.out.println("Nenhum filme para editar.");
            return;
        }

        for (int i = 0; i < watchlist.size(); i++) {
            System.out.println(i + ". " + watchlist.get(i).getTitulo());
        }

        System.out.print("Escolha o índice do filme para editar ou excluir: ");
        int index = scanner.nextInt();
        scanner.nextLine();  // Consome a nova linha

        if (index < 0 || index >= watchlist.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        System.out.println("1. Editar Filme");
        System.out.println("2. Excluir Filme");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consome a nova linha

        switch (opcao) {
            case 1:
                System.out.print("Novo Título do filme: ");
                String novoTitulo = scanner.nextLine();
                System.out.print("Nova Nota (0-5): ");
                int novaNota = scanner.nextInt();
                System.out.print("Favorito (true/false): ");
                boolean novoFavorito = scanner.nextBoolean();
                scanner.nextLine();  // Consome a nova linha
                agenda.editarFilmeWatchlist(index, novoTitulo, novaNota, novoFavorito);
                break;
            case 2:
                agenda.excluirFilmeWatchlist(index);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}