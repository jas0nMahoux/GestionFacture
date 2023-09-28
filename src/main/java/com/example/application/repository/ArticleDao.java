package com.example.application.repository;

import com.example.application.model.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticleDao {

    public ArrayList<Article> findAll() {
        var connexion = ConnectionHolder.INSTANCE.getConnection();
        try (var statement = connexion.createStatement()) {
            try (var result = statement.executeQuery("select * from article;")) {
                return processResultSet(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertArticle(String nomArticle, float prixArticle) {
        var connection = ConnectionHolder.INSTANCE.getConnection();
        try (var statement = connection.prepareStatement("INSERT INTO article ( ID, NOM, PRIX) VALUES (0, ?, ?)")) {
            statement.setString(1, nomArticle);
            statement.setFloat(2, prixArticle);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Article> processResultSet(ResultSet result) throws SQLException {
        ArrayList<Article> listeArticle = new ArrayList<>();
        while (result.next()) {
            var nom = result.getString(2);
            var prix = result.getFloat(3);
            Article article = new Article.Builder()
                    .setNom(nom).setPrix(prix).setId(3).build();
            listeArticle.add(article);
        }
        return listeArticle;
    }

}
