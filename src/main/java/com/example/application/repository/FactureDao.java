package com.example.application.repository;

import com.example.application.model.Client;
import com.example.application.model.Facture;
import com.example.application.model.LigneArticle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FactureDao {

    public ArrayList<Facture> findAll() {
        var connexion = ConnectionHolder.INSTANCE.getConnection();
        try (var statement = connexion.createStatement()) {
            try (var result = statement.executeQuery("select * from facture;")) {
                return processResultSet(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertFacture(String nameArticle, Float totalPrice, String nameClient, int qte) {
        var connection = ConnectionHolder.INSTANCE.getConnection();
        try (var statement = connection.prepareStatement("INSERT INTO facture ( ID, NAMEARTICLE, TOTALPRICE, NAMECLIENT, QTE) VALUES (0, ?, ?, ?, ?)")) {
            statement.setString(1, nameArticle);
            statement.setFloat(2, totalPrice);
            statement.setString(3, nameClient);
            statement.setInt(4, qte);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Facture> processResultSet(ResultSet result) throws SQLException {
        ArrayList<Facture> listeFacture = new ArrayList<>();
        while (result.next()) {
            var nameArtile = result.getString(2);
            var totalPrice = result.getFloat(3);
            var nameClient = result.getString(4);
            var qte = result.getInt(5);
            Facture facture = new Facture(nameArtile, totalPrice, nameClient, qte);
            listeFacture.add(facture);
        }
        return listeFacture;
    }

}
