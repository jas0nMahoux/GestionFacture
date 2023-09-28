package com.example.application.views.factureview;

import com.example.application.services.ClientService;
import com.example.application.services.FactureService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Liste des factures")
@Route(value = "factures", layout = MainLayout.class)
public class AllFactureView extends VerticalLayout {
    public Text allFactures;

    public FactureService factureService =  new FactureService();

    public AllFactureView() {
        setSpacing(false);

        allFactures = new Text(factureService.findAllFactures().toString());

        add(allFactures);

    }
}
