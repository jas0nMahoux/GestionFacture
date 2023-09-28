package com.example.application.views.ArticleView;

import com.example.application.services.ArticleService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Liste des articles")
@Route(value = "allArticles", layout = MainLayout.class)
public class AllArticleView extends VerticalLayout {

    public Text allArticle;

    public ArticleService articleService =  new ArticleService();

    public AllArticleView() {
        setSpacing(false);

        VerticalLayout verticalLayout = new VerticalLayout();

        articleService.findAllArticle().forEach(article -> {
            Text textArticle = new Text(article.getNom() + " " + article.getPrix() + " ");
            verticalLayout.add(textArticle);
        });
        add(verticalLayout);
    }

}
