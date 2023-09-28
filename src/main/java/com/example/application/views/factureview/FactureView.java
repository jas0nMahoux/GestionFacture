package com.example.application.views.factureview;

import com.example.application.model.Article;
import com.example.application.model.Client;
import com.example.application.model.Facture;
import com.example.application.services.ArticleService;
import com.example.application.services.ClientService;
import com.example.application.services.FactureService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Créer une facture")
@Route(value = "facture", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class FactureView extends VerticalLayout {

    public ArticleService articleService = new ArticleService();

    public ClientService clientService = new ClientService();

    public FactureService factureService = new FactureService();

    public FactureView() {

        HorizontalLayout horizontalLayoutArticle = new HorizontalLayout();

        ComboBox<Article> comboBox = new ComboBox<>("Choisir un article");
        comboBox.setItems(articleService.findAllArticle());
        comboBox.setItemLabelGenerator(Article::getNom);

        horizontalLayoutArticle.add(comboBox);

        NumberField price = new NumberField("Prix");
        horizontalLayoutArticle.add(price);

        comboBox.addClientValidatedEventListener(e -> {
            price.setValue(((double) comboBox.getValue().getPrix()));
            price.setEnabled(false);
        });

        NumberField quantite = new NumberField("Quantité");

        ComboBox<Client> comboBoxClient = new ComboBox<>("Facture pour le client");
        comboBoxClient.setItems(clientService.findAllClient());
        comboBoxClient.setItemLabelGenerator(Client::getNom);

        Button button = new Button("Creer la facture");

        button.addClickListener(e -> {
            factureService.createNewFacture(comboBox.getValue().getNom(), comboBox.getValue().getPrix() *  quantite.getValue().intValue(), comboBoxClient.getValue().getNom(), quantite.getValue().intValue());
            Notification.show("Facture créé");
            comboBox.setValue(null);
            comboBoxClient.setValue(null);
            quantite.setValue(null);
            price.setValue(null);
        });

        add(horizontalLayoutArticle, quantite, comboBoxClient, button);
    }

}
