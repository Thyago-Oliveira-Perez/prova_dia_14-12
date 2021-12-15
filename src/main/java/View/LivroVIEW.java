package View;

import Controller.LivroController;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivroVIEW {

    LivroController livroController = new LivroController();
    Scanner entrada = new Scanner(System.in);
    Livro livro = new Livro();

    public void cadastrarGenero(Biblioteca biblioteca, Genero genero){

        String nome_livro;
        System.out.println("Digite o nome do genero:");
        nome_livro = entrada.next();
        livro.setNomeLivro(nome_livro);
        livro.setIdGenero(genero.getIdGenero());
        livro.setIdBilbioteca(biblioteca.getIdBiblioteca());
        livroController.cadastrarLivro(livro);
    }

    public void listarLivros(){
        List<Livro> retornoBanco = new ArrayList<>();
        retornoBanco = livroController.listarLivros();
        int size = livroController.listarLivros().size();
        for(int i = 0; i < size; i++){
            System.out.println(retornoBanco.get(i));
        }
    }

    public void listarLivrosByIdBiblioteca(int idBiblioteca){
        List<Livro> retornoBanco = new ArrayList<>();
        retornoBanco = livroController.listarLivrosByIdBiblioteca(idBiblioteca);
        int size = livroController.listarLivrosByIdBiblioteca(idBiblioteca).size();
        for(int i = 0; i < size; i++){
            System.out.println(retornoBanco.get(i));
        }
    }

}
