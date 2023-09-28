package com.example.application.views.clientview;

import com.example.application.repository.ArticleDao;
import com.example.application.repository.ClientDao;
import com.example.application.services.ClientService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Créer un client")
@Route(value = "client", layout = MainLayout.class)
public class ClientView extends VerticalLayout {

    private TextField name;

    private TextField prenom;

    private NumberField numTel;

    private Button create;

    public ClientService clientService = new ClientService();

    public ClientView() {
        setSpacing(false);

        name  = new TextField("Nom du client");
        prenom = new TextField("Prenom du client");
        numTel = new NumberField("Numéro de téléphone du client");
        create = new Button("Créer");

        create.addClickListener(buttonClickEvent -> {
            Notification.show("Client créé");
            clientService.createNewClient(name.getValue(), prenom.getValue(), numTel.getValue().intValue());
        });

        add(name, prenom, numTel, create);

    }
}
