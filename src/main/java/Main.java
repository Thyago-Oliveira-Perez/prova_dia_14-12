import ConnectionFactory.ConnectionFactory;
import DAO.BibliotecaDAO;
import DAO.GeneroDAO;
import DAO.LivroDAO;
import Model.MenuView;

public class Main {

    public static void main(String[] args) {

//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.createDataBase();

        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        bibliotecaDAO.createBilbiotecaTable();
        GeneroDAO generoDAO = new GeneroDAO();
        generoDAO.createGeneroTable();
        LivroDAO livroDAO = new LivroDAO();
        livroDAO.createLivroTable();

        MenuView menuView = new MenuView();
        menuView.MainMenu();

    }

}
