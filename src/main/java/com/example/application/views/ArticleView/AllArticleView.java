package com.example.application.views.ArticleView;

import com.example.application.model.Article;
import com.example.application.model.Facture;
import com.example.application.services.ArticleService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PageTitle("Liste des articles")
@Route(value = "allArticles", layout = MainLayout.class)
public class AllArticleView extends VerticalLayout {

    public Text allArticle;

    public ArticleService articleService =  new ArticleService();

    public AllArticleView() {
        setSpacing(false);

        List<Article> articles = articleService.findAllArticle();

        Grid<Article> articlesGrid = new Grid<>();
        articlesGrid.setItems(articles);
        articlesGrid.addColumn(Article::getNom).setHeader("Article");
        articlesGrid.addColumn(Article::getPrix).setHeader("Prix");

        add(articlesGrid);
    }

}
