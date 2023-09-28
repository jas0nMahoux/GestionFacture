package com.example.application.views.factureview;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Créer une facture")
@Route(value = "facture", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class FactureView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    private TextField client;
    private Button choose;

    public FactureView() {
        name = new TextField("Article");
        sayHello = new Button("Choisir");

        client = new TextField("Client");
        choose = new Button("Choisir");

        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });
        sayHello.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);
        setVerticalComponentAlignment(Alignment.END, client, choose);

        add(name, sayHello, client, choose);
    }

}
