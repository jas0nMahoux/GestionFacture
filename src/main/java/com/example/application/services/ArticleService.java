package com.example.application.services;

import com.example.application.model.Article;
import com.example.application.repository.ArticleRepository;

import java.util.ArrayList;

public class ArticleService {

    public ArticleRepository articleRepository = new ArticleRepository();

    public ArrayList<Article> findAllArticle() {
        return articleRepository.findAll();
    }

}
