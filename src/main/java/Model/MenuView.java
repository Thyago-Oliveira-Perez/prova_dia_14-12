package Model;

import Controller.BilbiotecaController;
import Controller.GeneroController;
import View.BibliotecaView;
import View.GeneroView;
import View.LivroVIEW;

import java.util.Scanner;

public class MenuView {

    Scanner entrada = new Scanner(System.in);
    BibliotecaView bibliotecaView = new BibliotecaView();
    BilbiotecaController bilbiotecaController = new BilbiotecaController();
    GeneroView generoView = new GeneroView();
    LivroVIEW livroVIEW = new LivroVIEW();
    GeneroController generoController = new GeneroController();

    public void MainMenu(){
        int opcao = 0;
        System.out.println("------------BEM VINDO------------");
        System.out.println("1 - Cadastrar Biblioteca\n2 - Listar Bibliotecas\n3 - Selecionar Biblioteca\n0 - Sair do Programa");
        opcao = entrada.nextInt();
        if(opcao == 1){
            bibliotecaView.cadastroBiblioteca();
            MainMenu();
        }else if(opcao == 2){
            bibliotecaView.listarBibliotecas();
            MainMenu();
        }else if(opcao == 3){
            System.out.println("Selecione a Biblioteca:");
            bibliotecaView.listarBibliotecas();
            int idSelecionado = entrada.nextInt();
            System.out.println(bilbiotecaController.selectById(idSelecionado));
            System.out.println("1 - Listar Livros\n2 - Ir para Menu de Generos");
            int escolha = entrada.nextInt();
            if(escolha == 1){
                livroVIEW.listarLivrosByIdBiblioteca(bilbiotecaController.selectById(idSelecionado).getIdBiblioteca());
                MainMenu();
            }else if(escolha == 2){
                menuGeneros(bilbiotecaController.selectById(idSelecionado));
            }
        }else if(opcao == 0){
            System.exit(0);
        }
    }

        public void menuGeneros(Biblioteca biblioteca){
            int opcao;
            System.out.println("1 - Cadastrar Genero\n2 - Editar Genero\n3 - Listar Generos\n4 - Selecionar Genero\n0 - Sair Para Menu Principal");
            opcao = entrada.nextInt();
            if(opcao == 1){
                generoView.cadastrarGenero();
                menuGeneros(biblioteca);
            }else if(opcao == 2){
                generoView.editarGenero();
                menuGeneros(biblioteca);
            }else if(opcao == 3){
                generoView.listarGeneros();
                menuGeneros(biblioteca);
            }else if(opcao == 4){
                System.out.println("Escolha o genero do Livro:");
                generoView.listarGeneros();
                int idSelecionado = entrada.nextInt();
                System.out.println("Genero Selecionado  " + generoController.getById(idSelecionado));
                System.out.println("1 - Cadastrar Livro\n2 - Listar Livros\n3 - Voltar");
                opcao = entrada.nextInt();
                if(opcao == 1){
                    livroVIEW.cadastrarGenero(biblioteca, generoController.getById(idSelecionado));
                    menuGeneros(biblioteca);
                }else if(opcao == 2){
                    livroVIEW.listarLivros();
                    menuGeneros(biblioteca);
                }else if(opcao == 3){
                    menuGeneros(biblioteca);
                }
            }else if(opcao == 0){
                MainMenu();
            }
        }

    }

