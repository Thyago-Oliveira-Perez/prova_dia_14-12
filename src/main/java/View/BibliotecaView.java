package View;

import Controller.BilbiotecaController;
import Model.Biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaView {

    Biblioteca biblioteca = new Biblioteca();
    BilbiotecaController bilbiotecaController = new BilbiotecaController();

    public void cadastroBiblioteca(){

        Scanner entrada = new Scanner(System.in);
        String nomeBiblioteca;

        System.out.println("Digite o nome da biblioteca:");
        nomeBiblioteca = entrada.next();
        biblioteca.setNomeBiblioteca(nomeBiblioteca);

        bilbiotecaController.cadastroBiblioteca(biblioteca);
    }

    public void listarBibliotecas(){
        List<Biblioteca> retornoBanco = new ArrayList<>();
        int size = bilbiotecaController.listarBibliotecas().size();
        retornoBanco = bilbiotecaController.listarBibliotecas();
        for(int i = 0; i < size; i++){
            System.out.println(retornoBanco.get(i));
        }
    }
}
