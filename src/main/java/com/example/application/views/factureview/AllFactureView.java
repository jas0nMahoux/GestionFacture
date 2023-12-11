package com.example.application.views.factureview;

import com.example.application.model.Facture;
import com.example.application.services.ClientService;
import com.example.application.services.FactureService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Liste des factures")
@Route(value = "factures", layout = MainLayout.class)
public class AllFactureView extends VerticalLayout {
    public Text allFactures;

    public FactureService factureService =  new FactureService();

    public AllFactureView() {
        setSpacing(false);

        List<Facture> factures = factureService.findAllFactures();

        Grid<Facture> facturesGrid = new Grid<>();
        facturesGrid.setItems(factures);
        facturesGrid.addColumn(Facture::getClientName).setHeader("Client");
        facturesGrid.addColumn(Facture::getLigneArticle).setHeader("Article");
        facturesGrid.addColumn(Facture::getTotal).setHeader("Prix");

        add(facturesGrid);

    }
}
