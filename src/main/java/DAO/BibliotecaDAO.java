package DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Biblioteca;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDAO {

    private Connection connection;

    public BibliotecaDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void createBilbiotecaTable(){
        String sqlCreate = "CREATE TABLE IF NOT EXISTS `bibliotecas` ( " +
                "`id_bibliotecas` INT NOT NULL AUTO_INCREMENT," +
                "`nome_biblioteca` VARCHAR(20) NOT NULL UNIQUE," +
                "PRIMARY KEY (id_bibliotecas))";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreate);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastroBiblioteca(Biblioteca biblioteca){
        String sqlInsert = "INSERT INTO bibliotecas (nome_biblioteca) VALUES (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, biblioteca.getNomeBiblioteca());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Biblioteca> listarBibliotecas(){
        List<Biblioteca> retornoBanco = new ArrayList<>();
        String sqlSelect = "SELECT * FROM `bibliotecas`";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setIdBiblioteca(resultSet.getInt("id_bibliotecas"));
                biblioteca.setNomeBiblioteca(resultSet.getString("nome_biblioteca"));
                retornoBanco.add(biblioteca);
            }
            return retornoBanco;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Biblioteca selectById(int idSelecionado){
        String sqlSelect = "SELECT id_bibliotecas, nome_biblioteca FROM `bibliotecas` WHERE id_bibliotecas = ?";
        Biblioteca biblioteca = new Biblioteca();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setInt(1, idSelecionado);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                biblioteca.setIdBiblioteca(resultSet.getInt("id_bibliotecas"));
                biblioteca.setNomeBiblioteca(resultSet.getString("nome_biblioteca"));
                return biblioteca;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
