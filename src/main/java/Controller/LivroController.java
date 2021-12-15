package Controller;

import DAO.LivroDAO;
import Model.Livro;

import java.util.List;

public class LivroController {

    LivroDAO livroDAO = new LivroDAO();

    public void cadastrarLivro(Livro livro){
        livroDAO.cadastrarLivro(livro);
    }

    public List<Livro> listarLivros(){
        return livroDAO.listarLivros();
    }

    public List<Livro> listarLivrosByIdBiblioteca(int idBiblioteca){
        return livroDAO.listarLivrosByIdBiblioteca(idBiblioteca);
    }

}
