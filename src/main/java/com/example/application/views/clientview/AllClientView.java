package com.example.application.views.clientview;

import com.example.application.model.Article;
import com.example.application.model.Client;
import com.example.application.services.ArticleService;
import com.example.application.services.ClientService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@PageTitle("Liste des clients")
@Route(value = "clients", layout = MainLayout.class)
public class AllClientView extends VerticalLayout {

    public Text allClients;

    public ClientService clientService =  new ClientService();

    public AllClientView() {
        setSpacing(false);

        List<Client> clients = clientService.findAllClient();

        Grid<Client> clientGrid = new Grid<>();
        clientGrid.setItems(clients);
        clientGrid.addColumn(Client::getNom).setHeader("Nom");
        clientGrid.addColumn(Client::getPrenom).setHeader("Prénom");
        clientGrid.addColumn(Client::getNumeroTelephone).setHeader("Téléphone");

        add(clientGrid);

    }

}
