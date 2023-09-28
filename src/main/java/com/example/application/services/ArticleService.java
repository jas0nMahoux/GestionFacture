package com.example.application.services;

import com.example.application.model.Article;
import com.example.application.repository.ArticleDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    public ArticleDao articleDao = new ArticleDao();

    public List<Article> findAllArticle() {
        return articleDao.findAll();
    }

    public void createNewArticle(String nomArticle, float prixArticle) {
        articleDao.insertArticle(nomArticle, prixArticle);
    }

}
