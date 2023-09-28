package com.example.application.views.clientview;

import com.example.application.services.ArticleService;
import com.example.application.services.ClientService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Liste des clients")
@Route(value = "clients", layout = MainLayout.class)
public class AllClientView extends VerticalLayout {

    public Text allClients;

    public ClientService clientService =  new ClientService();

    public AllClientView() {
        setSpacing(false);

        clientService.findAllClient().forEach(client -> {
            Text textClient = new Text(client.getNom() + " " + client.getPrenom() + " " + client.getNumeroTelephone());
            add(textClient);
        });

    }

}
