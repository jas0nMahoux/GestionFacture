package com.example.application.views.ArticleView;

import com.example.application.services.ArticleService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Liste des articles")
@Route(value = "allArticles", layout = MainLayout.class)
public class AllArticleView extends VerticalLayout {

    public Text allArticle;

    public ArticleService articleService = new ArticleService();

    public AllArticleView() {
        setSpacing(false);

        allArticle = new Text(articleService.findAllArticle().toString());

        add(allArticle);

    }

}
