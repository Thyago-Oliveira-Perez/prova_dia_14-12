package View;

import Controller.GeneroController;
import DAO.GeneroDAO;
import Model.Genero;

import java.util.List;
import java.util.Scanner;

public class GeneroView {

    GeneroController generoController = new GeneroController();
    Scanner entrada = new Scanner(System.in);
    Genero genero = new Genero();

    public void cadastrarGenero(){

        String nome_genero;
        System.out.println("Digite o nome do genero:");
        nome_genero = entrada.next();
        genero.setNomeGenero(nome_genero);
        generoController.cadastrarGenero(genero);
    }

    public void listarGeneros(){
        int size = generoController.listarGeneros().size();
        List<Genero> retornoBanco = generoController.listarGeneros();
        for(int i = 0; i < size; i++){
            System.out.println(retornoBanco.get(i));
        }
    }

    public void editarGenero(){
        String novo_nome;
        Genero genero1 = new Genero();
        System.out.println("Selecione o Genero:");
        listarGeneros();
        int idSelecionado = entrada.nextInt();
        genero1 = generoController.getById(idSelecionado);
        System.out.println("Digite o novo nome do Genero:");
        novo_nome = entrada.next();
        genero1.setNomeGenero(novo_nome);
        generoController.editarGenero(genero1);
    }
}
