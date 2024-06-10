public class Main {
    public static void main(String[] args) {
        AgendaDeFilmes model = new AgendaDeFilmes();
        MovieListView view = new MovieListView();
        MovieListController controller = new MovieListController(model, view);
        controller.iniciar();
    }
}
