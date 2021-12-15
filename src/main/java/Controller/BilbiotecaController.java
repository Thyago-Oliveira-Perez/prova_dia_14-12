package Controller;

import DAO.BibliotecaDAO;
import Model.Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BilbiotecaController {
    BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
    public void cadastroBiblioteca(Biblioteca biblioteca){
        bibliotecaDAO.cadastroBiblioteca(biblioteca);
    }
    public List<Biblioteca> listarBibliotecas(){
        return bibliotecaDAO.listarBibliotecas();
    }
    public Biblioteca selectById(int idSelecionado){
        return bibliotecaDAO.selectById(idSelecionado);
    }
}
