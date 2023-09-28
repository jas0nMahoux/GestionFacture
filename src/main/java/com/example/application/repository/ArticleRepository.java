package com.example.application.repository;

import com.example.application.model.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticleRepository {

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

    private ArrayList<Article> processResultSet(ResultSet result) throws SQLException {
        ArrayList<Article> listeArticle = new ArrayList<>();
        while (result.next()) {
            //var id = result.getInt(1);
            var name = result.getString(1);
            var price = result.getInt(2);
            Article article = new Article.Builder()
                    .setId(0).setNom(name).setPrix(price).build();
            listeArticle.add(article);
        }
        return listeArticle;
    }

}
