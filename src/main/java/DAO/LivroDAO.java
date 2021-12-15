package DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Livro;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private Connection connection;

    public LivroDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void createLivroTable(){
        String sqlCreate = "CREATE TABLE IF NOT EXISTS `livros` ( " +
                "`id_livro` INT NOT NULL AUTO_INCREMENT," +
                "`nome_livro` VARCHAR(20)," +
                "`id_genero` INT NOT NULL ," +
                "`id_biblioteca` INT NOT NULL ," +
                "PRIMARY KEY (id_livro), " +
                "CONSTRAINT fk_id_genero FOREIGN KEY (id_genero)" +
                "REFERENCES generos (id_genero)," +
                "CONSTRAINT fk_id_biblioteca FOREIGN KEY (id_biblioteca)" +
                "REFERENCES bibliotecas (id_bibliotecas)" +
                "ON DELETE CASCADE " +
                "ON UPDATE CASCADE)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreate);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarLivro(Livro livro){
        String sqlInsert = "INSERT INTO `livros` (nome_livro, id_genero, id_biblioteca) VALUES (?, ?, ?) ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, livro.getNomeLivro());
            preparedStatement.setInt(2, livro.getIdGenero());
            preparedStatement.setInt(3, livro.getIdBilbioteca());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> listarLivros(){
        List<Livro> retornoBanco = new ArrayList<>();
        Livro livro = new Livro();
        String sqlSelect = "SELECT * FROM `livros`";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                livro.setIdLivro(resultSet.getInt("id_livro"));
                livro.setNomeLivro(resultSet.getString("nome_livro"));
                livro.setIdGenero(resultSet.getInt("id_genero"));
                livro.setIdBilbioteca(resultSet.getInt("id_biblioteca"));
                retornoBanco.add(livro);
            }
            return retornoBanco;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Livro> listarLivrosByIdBiblioteca(int idSelecionado){
        List<Livro> retornoBanco = new ArrayList<>();
        Livro livro = new Livro();
        String sqlSelect = "SELECT * FROM `livros` WHERE id_biblioteca = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setInt(1, idSelecionado);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                livro.setIdLivro(resultSet.getInt("id_livro"));
                livro.setNomeLivro(resultSet.getString("nome_livro"));
                livro.setIdGenero(resultSet.getInt("id_genero"));
                livro.setIdBilbioteca(resultSet.getInt("id_biblioteca"));
                retornoBanco.add(livro);
            }
            return retornoBanco;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
