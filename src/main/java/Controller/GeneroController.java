package Controller;

import DAO.GeneroDAO;
import Model.Genero;
import View.GeneroView;

import java.util.List;

public class GeneroController {

    GeneroDAO generoDAO = new GeneroDAO();

    public void cadastrarGenero(Genero genero){
        generoDAO.cadastrarGenero(genero);
    }

    public void editarGenero(Genero genero){
        generoDAO.editarGenero(genero);
    }

    public List<Genero> listarGeneros(){
        return generoDAO.listarGeneros();
    }

    public Genero getById(int idSelecionado){
        return generoDAO.getById(idSelecionado);
    }

}
