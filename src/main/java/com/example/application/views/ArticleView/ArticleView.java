package com.example.application.views.ArticleView;

import com.example.application.services.ArticleService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Créer un article")
@Route(value = "article", layout = MainLayout.class)
public class ArticleView extends VerticalLayout {

    private TextField name;

    private NumberField price;

    private Button create;

    public ArticleView() {
        setSpacing(false);

        name  = new TextField("Nommer l'article");
        price = new NumberField("Donner un prix à l'article");
        create = new Button("Créer");

        create.addClickListener(buttonClickEvent -> {
            Notification.show("Article créé");
        });

        add(name, price, create);

    }

}
