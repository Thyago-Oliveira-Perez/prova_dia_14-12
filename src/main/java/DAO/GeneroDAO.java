package DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Genero;

import java.awt.*;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class GeneroDAO {

    private Connection connection;

    public GeneroDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void createGeneroTable(){
        String sqlCreate = "CREATE TABLE IF NOT EXISTS `generos` ( " +
                "`id_genero` INT NOT NULL AUTO_INCREMENT," +
                "`nome_genero` VARCHAR(20) NOT NULL UNIQUE," +
                "PRIMARY KEY (id_genero))";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCreate);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarGenero(Genero genero){
        String sqlInsert = "INSERT INTO `generos` (nome_genero) VALUES (?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, genero.getNomeGenero());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Genero> listarGeneros(){
        List<Genero> retornoBanco = new ArrayList<>();
        Genero genero = new Genero();
        String sqlSelect = "SELECT * FROM `generos`";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                genero.setIdGenero(resultSet.getInt("id_genero"));
                genero.setNomeGenero(resultSet.getString("nome_genero"));
                retornoBanco.add(genero);
            }
            return retornoBanco;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void editarGenero(Genero genero){
        String sqlUpdate = "UPDATE generos SET `nome_genero` = ? WHERE `id_genero` = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, genero.getNomeGenero());
            preparedStatement.setInt(2, genero.getIdGenero());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Genero getById(int idSelecionado){
        String sqlSelectById = "SELECT * FROM `generos` WHERE id_genero = ?";
        Genero genero1 = new Genero();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectById);
            preparedStatement.setInt(1, idSelecionado);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                genero1.setIdGenero(resultSet.getInt("id_genero"));
                genero1.setNomeGenero(resultSet.getString("nome_genero"));
            }
            return genero1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
