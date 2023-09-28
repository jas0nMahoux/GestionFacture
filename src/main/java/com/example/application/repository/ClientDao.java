package com.example.application.repository;

import com.example.application.model.Article;
import com.example.application.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDao {

    public ArrayList<Client> findAll() {
        var connexion = ConnectionHolder.INSTANCE.getConnection();
        try (var statement = connexion.createStatement()) {
            try (var result = statement.executeQuery("select * from client;")) {
                return processResultSet(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertClient(String nomClient, String prenomClient, long numTel) {
        var connection = ConnectionHolder.INSTANCE.getConnection();
        try (var statement = connection.prepareStatement("INSERT INTO client ( ID, NOM, PRENOM, NUMTEL) VALUES (0, ?, ?, ?)")) {
            statement.setString(1, nomClient);
            statement.setString(2, prenomClient);
            statement.setLong(3, numTel);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Client> processResultSet(ResultSet result) throws SQLException {
        ArrayList<Client> listeClient = new ArrayList<>();
        while (result.next()) {
            var nom = result.getString(3);
            var prenom = result.getString(2);
            var numtel = result.getLong(4);
            Client client = new Client(nom, prenom, numtel);
            listeClient.add(client);
        }
        return listeClient;
    }

}
